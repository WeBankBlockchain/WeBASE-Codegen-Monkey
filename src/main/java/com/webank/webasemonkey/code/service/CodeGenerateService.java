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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webank.webasemonkey.code.template.TemplateGenerateService;
import com.webank.webasemonkey.code.template.face.ConfigGenerateParas;
import com.webank.webasemonkey.code.template.face.EventGenerateParas;
import com.webank.webasemonkey.code.template.face.MethodGenerateParas;
import com.webank.webasemonkey.config.SystemEnvironmentConfig;
import com.webank.webasemonkey.constants.ConfigConstants;
import com.webank.webasemonkey.parser.EventParser;
import com.webank.webasemonkey.parser.MethodParser;
import com.webank.webasemonkey.tools.ClazzScanUtils;
import com.webank.webasemonkey.vo.ContractInfo;
import com.webank.webasemonkey.vo.EventMetaInfo;
import com.webank.webasemonkey.vo.MethodMetaInfo;


/**
 * CodeGenerateService
 *
 * @Description: CodeGenerateService used to generate java code files for crawling block chain network data.
 * @author graysonzhang
 * @data 2018-12-04 15:56:40
 *
 */
@Service
public class CodeGenerateService {
    
    /** @Fields templateGenerateService : template generate service */
    @SuppressWarnings("rawtypes")
    @Autowired
    TemplateGenerateService templateGenerateService;
    
    /** @Fields monitorGeneratedConfig : monitor generated config params  */
    @Autowired
    private SystemEnvironmentConfig systemEnvironmentConfig;
    
    /** @Fields methodParasMap : method params map for generating code files of crawling method data */
    @Autowired
    private Map<String, MethodGenerateParas> methodParasMap;
    
    /** @Fields eventParasMap : event params map for generating code files of crawling event data  */
    @Autowired
    private Map<String, EventGenerateParas> eventParasMap;
    
    /** @Fields configParasMap : config params map for generating config files */
    @Autowired
    private Map<String, ConfigGenerateParas> configParasMap;
    
    /** @Fields methodParser : parsing contract method and get method params */
    @Autowired
    private MethodParser methodParser;
    
    /** @Fields eventParser : parsing contract event and get event params */
    @Autowired
    private EventParser eventParser;

    /**
     * Scan all contracts file from contracts' package, get event meta info list and method meta info list,
     * then generate class files for crawling methods and events data, and config files by generate service.
     * 
     * @return void
     */
    public void go() {
        Set<Class<?>> clazzSet = ClazzScanUtils.scan(ConfigConstants.contractPath,
                systemEnvironmentConfig.getContractPackName());
        List<EventMetaInfo> eventMetaInfoList = new ArrayList<>();
        List<MethodMetaInfo> methodMetaInfoList = new ArrayList<>();
        for (Class<?> c : clazzSet) {
            //generate java code files for crawling event data from block chain network
            List<EventMetaInfo> el = templateGenerateService.generate(c, eventParser, eventParasMap);
            //generate java code files for crawling method data from blcok chain network
            List<MethodMetaInfo> ml = templateGenerateService.generate(c, methodParser, methodParasMap);
            eventMetaInfoList.addAll(el);
            methodMetaInfoList.addAll(ml);
        }
        ContractInfo info = new ContractInfo().setEventList(eventMetaInfoList).setMethodList(methodMetaInfoList);
        //generate config files for crawling data.
        templateGenerateService.generate(info, configParasMap);
    }
}
