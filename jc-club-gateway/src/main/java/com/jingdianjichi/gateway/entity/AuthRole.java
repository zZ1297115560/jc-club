/**
 * @projectName jc-club
 * @package com.jingdianjichi.gateway.entity
 * @className com.jingdianjichi.gateway.entity.AuthRole
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * AuthRole
 * @author zxf
 * @date 2024/7/10 17:32
 * @version 1.0
 */
@Data
public class AuthRole implements Serializable {
    private static final long serialVersionUID = 422256240999600735L;

    private Long id;

    private String roleName;

    private String roleKey;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;

    private Integer isDeleted;
}

