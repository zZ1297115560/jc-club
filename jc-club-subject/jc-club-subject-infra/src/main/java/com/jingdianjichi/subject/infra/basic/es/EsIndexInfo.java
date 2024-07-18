/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.infra.basic.es
 * @className com.jingdianjichi.subject.infra.basic.es.EsIndexInfo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.infra.basic.es;

import lombok.Data;

import java.io.Serializable;

/**
 * EsIndexInfo
 * @author zxf
 * @date 2024/7/18 18:51
 * @version 1.0
 */
@Data
public class EsIndexInfo implements Serializable {

    /**
     * 集群名称
     */
    private String clusterName;

    /**
     * 索引名称
     */
    private String indexName;

}


