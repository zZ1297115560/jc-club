/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.common.entity
 * @className com.jingdianjichi.subject.common.entity.PageResult
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * PageResult
 * @author zxf
 * @date 2024/6/24 14:05
 * @version 1.0
 */
@Data
public class PageResult<T> implements Serializable {
    private Integer pageNo = 1;
    private Integer pageSize = 20;
    private Integer total = 0;
    private Integer totalPages = 0;
    private List<T> result = Collections.emptyList();
    private Integer start = 1;
    private Integer end = 0;

    public void setRecords(List<T> result) {
        this.result = result;
        if (result != null && result.size() > 0){
            setTotal(result.size());
        }
    }

    public void setTotal(int total) {
        this.total = total;
        if (this.pageSize > 0){
            this.totalPages = (total / this.pageSize) + (total % this.pageSize == 0 ? 0 : 1);
        }else {
            this.totalPages = 0;
        }
        this.start = (this.pageSize > 0 ? (this.pageNo - 1) * this.pageSize : 0) + 1;
        this.end = (this.start - 1 + this.pageSize * (this.pageNo > 0 ? 1 : 0));
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize < 1) {
            pageSize = 20;
        }
        this.pageSize = pageSize;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo == null || pageNo < 1) {
            pageNo = 1;
        }
        this.pageNo = pageNo;
    }

}

