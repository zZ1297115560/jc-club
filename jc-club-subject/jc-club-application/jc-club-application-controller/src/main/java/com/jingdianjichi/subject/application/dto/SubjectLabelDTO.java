package com.jingdianjichi.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签表(SubjectLabel)DTO
 *
 * @author makejava
 * @since 2024-06-23 08:25:09
 */
@Data
public class SubjectLabelDTO implements Serializable {
    private static final long serialVersionUID = 482249020461325671L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 标签分类
     */
    private String labelName;

    /**
     * 排序
     */
    private Integer sortNum;

}

