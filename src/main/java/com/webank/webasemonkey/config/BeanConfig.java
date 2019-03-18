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

import java.io.IOException;

import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.hutool.core.io.resource.ClassPathResource;

/**
 * BeanConfig
 *
 * @Description: BeanConfig
 * @author maojiayu
 * @data Dec 28, 2018 3:08:50 PM
 *
 */
@Configuration
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
    public ClassPathResource getClassPathResource() {
        return new ClassPathResource("application.properties");
    }

}
