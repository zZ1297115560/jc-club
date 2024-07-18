/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.infra.basic.entity
 * @className com.jingdianjichi.subject.infra.basic.entity.SubjectLiked
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * SubjectLiked
 * @author zxf
 * @date 2024/7/19 2:11
 * @version 1.0
 */
@Data
@TableName("subject_liked")
public class SubjectLiked implements Serializable {

    /**
     * 主键
     */
    @TableId(value = "`id`", type = IdType.AUTO)
    private Long id;

    /**
     * 题目id
     */
    @TableField("`subject_id`")
    private Long subjectId;

    /**
     * 点赞人id
     */
    @TableField("`like_user_id`")
    private String likeUserId;

    /**
     * 点赞状态 1点赞 0不点赞
     */
    @TableField("`status`")
    private Integer status;

    /**
     * 创建人
     */
    @TableField("`created_by`")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField("`created_time`")
    private Date createdTime;

    /**
     * 修改人
     */
    @TableField("`update_by`")
    private String updateBy;

    /**
     * 修改时间
     */
    @TableField("`update_time`")
    private Date updateTime;

    /**
     *
     */
    @TableField("`is_deleted`")
    private Integer isDeleted;

}


