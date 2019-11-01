#!/usr/bin/env bash
LANG=zh_CN.UTF-8
##############################################################################
##
##  WeBASE-Codegen-Monkey start up script for UN*X.
##  WeBASE-Codegen-Monkey is an automatic code Generator. 
##
##  created by jiayumao
##
##############################################################################

# functions
function prop {
    grep "${1}" application.properties|cut -d'=' -f2
}

function is_empty_dir(){ 
    ls -A $1|wc -w
}

function LOG_ERROR()
{
    local content=${1}
    echo -e "\033[31m"${content}"\033[0m"
}

# @function: output information log
# @param: content: information message
function LOG_INFO()
{
    local content=${1}
    echo -e "\033[32m"${content}"\033[0m"
}

function check_java(){
   version=$($JAVACMD -version 2>&1 |grep version |awk '{print $3}')
   len=${#version}-2
   version=${version:1:len}

   IFS='.' arr=($version)
   IFS=' '
   if [ -z ${arr[0]} ];then
      LOG_ERROR "At least Java8 is required."
      exit 1
   fi
   if [ ${arr[0]} -eq 1 ];then
      if [ ${arr[1]} -lt 8 ];then
           LOG_ERROR "At least Java8 is required."
           exit 1
      fi
   elif [ ${arr[0]} -gt 8 ];then
          :
   else
       LOG_ERROR "At least Java8 is required."
       exit 1
   fi
}


#### valid input args
EXEC_OPTION="run"
RUN_OPTION="run"
BUILD_OPTION="build"

case "$1" in
    'run')
        EXEC_OPTION=$RUN_OPTION
        ;;
    'RUN')
        EXEC_OPTION=$RUN_OPTION
        ;;
    'build')
        EXEC_OPTION=$BUILD_OPTION
        ;;
    'BUILD')
        EXEC_OPTION=$BUILD_OPTION
        ;;
    *)
        LOG_ERROR "invalid option! default run!"
        EXEC_OPTION=$RUN_OPTION
esac

LOG_INFO "EXEC_OPTION: $EXEC_OPTION [ build|run ]"

#### config props
APPLICATION_FILE="config/resources/application.properties"
APPLICATION_TMP_FILE="config/resources/application.properties.tmp"
CONTRACT_DIR="config/contract"
CERT_DIR="config/resources"
RESOURCE_DIR="src/main/resources"
JAVA_CODE_DIR="src/main/java"
BUILD_DIR="dist"

BM="WeBASE-Codegen-Monkey"
BB="WeBASE-Collect-Bee"
BBCOMMON="WeBASE-Collect-Bee-common"
BBC="WeBASE-Collect-Bee-core"

#### check the config file exists.
if [ -f "$APPLICATION_FILE" ];then
  LOG_INFO "Check [appliction.properties] done."
else
  LOG_ERROR "The config file [appliction.properties] doesn't exist. Please don't delete it."
  exit 1
fi
if [ -d "$CONTRACT_DIR" ];then
  LOG_INFO "Check [contracts] done."
else
  LOG_ERROR "The config dir [contracts] doesn't exist. Please don't delete it."
  exit 1
fi
if [ "`ls -A $CONTRACT_DIR`" = "" ]; then
  LOG_ERROR "$CONTRACT_DIR is indeed empty"
  exit 1
fi
if [ -d "$CERT_DIR" ];then
  LOG_INFO "Check [resources] done."
else
  LOG_ERROR "The config dir [resources] doesn't exist. Please don't delete it."
  exit 1
fi
if [ "`ls -A $CERT_DIR`" = "" ]; then
  LOG_ERROR "$CERT_DIR is indeed empty"
  exit 1
fi

# Begin to read parameters from application.properties
if [ -f "$APPLICATION_FILE" ]
then
  LOG_INFO "$APPLICATION_FILE exist."
  grep -v "^#"  $APPLICATION_FILE | grep -v "^$" | grep "="  > $APPLICATION_TMP_FILE

  while IFS='=' read -r key value
  do
    key=$(echo $key | tr '.' '_')
    eval "${key}='${value}'"
  done < "$APPLICATION_TMP_FILE"
  rm -f $APPLICATION_TMP_FILE
else
  LOG_ERROR "$APPLICATION_FILE not found."
  exit 1
fi

LOG_INFO "system.contractPackName =  ${system_contractPackName} "
LOG_INFO "system.group            =  ${system_group} "
LOG_INFO "server.port             =  ${server_port} "

# check the environment
## check server port is used
check_port() {
        LOG_INFO "Checking instance port ..."
        netstat -tlpn | grep "\b$1\b"
}
if check_port $server_port
then
        LOG_ERROR "ERROR: the port of server is used, please check it or modify server.port in application.properties."
    exit 1
fi

# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD="$JAVA_HOME/jre/sh/java"
    else
        JAVACMD="$JAVA_HOME/bin/java"
    fi
    if [ ! -x "$JAVACMD" ] ; then
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME
Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
    fi
else
    JAVACMD="java"
    which java >/dev/null 2>&1 || die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
fi
LOG_INFO "JAVACMD: $JAVACMD"

## check the version of Java
check_java

contractPath=$(echo ${system_contractPackName} | tr '.' '/')
LOG_INFO "contractPath: $contractPath"
group=$(echo ${system_group} | tr '.' '/')
LOG_INFO "group: $group"

rm -rf $BM
git clone https://github.com/WeBankFinTech/$BM.git
cd $BM

git checkout V1.2.0
cd ..

rm -rf $BB
git clone https://github.com/WeBankFinTech/$BB.git
cd $BB
git checkout V1.2.0
cd ..

# init config
cd $BM
mkdir -p $RESOURCE_DIR/
cp -f ../$APPLICATION_FILE $RESOURCE_DIR/
LOG_INFO "copy application.properties done."
mkdir -p $JAVA_CODE_DIR/$contractPath
cp -f ../$CONTRACT_DIR/* $JAVA_CODE_DIR/$contractPath/
mkdir -p ./$CONTRACT_DIR
cp -f ../$CONTRACT_DIR/* ./$CONTRACT_DIR
LOG_INFO "copy java contract codes done."

# build
bash gradlew clean bootJar
LOG_INFO "$BM build done"

# run
cd $BUILD_DIR
chmod +x WeBASE*
$JAVACMD -jar WeBASE* 
LOG_INFO "$BB generate done."
cd ../../
rm -rf $BM

cd $BB
cd $BBC
mkdir -p $RESOURCE_DIR/
cp -f  ../../$CERT_DIR/ca.crt $RESOURCE_DIR/
# cp -f  ../$CERT_DIR/client.keystore $RESOURCE_DIR/
cp -f  ../../$CERT_DIR/node.crt $RESOURCE_DIR/
cp -f  ../../$CERT_DIR/node.key $RESOURCE_DIR/

LOG_INFO "copy certs done."
mkdir -p ../$BBCOMMON/$JAVA_CODE_DIR/$contractPath
cp -f ../../$CONTRACT_DIR/* ../$BBCOMMON/$JAVA_CODE_DIR/$contractPath/
mkdir -p ./$CONTRACT_DIR
cp -f ../../$CONTRACT_DIR/* ./$CONTRACT_DIR
LOG_INFO "copy java contract codes done."


cd ..
bash gradlew clean bootJar

LOG_INFO "$BB build done"


if [ "$EXEC_OPTION" == "$RUN_OPTION" ];then
cd $BBC/$BUILD_DIR
chmod +x WeBASE*
$JAVACMD -jar WeBASE* 
fi


