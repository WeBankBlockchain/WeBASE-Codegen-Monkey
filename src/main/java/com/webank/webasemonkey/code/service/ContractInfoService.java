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
package com.webank.webasemonkey.code.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.webank.webasemonkey.config.SystemEnvironmentConfig;
import com.webank.webasemonkey.constants.ConfigConstants;
import com.webank.webasemonkey.parser.EventParser;
import com.webank.webasemonkey.parser.MethodParser;
import com.webank.webasemonkey.tools.ClazzScanUtils;
import com.webank.webasemonkey.vo.ContractInfo;
import com.webank.webasemonkey.vo.EventMetaInfo;
import com.webank.webasemonkey.vo.MethodMetaInfo;

/**
 * ContractInfoService
 *
 * @Description: ContractInfoService
 * @author maojiayu
 * @data Mar 27, 2019 12:07:48 PM
 *
 */
@Service
public class ContractInfoService {
    /** @Fields monitorGeneratedConfig : monitor generated config params */
    @Autowired
    private SystemEnvironmentConfig systemEnvironmentConfig;

    /** @Fields methodParser : parsing contract method and get method params */
    @Autowired
    private MethodParser methodParser;

    /** @Fields eventParser : parsing contract event and get event params */
    @Autowired
    private EventParser eventParser;

    /**
     * Scan all contracts file from contracts' package, get event meta info list and method meta info list.
     * 
     * @return void
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public ContractInfo parseFromContract() throws ClassNotFoundException, IOException {
        Set<Class<?>> clazzSet = scanContract();
        List<EventMetaInfo> eventMetaInfoList = Lists.newArrayList();
        List<MethodMetaInfo> methodMetaInfoList = Lists.newArrayList();
        for (Class<?> clazz : clazzSet) {
            // generate java code files for crawling event data from block chain network
            List<EventMetaInfo> el = eventParser.parseToInfoList(clazz);
            // generate java code files for crawling method data from blcok chain network
            List<MethodMetaInfo> ml = methodParser.parseToInfoList(clazz);
            eventMetaInfoList.addAll(el);
            methodMetaInfoList.addAll(ml);
        }
        ContractInfo info = new ContractInfo().setEventList(eventMetaInfoList).setMethodList(methodMetaInfoList);
        return info;
    }

    private Set<Class<?>> scanContract() throws ClassNotFoundException, IOException {
        Set<Class<?>> clazzSet =
                ClazzScanUtils.scan(ConfigConstants.CONTRACT_PATH, systemEnvironmentConfig.getContractPackName());
        if (!CollectionUtils.isEmpty(clazzSet)) {
            return clazzSet;
        }
        clazzSet = ClazzScanUtils.scanJar(ConfigConstants.CONTRACT_PATH, systemEnvironmentConfig.getContractPackName());
        if (clazzSet != null && StringUtils.isNotBlank(systemEnvironmentConfig.getContractName())) {
            return clazzSet.stream()
                    .filter(clz -> Arrays.asList(StringUtils.split(systemEnvironmentConfig.getContractName(), ","))
                            .contains(clz.getSimpleName()))
                    .collect(Collectors.toSet());
        }
        return clazzSet;
    }
}
