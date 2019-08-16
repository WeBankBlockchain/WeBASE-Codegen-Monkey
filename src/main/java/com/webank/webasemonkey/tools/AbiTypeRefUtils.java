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
package com.webank.webasemonkey.tools;

import org.apache.commons.lang3.StringUtils;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.DynamicArray;
import org.fisco.bcos.web3j.abi.datatypes.DynamicBytes;
import org.fisco.bcos.web3j.abi.datatypes.StaticArray;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes1;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes10;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes11;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes12;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes13;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes14;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes15;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes16;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes17;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes18;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes19;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes2;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes20;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes21;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes22;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes23;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes24;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes25;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes26;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes27;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes28;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes29;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes3;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes30;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes31;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes4;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes5;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes6;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes7;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes8;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes9;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int104;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int112;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int120;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int128;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int136;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int144;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int152;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int16;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int160;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int168;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int176;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int184;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int192;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int200;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int208;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int216;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int224;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int232;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int24;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int240;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int248;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int32;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int40;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int48;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int56;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int64;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int72;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int8;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int80;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int88;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int96;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint104;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint112;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint120;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint128;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint136;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint144;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint152;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint16;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint160;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint168;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint176;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint184;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint192;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint200;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint208;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint216;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint224;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint232;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint24;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint240;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint248;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint32;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint40;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint48;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint56;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint64;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint72;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint8;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint80;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint88;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint96;

/**
 * AbiTypeRef
 *
 * @Description: AbiTypeRef
 * @author graysonzhang
 * @data 2018-12-11 19:39:25
 *
 */
public final class AbiTypeRefUtils{
  private AbiTypeRefUtils() {
  }

  public static TypeReference getTypeRef(String type)
  {
        if (StringUtils.contains(type, "[") && StringUtils.contains(type, "]")) {
            String digitStr = StringUtils.substringAfter(StringUtils.substringBefore(type, "]"), "[").trim();
            if (StringUtils.isNumeric(digitStr)) {
                if (StringUtils.startsWithIgnoreCase(type, "int256")) {
                    return (TypeReference) new TypeReference<StaticArray<Int256>>() {
                    };
                }
                if (StringUtils.startsWithIgnoreCase(type, "bytes32")) {
                    return (TypeReference) new TypeReference<StaticArray<Bytes32>>() {
                    };
                }
                if (StringUtils.startsWithIgnoreCase(type, "address")) {
                    return (TypeReference) new TypeReference<StaticArray<Address>>() {
                    };
                }
                if (StringUtils.startsWithIgnoreCase(type, "uint256")) {
                    return (TypeReference) new TypeReference<StaticArray<Uint256>>() {
                    };
                }
            }
        }
	  switch (type) {
      case "address":
          return   new TypeReference<Address>() {};
      case "bool":
          return (TypeReference) new TypeReference<Bool>() {};
      case "address[]":
    	  return (TypeReference) new TypeReference<DynamicArray<Address>>() {};
      case "bytes32[]":
          return (TypeReference) new TypeReference<DynamicArray<Bytes32>>() {};
      case "int256[]":
          return (TypeReference) new TypeReference<DynamicArray<Int256>>() {};
      case "uint256[]":
          return (TypeReference) new TypeReference<DynamicArray<Uint256>>() {};
      case "string":
          return (TypeReference) new TypeReference<Utf8String>() {};
      case "bytes":
          return (TypeReference) new TypeReference<DynamicBytes>() {};
      case "uint8":
          return (TypeReference) new TypeReference<Uint8>() {};
      case "int8":
          return (TypeReference) new TypeReference<Int8>() {};
      case "uint16":
          return (TypeReference) new TypeReference<Uint16>() {};
      case "int16":
          return (TypeReference) new TypeReference<Int16>() {};
      case "uint24":
          return (TypeReference) new TypeReference<Uint24>() {};
      case "int24":
          return (TypeReference) new TypeReference<Int24>() {};
      case "uint32":
          return (TypeReference) new TypeReference<Uint32>() {};
      case "int32":
          return (TypeReference) new TypeReference<Int32>() {};
      case "uint40":
          return (TypeReference) new TypeReference<Uint40>() {};
      case "int40":
          return (TypeReference) new TypeReference<Int40>() {};
      case "uint48":
          return (TypeReference) new TypeReference<Uint48>() {};
      case "int48":
          return (TypeReference) new TypeReference<Int48>() {};
      case "uint56":
          return (TypeReference) new TypeReference<Uint56>() {};
      case "int56":
          return (TypeReference) new TypeReference<Int56>() {};
      case "uint64":
          return (TypeReference) new TypeReference<Uint64>() {};
      case "int64":
          return (TypeReference) new TypeReference<Int64>() {};
      case "uint72":
          return (TypeReference) new TypeReference<Uint72>() {};
      case "int72":
          return (TypeReference) new TypeReference<Int72>() {};
      case "uint80":
          return (TypeReference) new TypeReference<Uint80>() {};
      case "int80":
          return (TypeReference) new TypeReference<Int80>() {};
      case "uint88":
          return (TypeReference) new TypeReference<Uint88>() {};
      case "int88":
          return (TypeReference) new TypeReference<Int88>() {};
      case "uint96":
          return (TypeReference) new TypeReference<Uint96>() {};
      case "int96":
          return (TypeReference) new TypeReference<Int96>() {};
      case "uint104":
          return (TypeReference) new TypeReference<Uint104>() {};
      case "int104":
          return (TypeReference) new TypeReference<Int104>() {};
      case "uint112":
          return (TypeReference) new TypeReference<Uint112>() {};
      case "int112":
          return (TypeReference) new TypeReference<Int112>() {};
      case "uint120":
          return (TypeReference) new TypeReference<Uint120>() {};
      case "int120":
          return (TypeReference) new TypeReference<Int120>() {};
      case "uint128":
          return (TypeReference) new TypeReference<Uint128>() {};
      case "int128":
          return (TypeReference) new TypeReference<Int128>() {};
      case "uint136":
          return (TypeReference) new TypeReference<Uint136>() {};
      case "int136":
          return (TypeReference) new TypeReference<Int136>() {};
      case "uint144":
          return (TypeReference) new TypeReference<Uint144>() {};
      case "int144":
          return (TypeReference) new TypeReference<Int144>() {};
      case "uint152":
          return (TypeReference) new TypeReference<Uint152>() {};
      case "int152":
          return (TypeReference) new TypeReference<Int152>() {};
      case "uint160":
          return (TypeReference) new TypeReference<Uint160>() {};
      case "int160":
          return (TypeReference) new TypeReference<Int160>() {};
      case "uint168":
          return (TypeReference) new TypeReference<Uint168>() {};
      case "int168":
          return (TypeReference) new TypeReference<Int168>() {};
      case "uint176":
          return (TypeReference) new TypeReference<Uint176>() {};
      case "int176":
          return (TypeReference) new TypeReference<Int176>() {};
      case "uint184":
          return (TypeReference) new TypeReference<Uint184>() {};
      case "int184":
          return (TypeReference) new TypeReference<Int184>() {};
      case "uint192":
          return (TypeReference) new TypeReference<Uint192>() {};
      case "int192":
          return (TypeReference) new TypeReference<Int192>() {};
      case "uint200":
          return (TypeReference) new TypeReference<Uint200>() {};
      case "int200":
          return (TypeReference) new TypeReference<Int200>() {};
      case "uint208":
          return (TypeReference) new TypeReference<Uint208>() {};
      case "int208":
          return (TypeReference) new TypeReference<Int208>() {};
      case "uint216":
          return (TypeReference) new TypeReference<Uint216>() {};
      case "int216":
          return (TypeReference) new TypeReference<Int216>() {};
      case "uint224":
          return (TypeReference) new TypeReference<Uint224>() {};
      case "int224":
          return (TypeReference) new TypeReference<Int224>() {};
      case "uint232":
          return (TypeReference) new TypeReference<Uint232>() {};
      case "int232":
          return (TypeReference) new TypeReference<Int232>() {};
      case "uint240":
          return (TypeReference) new TypeReference<Uint240>() {};
      case "int240":
          return (TypeReference) new TypeReference<Int240>() {};
      case "uint248":
          return (TypeReference) new TypeReference<Uint248>() {};
      case "int248":
          return (TypeReference) new TypeReference<Int248>() {};
      case "uint256":
          return (TypeReference) new TypeReference<Uint256>() {};
      case "int256":
          return (TypeReference) new TypeReference<Int256>() {};
      case "bytes1":
          return (TypeReference) new TypeReference<Bytes1>() {};
      case "bytes2":
          return (TypeReference) new TypeReference<Bytes2>() {};
      case "bytes3":
          return (TypeReference) new TypeReference<Bytes3>() {};
      case "bytes4":
          return (TypeReference) new TypeReference<Bytes4>() {};
      case "bytes5":
          return (TypeReference) new TypeReference<Bytes5>() {};
      case "bytes6":
          return (TypeReference) new TypeReference<Bytes6>() {};
      case "bytes7":
          return (TypeReference) new TypeReference<Bytes7>() {};
      case "bytes8":
          return (TypeReference) new TypeReference<Bytes8>() {};
      case "bytes9":
          return (TypeReference) new TypeReference<Bytes9>() {};
      case "bytes10":
          return (TypeReference) new TypeReference<Bytes10>() {};
      case "bytes11":
          return (TypeReference) new TypeReference<Bytes11>() {};
      case "bytes12":
          return (TypeReference) new TypeReference<Bytes12>() {};
      case "bytes13":
          return (TypeReference) new TypeReference<Bytes13>() {};
      case "bytes14":
          return (TypeReference) new TypeReference<Bytes14>() {};
      case "bytes15":
          return (TypeReference) new TypeReference<Bytes15>() {};
      case "bytes16":
          return (TypeReference) new TypeReference<Bytes16>() {};
      case "bytes17":
          return (TypeReference) new TypeReference<Bytes17>() {};
      case "bytes18":
          return (TypeReference) new TypeReference<Bytes18>() {};
      case "bytes19":
          return (TypeReference) new TypeReference<Bytes19>() {};
      case "bytes20":
          return (TypeReference) new TypeReference<Bytes20>() {};
      case "bytes21":
          return (TypeReference) new TypeReference<Bytes21>() {};
      case "bytes22":
          return (TypeReference) new TypeReference<Bytes22>() {};
      case "bytes23":
          return (TypeReference) new TypeReference<Bytes23>() {};
      case "bytes24":
          return (TypeReference) new TypeReference<Bytes24>() {};
      case "bytes25":
          return (TypeReference) new TypeReference<Bytes25>() {};
      case "bytes26":
          return (TypeReference) new TypeReference<Bytes26>() {};
      case "bytes27":
          return (TypeReference) new TypeReference<Bytes27>() {};
      case "bytes28":
          return (TypeReference) new TypeReference<Bytes28>() {};
      case "bytes29":
          return (TypeReference) new TypeReference<Bytes29>() {};
      case "bytes30":
          return (TypeReference) new TypeReference<Bytes30>() {};
      case "bytes31":
          return (TypeReference) new TypeReference<Bytes31>() {};
      case "bytes32":
          return (TypeReference) new TypeReference<Bytes32>() {};

      default:
          throw new UnsupportedOperationException("Unsupported type encountered: " + type);
    }
  }

}
