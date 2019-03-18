#!/usr/bin/env bash
LANG=zh_CN.UTF-8
##############################################################################
##
##  webase-monkey start up script for UN*X.
##  webase-monkey is an automatic code Generator. 
##
##  created by jiayumao
##
##############################################################################

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
        echo "invalid option! default run!"
        EXEC_OPTION=$RUN_OPTION
esac

echo "EXEC_OPTION: $EXEC_OPTION {build|run}"

#### config props
APPLICATION_FILE="config/application.properties"
CONTRACT_DIR="config/contract"
CERT_DIR="config/resources"
RESOURCE_DIR="src/main/resources"
JAVA_CODE_DIR="src/main/java"
BUILD_DIR="dist"

BM="webase-monkey"
BB="webase-bee"

#### check the config file exists.
if [ -f "$APPLICATION_FILE" ];then
  echo "Check [appliction.properties] done."
else
  echo "The config file [appliction.properties] doesn't exist. Please don't delete it."
  exit 1
fi
if [ -d "$CONTRACT_DIR" ];then
  echo "Check [contracts] done."
else
  echo "The config dir [contracts] doesn't exist. Please don't delete it."
  exit 1
fi
if [ "`ls -A $CONTRACT_DIR`" = "" ]; then
  echo "$CONTRACT_DIR is indeed empty"
  exit 1
fi
if [ -d "$CERT_DIR" ];then
  echo "Check [resources] done."
else
  echo "The config dir [resources] doesn't exist. Please don't delete it."
  exit 1
fi
if [ "`ls -A $CERT_DIR`" = "" ]; then
  echo "$CERT_DIR is indeed empty"
  exit 1
fi

# Begin to read parameters from application.properties
if [ -f "$APPLICATION_FILE" ]
then
  echo "$APPLICATION_FILE exist."

  while IFS='=' read -r key value
  do
    key=$(echo $key | tr '.' '_')
    eval "${key}='${value}'"
  done < "$APPLICATION_FILE"
else
  echo "$APPLICATION_FILE not found."
  exit 1
fi

echo "system.contractPackName = " ${system_contractPackName}
echo "system.group            = " ${system_group}

contractPath=$(echo ${system_contractPackName} | tr '.' '/')
echo "contractPath: "$contractPath
group=$(echo ${system_group} | tr '.' '/')
echo "group: "$group

# download webase-monkey
rm -rf $BM
git clone git@gitee.com:maoplus/$BM.git
cd $BM
git checkout master
cd ..

# download webase-bee
rm -rf $BB
git clone git@gitee.com:maoplus/$BB.git
cd $BB
git checkout master
cd ..

# init config
cd webase-monkey
mkdir -p $RESOURCE_DIR/
cp -f ../$APPLICATION_FILE $RESOURCE_DIR/
echo "copy application.properties done."
mkdir -p $JAVA_CODE_DIR/$contractPath
cp -f ../$CONTRACT_DIR/* $JAVA_CODE_DIR/$contractPath/
mkdir -p ./$CONTRACT_DIR
cp -f ../$CONTRACT_DIR/* ./$CONTRACT_DIR
echo "copy java contract codes done."

# build
sh gradlew clean bootJar
echo "webase-monkey build done"

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
echo "JAVACMD: $JAVACMD"
#exec $JAVACMD -jar dist/

# run
cd $BUILD_DIR
chmod +x webase*
$JAVACMD -jar webase* 
echo "webase-bee generate done."
cd ../../
rm -rf webase-monkey

cd webase-bee
mkdir -p $RESOURCE_DIR/
cp -f  ../$CERT_DIR/* $RESOURCE_DIR/
echo "copy certs done."
mkdir -p $JAVA_CODE_DIR/$contractPath
cp -f ../$CONTRACT_DIR/* $JAVA_CODE_DIR/$contractPath/
mkdir -p ./$CONTRACT_DIR
cp -f ../$CONTRACT_DIR/* ./$CONTRACT_DIR
echo "copy java contract codes done."

sh gradlew clean bootJar

echo "webase-bee build done"


if [ "$EXEC_OPTION" == "$RUN_OPTION" ];then
cd $BUILD_DIR
chmod +x webase*
$JAVACMD -jar webase* 
fi

function prop {
    grep "${1}" application.properties|cut -d'=' -f2
}

function is_empty_dir(){ 
    ls -A $1|wc -w
}
