package com.jingdianjichi.subject.application.dto;

import lombok.Data;

import java.io.Serializable;


/**
 * 题目分类(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2024-06-10 16:50:43
 */
@Data
public class SubjectCategoryDTO implements Serializable {
    private static final long serialVersionUID = -97640064605434331L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 分类类型
     */
    private Integer categoryType;
    /**
     * 图标连接
     */
    private String imageUrl;
    /**
     * 父级id
     */
    private Long parentId;
    /**
     * 数量
     */
    private Integer count;

}

