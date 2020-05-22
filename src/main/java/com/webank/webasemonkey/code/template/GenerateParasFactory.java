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
package com.webank.webasemonkey.code.template;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webank.webasemonkey.code.template.face.AtomicParas;

/**
 * CodeFactory
 *
 * @Description: GenerateParasFactory
 * @author maojiayu
 * @date 2018-11-12 18:20:55
 * 
 */
@Component
public class GenerateParasFactory {
    /** @Fields parasMap : typeName -> GenerateParas Interface */
    @SuppressWarnings("rawtypes")
	@Autowired
    private Map<String, AtomicParas> parasMap;

    /**
     * get paras by type name.
     * 
     * @param typeName
     * @return GenerateParas contains template path, generation path and render properties.
     */
    @SuppressWarnings("rawtypes")
    public AtomicParas getParasByType(String typeName) {
        return parasMap.get(typeName);
    }

}
