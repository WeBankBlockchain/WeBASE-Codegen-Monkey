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
import org.fisco.bcos.web3j.protocol.core.methods.response.AbiDefinition;
import org.fisco.bcos.web3j.tx.txdecode.BaseException;
import org.fisco.bcos.web3j.tx.txdecode.ContractTypeUtil;
import org.fisco.bcos.web3j.tx.txdecode.DynamicArrayReference;
import org.fisco.bcos.web3j.tx.txdecode.StaticArrayReference;

/**
 * TypeReferenceUtils
 *
 * @Description: TypeReferenceUtils
 * @author maojiayu
 * @data Apr 24, 2020 11:02:39 AM
 *
 */
public class TypeReferenceUtils {

    public static TypeReference<?> getTypeRef(String solType) throws BaseException {
        AbiDefinition.NamedType.Type type = new AbiDefinition.NamedType.Type(solType);
        // nested array , not support now.
        if (type.getDepth() > 1) {
            throw new BaseException(201202, String.format("type:%s unsupported array decoding", type.getName()));
        }

        TypeReference<?> typeReference = null;
        if (type.dynamicArray()) {
            typeReference = DynamicArrayReference.create(type.getBaseName(), false);
        } else if (type.staticArray()) {
            typeReference = StaticArrayReference.create(type.getBaseName(), type.getDimensions(), false);
        } else {
            typeReference = TypeReference.create(ContractTypeUtil.getType(solType), false);
        }
        return typeReference;
    }

}
