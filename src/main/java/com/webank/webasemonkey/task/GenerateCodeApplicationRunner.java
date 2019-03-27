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
package com.webank.webasemonkey.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.webank.webasemonkey.code.service.CodeGenerateService;

import lombok.extern.slf4j.Slf4j;

/**
 * GenerateCodeApplicationRunner: task entrance.
 *
 * @author maojiayu
 * @date 2018-11-29 16:37:38
 * 
 */
@Component
@Order(value = 1)
@Slf4j
public class GenerateCodeApplicationRunner implements ApplicationRunner {
    @Autowired
    private CodeGenerateService codeGenerateService;

    @Override
    public void run(ApplicationArguments var1) throws Exception {

        log.info("Begin to generate code.");
        codeGenerateService.generateBee();
        log.info("Code generation Finished!");
        System.exit(0);

    }
}