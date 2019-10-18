/**
 * Copyright 2014-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.webank.webasemonkey.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


/**
 * Web3jTypeEnum defines the conversation method of solidity type, sql type and java type, which is pivotal to the data
 * types.
 *
 * @author maojiayu
 * @data Dec 28, 2018 3:20:48 PM
 *
 */
@AllArgsConstructor
@Getter
@Slf4j
public enum Web3jTypeEnum {
    UTF8STRING("Utf8String", "varchar(128)", "String", "String.valueOf"),
    ADDRESS("Address", "varchar(255)", "String", "AddressUtils.bigIntegerToString"),
    INT8("Int8", "tinyint","int", "BigIntegerUtils.toInteger"),
    UINT8("Uint8", "tinyint","int", "BigIntegerUtils.toInteger"),
    INT16("Int16", "smallint", "int", "BigIntegerUtils.toInteger"),
    UINT16("Uint16", "smallint", "int", "BigIntegerUtils.toInteger"),
    INT24("Int24", "smallint", "int", "BigIntegerUtils.toInteger"),
    UINT24("Uint24", "smallint", "int", "BigIntegerUtils.toInteger"),
    INT32("Int32", "int", "int", "BigIntegerUtils.toInteger"),
    UINT32("Uint32", "int", "int", "BigIntegerUtils.toInteger"),
    INT40("Int40", "int", "int", "BigIntegerUtils.toInteger"),
    UINT40("Uint40", "int", "int", "BigIntegerUtils.toInteger"),
    INT48("Int48", "int", "int", "BigIntegerUtils.toInteger"),
    UINT48("Uint48", "int", "int", "BigIntegerUtils.toInteger"),
    INT56("Int56", "int", "int", "BigIntegerUtils.toInteger"),
    UINT56("Uint56", "int", "int", "BigIntegerUtils.toInteger"),
    INT64("Int64", "bigint", "long","BigIntegerUtils.toLong"),
    UINT64("Uint64", "bigint", "long","BigIntegerUtils.toLong"),
    INT72("Int72", "bigint", "long","BigIntegerUtils.toLong"),
    UINT72("Uint72", "bigint", "long","BigIntegerUtils.toLong"),
    INT80("Int80", "bigint", "long","BigIntegerUtils.toLong"),
    UINT80("Uint80", "bigint", "long","BigIntegerUtils.toLong"),
    INT88("Int88", "bigint", "long","BigIntegerUtils.toLong"),
    UINT88("Uint88", "bigint", "long","BigIntegerUtils.toLong"),
    INT96("Int96", "bigint", "long","BigIntegerUtils.toLong"),
    UINT96("Uint96", "bigint", "long","BigIntegerUtils.toLong"),
    INT104("Int104", "bigint", "long","BigIntegerUtils.toLong"),
    UINT104("Uint104", "bigint", "long","BigIntegerUtils.toLong"),
    INT112("Int112", "bigint", "long","BigIntegerUtils.toLong"),
    UINT112("Uint112", "bigint", "long","BigIntegerUtils.toLong"),
    INT120("Int120", "bigint", "long","BigIntegerUtils.toLong"),
    UINT120("Uint120", "bigint", "long","BigIntegerUtils.toLong"),
    INT128("Int128", "bigint", "long","BigIntegerUtils.toLong"),
    UINT128("Uint128", "bigint", "long","BigIntegerUtils.toLong"),
    INT136("Int136", "bigint", "long","BigIntegerUtils.toLong"),
    UINT136("Uint136", "bigint", "long","BigIntegerUtils.toLong"),
    INT144("Int144", "bigint", "long","BigIntegerUtils.toLong"),
    UINT144("Uint144", "bigint", "long","BigIntegerUtils.toLong"),
    INT152("Int152", "bigint", "long","BigIntegerUtils.toLong"),
    UINT152("Uint152", "bigint", "long","BigIntegerUtils.toLong"),
    INT160("Int160", "bigint", "long","BigIntegerUtils.toLong"),
    UINT160("Uint160", "bigint", "long","BigIntegerUtils.toLong"),
    INT168("Int168", "bigint", "long","BigIntegerUtils.toLong"),
    UINT168("Uint168", "bigint", "long","BigIntegerUtils.toLong"),
    INT176("Int176", "bigint", "long","BigIntegerUtils.toLong"),
    UINT176("Uint176", "bigint", "long","BigIntegerUtils.toLong"),
    INT184("Int184", "bigint", "long","BigIntegerUtils.toLong"),
    UINT184("Uint184", "bigint", "long","BigIntegerUtils.toLong"),
    INT192("Int192", "bigint", "long","BigIntegerUtils.toLong"),
    UINT192("Uint192", "bigint", "long","BigIntegerUtils.toLong"),
    INT200("Int200", "bigint", "long","BigIntegerUtils.toLong"),
    UINT200("Uint200", "bigint", "long","BigIntegerUtils.toLong"),
    INT208("Int208", "bigint", "long","BigIntegerUtils.toLong"),
    UINT208("Uint208", "bigint", "long","BigIntegerUtils.toLong"),
    INT216("Int216", "bigint", "long","BigIntegerUtils.toLong"),
    UINT216("Uint216", "bigint", "long","BigIntegerUtils.toLong"),
    INT224("Int224", "bigint", "long","BigIntegerUtils.toLong"),
    UINT224("Uint224", "bigint", "long","BigIntegerUtils.toLong"),
    INT232("Int232", "bigint", "long","BigIntegerUtils.toLong"),
    UINT232("Uint232", "bigint", "long","BigIntegerUtils.toLong"),
    INT240("Int240", "bigint", "long","BigIntegerUtils.toLong"),
    UINT240("Uint240", "bigint", "long","BigIntegerUtils.toLong"),
    INT248("Int248", "bigint", "long","BigIntegerUtils.toLong"),
    UINT248("Uint248", "bigint", "long","BigIntegerUtils.toLong"),
    INT256("Int256", "bigint", "long","BigIntegerUtils.toLong"),
    UINT256("Uint256", "bigint", "long","BigIntegerUtils.toLong"),
    Bytes("Bytes", "varchar(8)", "String", "BytesUtils.bytesArrayToString"),
    Bytes1("Bytes1", "varchar(8)", "String", "BytesUtils.bytesArrayToString"),
    Bytes2("Bytes2", "varchar(16)", "String", "BytesUtils.bytesArrayToString"),
    Bytes3("Bytes3", "varchar(24)", "String", "BytesUtils.bytesArrayToString"),
    Bytes4("Bytes4", "varchar(32)", "String", "BytesUtils.bytesArrayToString"),
    Bytes5("Bytes5", "varchar(40)", "String", "BytesUtils.bytesArrayToString"),
    Bytes6("Bytes6", "varchar(48)", "String", "BytesUtils.bytesArrayToString"),
    Bytes7("Bytes7", "varchar(56)", "String", "BytesUtils.bytesArrayToString"),
    Bytes8("Bytes8", "varchar(64)", "String", "BytesUtils.bytesArrayToString"),
    Bytes9("Bytes9", "varchar(72)", "String", "BytesUtils.bytesArrayToString"),
    Bytes10("Bytes10", "varchar(80)", "String", "BytesUtils.bytesArrayToString"),
    Bytes11("Bytes11", "varchar(88)", "String", "BytesUtils.bytesArrayToString"),
    Bytes12("Bytes12", "varchar(96)", "String", "BytesUtils.bytesArrayToString"),
    Bytes13("Bytes13", "varchar(104)", "String", "BytesUtils.bytesArrayToString"),
    Bytes14("Bytes14", "varchar(112)", "String", "BytesUtils.bytesArrayToString"),
    Bytes15("Bytes15", "varchar(120)", "String", "BytesUtils.bytesArrayToString"),
    Bytes16("Bytes16", "varchar(128)", "String", "BytesUtils.bytesArrayToString"),
    Bytes17("Bytes17", "varchar(136)", "String", "BytesUtils.bytesArrayToString"),
    Bytes18("Bytes18", "varchar(144)", "String", "BytesUtils.bytesArrayToString"),
    Bytes19("Bytes19", "varchar(152)", "String", "BytesUtils.bytesArrayToString"),
    Bytes20("Bytes20", "varchar(160)", "String", "BytesUtils.bytesArrayToString"),
    Bytes21("Bytes21", "varchar(168)", "String", "BytesUtils.bytesArrayToString"),
    Bytes22("Bytes22", "varchar(176)", "String", "BytesUtils.bytesArrayToString"),
    Bytes23("Bytes23", "varchar(184)", "String", "BytesUtils.bytesArrayToString"),
    Bytes24("Bytes24", "varchar(192)", "String", "BytesUtils.bytesArrayToString"),
    Bytes25("Bytes25", "varchar(200)", "String", "BytesUtils.bytesArrayToString"),
    Bytes26("Bytes26", "varchar(208)", "String", "BytesUtils.bytesArrayToString"),
    Bytes27("Bytes27", "varchar(216)", "String", "BytesUtils.bytesArrayToString"),
    Bytes28("Bytes28", "varchar(224)", "String", "BytesUtils.bytesArrayToString"),
    Bytes29("Bytes29", "varchar(232)", "String", "BytesUtils.bytesArrayToString"),
    Bytes30("Bytes30", "varchar(240)", "String", "BytesUtils.bytesArrayToString"),
    Bytes31("Bytes31", "varchar(248)", "String", "BytesUtils.bytesArrayToString"),
    Bytes32("Bytes32", "varchar(256)", "String", "BytesUtils.bytesArrayToString"), 
    STATICARRAY("StaticArray","text","String","BytesUtils.bytes32ListToString"),
    STATICARRAYBYTES32("StaticArray<Bytes32>","text","String","BytesUtils.bytes32ListToString"),
    STATICARRAYADDRESS("StaticArray<Address>","text","String","AddressUtils.staticArrayToString"),
    STATICARRAYINT256("StaticArray<Int256>","varchar(1024)","String","BytesUtils.int256DynamicArrayToString"),
    STATICARRAYUINT256("StaticArray<Uint256>","varchar(1024)","String","BytesUtils.uint256ArrayToString"),
    DYNAMICBYTES("DynamicBytes", "varchar(512)", "String", "BytesUtils.bytesArrayToString"),
    DYNAMICARRAY("DynamicArray","text","String","String.valueOf"),
    DYNAMICARRAYADDRESS("DynamicArray<Address>","text","String","String.valueOf"),
    DYNAMICARRAYBYTES32("DynamicArray<Bytes32>","varchar(1024)","String","BytesUtils.bytes32DynamicArrayToString"),
    DYNAMICARRAYInt8("DynamicArray<Int8>","varchar(1024)","String","BytesUtils.int8DynamicArrayToString"),
    DYNAMICARRAYInt256("DynamicArray<Int256>","varchar(1024)","String","BytesUtils.int256DynamicArrayToString"),
    DYNAMICARRAYInt("DynamicArray<Int>","varchar(1024)","String","BytesUtils.intDynamicArrayToString"),
    DYNAMICARRAYUint256("DynamicArray<Uint256>","varchar(1024)","String","BytesUtils.uint256DynamicArrayToString"),
    DYNAMICARRAYUint("DynamicArray<Uint>","varchar(1024)","String","BytesUtils.uintDynamicArrayToString"),
    BOOL("Bool", "tinyint", "boolean", "BoolUtils.toBoolean")
    ;
    
    private String solidityType;
    private String sqlType;
    private String javaType;
    private String typeMethod;

    public static Web3jTypeEnum parse(String solidityType) {
        for (Web3jTypeEnum type : Web3jTypeEnum.values()) {
            if (type.getSolidityType().equalsIgnoreCase(solidityType)) {
                return type;
            }
        }
        log.error("{} can't be converted.", solidityType);
        return null;
    }

    public static Web3jTypeEnum fromJavaTpe(String javaType) {
        for (Web3jTypeEnum type : Web3jTypeEnum.values()) {
            if (type.getJavaType().equalsIgnoreCase(javaType)) {
                return type;
            }
        }
        return null;
    }
}
