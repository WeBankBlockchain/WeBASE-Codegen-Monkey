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
package com.webank.webasemonkey.config;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.webank.webasemonkey.tools.JacksonUtils;
import com.webank.webasemonkey.vo.Web3jTypeVO;

import cn.hutool.core.io.resource.ClassPathResource;
import lombok.extern.slf4j.Slf4j;

/**
 * BeanConfig
 *
 * @Description: BeanConfig
 * @author maojiayu
 * @data Dec 28, 2018 3:08:50 PM
 *
 */
@Configuration
@Slf4j
public class BeanConfig {

    /**
     * Beetl render template.
     * 
     * @return GroupTemplate
     * @throws IOException
     */
    @Bean
    public GroupTemplate getGroupTemplateInstance() throws IOException {
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("");
        org.beetl.core.Configuration cfg = org.beetl.core.Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        return gt;
    }

    /**
     * Load class path resource.
     * 
     * @return ClassPathResource
     */
    @Bean
    @Profile("!test")
    public ClassPathResource getClassPathResource() {
        return new ClassPathResource("application.properties");
    }
    
    @Bean
    @Profile("test")
    public ClassPathResource getTestClassPathResource() {
        return new ClassPathResource("application-test.properties");
    }

    @Bean
    public Map<String, Web3jTypeVO> getCustomDefineWeb3jMap() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource def = resolver.getResource("classpath:web3j.def");
        File defFile = def.getFile();
        Map<String, Web3jTypeVO> map = new HashMap<String, Web3jTypeVO>();
        if (defFile.exists()) {
            log.info("defFile detect.");
            List<String> lines = FileUtils.readLines(defFile, "utf8");
            if (!CollectionUtils.isEmpty(lines)) {
                for (String line : lines) {
                    line = line.replaceAll("\"", "");
                    String[] tokens = StringUtils.split(line, ",");
                    if (tokens.length < 4) {
                        continue;
                    }
                    Web3jTypeVO vo = new Web3jTypeVO();
                    vo.setSolidityType(tokens[0]).setSqlType(tokens[1]).setJavaType(tokens[2]).setTypeMethod(tokens[3]);
                    map.put(tokens[0], vo);
                    log.info("Find Web3j type definetion : {}", JacksonUtils.toJson(vo));
                }
            }
        }
        return map;
    }

}
