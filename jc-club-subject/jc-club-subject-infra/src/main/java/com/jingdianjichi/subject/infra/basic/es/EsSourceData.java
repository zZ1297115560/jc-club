/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.infra.basic.es
 * @className com.jingdianjichi.subject.infra.basic.es.EsSourceData
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.infra.basic.es;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * EsSourceData
 * @author zxf
 * @date 2024/7/18 18:52
 * @version 1.0
 */
@Data
public class EsSourceData implements Serializable {

    private String docId;

    private Map<String, Object> data;

}


