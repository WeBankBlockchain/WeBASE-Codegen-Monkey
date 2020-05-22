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

import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.tx.txdecode.BaseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.webank.webasemonkey.WebasemonkeyApplicationTests;
import com.webank.webasemonkey.bo.JavaArrayTypeBO;

/**
 * AbiTypeRefUtilsTest
 *
 * @Description: AbiTypeRefUtilsTest
 * @author maojiayu
 * @data Apr 24, 2020 10:48:20 AM
 *
 */
public class AbiTypeRefUtilsTest extends WebasemonkeyApplicationTests {

    @SuppressWarnings("rawtypes")
    @Test
    public void testTypeReference() throws BaseException {
        System.out.println(JacksonUtils.toJson(TypeReferenceUtils.getTypeRef("address")));
        System.out.println(JacksonUtils.toJson(TypeReferenceUtils.getTypeRef("bytes[]")));
        System.out.println(JacksonUtils.toJson(TypeReferenceUtils.getTypeRef("address[2]")));
        System.out.println(JacksonUtils.toJson(TypeReferenceUtils.getTypeRef("uint8[2]")));
        TypeReference t = TypeReferenceUtils.getTypeRef("address[2]");
        JavaArrayTypeBO bo = JacksonUtils.fromJson(JacksonUtils.toJson(t), JavaArrayTypeBO.class);
        System.out.println();
        Assertions.assertEquals("org.fisco.bcos.web3j.abi.datatypes.generated.StaticArray2", bo.getType().getRawType());
        Assertions.assertEquals("org.fisco.bcos.web3j.abi.datatypes.Address",
                bo.getType().getActualTypeArguments().get(0));    
    }
    
    @Test
    public void testJavaType() {
        System.out.println(JacksonUtils.toJson(TypeReferenceUtils.convertType("uint[]")));
        Assertions.assertTrue(TypeReferenceUtils.convertType("uint[]").isArray());
        System.out.println(JacksonUtils.toJson(TypeReferenceUtils.convertType("int8")));
        Assertions.assertTrue(!TypeReferenceUtils.convertType("int8").isArray());

    }
}
