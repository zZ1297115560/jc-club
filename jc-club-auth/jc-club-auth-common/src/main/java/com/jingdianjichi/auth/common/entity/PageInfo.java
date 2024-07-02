/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.common.entity
 * @className com.jingdianjichi.subject.common.entity.PageInfo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.common.entity;

/**
 * 分页请求实体
 * @author zxf
 * @date 2024/6/24 14:02
 * @version 1.0
 */
public class PageInfo {
    private Integer pageNo = 1;

    private Integer pageSize = 20;

    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            pageNo = 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1) {
            pageSize = 20;
        }
        return pageSize;
    }
}

