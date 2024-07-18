/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.entity
 * @className com.jingdianjichi.subject.domain.entity.SubjectLikedBO
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.entity;

import com.jingdianjichi.subject.common.entity.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * SubjectLikedBO
 * @author zxf
 * @date 2024/7/19 2:10
 * @version 1.0
 */
@Data
public class SubjectLikedBO extends PageInfo implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 题目id
     */
    private Long subjectId;

    /**
     * 点赞人id
     */
    private String likeUserId;

    /**
     * 点赞状态 1点赞 0不点赞
     */
    private Integer status;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     *
     */
    private Integer isDeleted;

}


