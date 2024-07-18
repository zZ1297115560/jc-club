/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.infra.basic.es
 * @className com.jingdianjichi.subject.infra.basic.es.EsSearchRequest
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.infra.basic.es;

import lombok.Data;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

/**
 * EsSearchRequest
 * @author zxf
 * @date 2024/7/18 18:52
 * @version 1.0
 */
@Data
public class EsSearchRequest {

    /**
     * 查询条件
     */
    private BoolQueryBuilder bq;

    /**
     * 查询字段
     */
    private String[] fields;

    /**
     * 页数
     */
    private int from;

    /**
     * 条数
     */
    private int size;

    /**
     * 需要快照
     */
    private Boolean needScroll;

    /**
     * 快照缓存时间
     */
    private Long minutes;

    /**
     * 排序字段
     */
    private String sortName;

    /**
     * 排序类型
     */
    private SortOrder sortOrder;

    /**
     * 高亮builder
     */
    private HighlightBuilder highlightBuilder;

}

