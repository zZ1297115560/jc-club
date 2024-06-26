package com.jingdianjichi.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目答案DTO
 *
 * @author makejava
 * @since 2024-06-23 14:22:46
 */
@Data
public class SubjectAnswerDTO implements Serializable {
    private static final long serialVersionUID = -83741047711808489L;
    /**
     * 答案选项标识
     */
    private Long optionType;

    /**
     * 答案选项内容
     */
    private String optionContent;

    /**
     * 是否是正确答案 1是 0否
     */
    private Integer isCorrect;

}

