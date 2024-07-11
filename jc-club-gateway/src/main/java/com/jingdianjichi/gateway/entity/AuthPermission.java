/**
 * @projectName jc-club
 * @package com.jingdianjichi.gateway.entity
 * @className com.jingdianjichi.gateway.entity.AuthPermission
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * AuthPermission
 * @author zxf
 * @date 2024/7/10 17:30
 * @version 1.0
 */
@Data
public class AuthPermission implements Serializable {
    private static final long serialVersionUID = -56518358607843924L;

    private Long id;

    private String name;

    private Long parentId;

    private Integer type;

    private String menuUrl;

    private Integer status;

    private Integer show;

    private String icon;

    private String permissionKey;
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


