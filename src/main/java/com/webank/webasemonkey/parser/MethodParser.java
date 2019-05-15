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
package com.webank.webasemonkey.parser;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.fisco.bcos.web3j.protocol.ObjectMapperFactory;
import org.fisco.bcos.web3j.protocol.core.methods.response.AbiDefinition;
import org.fisco.bcos.web3j.protocol.core.methods.response.AbiDefinition.NamedType;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.webank.webasemonkey.constants.AbiTypeConstants;
import com.webank.webasemonkey.constants.ParserConstants;
import com.webank.webasemonkey.enums.Web3jTypeEnum;
import com.webank.webasemonkey.tools.AbiTypeRefUtils;
import com.webank.webasemonkey.tools.PropertiesUtils;
import com.webank.webasemonkey.tools.StringStyleUtils;
import com.webank.webasemonkey.vo.FieldVO;
import com.webank.webasemonkey.vo.MethodMetaInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * MethodParser can parse contract files of java to standard method data structures.
 *
 * @Description: MethodParser
 * @author graysonzhang
 * @author maojiayu
 * @data 2018-12-4 23:04:50
 *
 */
@Slf4j
@Service
public class MethodParser implements ContractJavaParserInterface<MethodMetaInfo> {
    public List<MethodMetaInfo> parseToInfoList(Class<?> clazz) {
        AbiDefinition[] abiDefinitions = getContractAbiList(clazz);
        if (abiDefinitions == null || abiDefinitions.length == 0)
            return null;
        List<MethodMetaInfo> lists = Lists.newArrayList();
        for (AbiDefinition abiDefinition : abiDefinitions) {
            String abiType = abiDefinition.getType();
            if (abiType.equals(AbiTypeConstants.ABI_EVENT_TYPE) || abiDefinition.isConstant()) {
                continue;
            }
            List<NamedType> inputs = abiDefinition.getInputs();
            if (inputs == null || inputs.isEmpty()) {
                continue;
            }

            MethodMetaInfo method = new MethodMetaInfo();
            method.setContractName(clazz.getSimpleName());
            String Name = abiDefinition.getName();
            log.debug("method name : {}", Name);

            if (abiType.equals(AbiTypeConstants.ABI_CONSTRUCTOR_TYPE)) {
                method.setName(clazz.getSimpleName());
            } else {
                method.setName(Name);
            }
            String generatedFlag = PropertiesUtils.getGlobalProperty(ParserConstants.MONITOR, method.getContractName(),
                    method.getName(), "generated", "on");
            if (generatedFlag != null && generatedFlag.equalsIgnoreCase("off")) {
                continue;
            }
            int shardingNO = Integer.parseInt(PropertiesUtils.getGlobalProperty(ParserConstants.SYSTEM,
                    method.getContractName(), method.getName(), ParserConstants.SHARDINGNO, "1"));
            method.setShardingNO(shardingNO);

            ArrayList<FieldVO> fieldList = Lists.newArrayList();

            for (NamedType namedType : inputs) {
                FieldVO vo = new FieldVO();
                String k = namedType.getName();
                String type = namedType.getType().split(" ")[0];
                String v = solidityType2SolidityReferenceType(type);
                String length = PropertiesUtils.getGlobalProperty(ParserConstants.LENGTH, method.getContractName(),
                        method.getName(), k, "0");
                vo.setSolidityName(k).setSqlName(StringStyleUtils.upper2underline(k)).setJavaName(k)
                        .setSqlType(Web3jTypeEnum.parse(v).getSqlType()).setSolidityType(v)
                        .setJavaType(Web3jTypeEnum.parse(v).getJavaType())
                        .setTypeMethod(Web3jTypeEnum.parse(v).getTypeMethod()).setJavaCapName(StringUtils.capitalize(k))
                        .setLength(Integer.parseInt(length));
                log.debug("java name {}, java type {}, solidity type {}, type method {}", vo.getJavaName(),
                        vo.getJavaType(), vo.getSolidityType(), vo.getTypeMethod());
                fieldList.add(vo);
            }
            method.setList(fieldList);
            lists.add(method);
        }
        return lists;
    }

    /**
     * Get contract abi list by contract class.
     * 
     * @param clazz
     * @return
     * @return AbiDefinition[]
     */
    public AbiDefinition[] getContractAbiList(Class<?> clazz) {
        String abi = null;
        try {
            Field field = clazz.getField(ParserConstants.ABI);
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            abi = (String) field.get(ParserConstants.ABI);
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = ObjectMapperFactory.getObjectMapper();
        AbiDefinition[] abiDefinition = null;

        try {
            abiDefinition = objectMapper.readValue(abi, AbiDefinition[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return abiDefinition;
    }

    public String solidityType2SolidityReferenceType(String type) {
        try {
            return AbiTypeRefUtils.getTypeRef(type).getClassType().getSimpleName();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
