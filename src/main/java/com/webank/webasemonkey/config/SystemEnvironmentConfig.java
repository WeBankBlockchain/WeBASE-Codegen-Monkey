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

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.webank.webasemonkey.enums.NameStyleEnum;

import lombok.Data;

/**
 * system environments.
 *
 * @author maojiayu
 * @data Dec 28, 2018 3:14:55 PM
 *
 */
@Configuration
@ConfigurationProperties("system")
@Data
public class SystemEnvironmentConfig {

    /** @Fields orgId : org Id */
    private String orgId = "1000";
    /** @Fields nodeStr : [name]@[IP]:[PORT] */
    private String nodeStr;
    private int groupId;

    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    private String group;
    private String contractPackName;
    private String baseProjectPath;
    private int frequency = 5;

    /** @Fields crawlBatchUnit : to cut gaint mission to small missions, whose size is this */
    private int crawlBatchUnit = 100;

    private String nameStyle = NameStyleEnum.UNDER_SCORE_CASE.getStyle();
    private String namePrefix = "";
    private String namePostfix = "";

    private String multiLiving;

    private long startBlockHeight;
    private String startDate;
    
    private String dbIdentifierSplit = "false";

}
