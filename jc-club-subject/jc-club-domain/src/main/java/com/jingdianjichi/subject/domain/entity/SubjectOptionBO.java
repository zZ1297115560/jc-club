package com.jingdianjichi.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目信息表(SubjectInfo)BO
 *
 * @author makejava
 * @since 2024-06-23 14:22:46
 */
@Data
public class SubjectOptionBO implements Serializable {
    private static final long serialVersionUID = -83741047711808489L;

    /**
     * 题目答案
     */
    private String subjectAnswer;

    /**
     * 题目选项
     */
    private List<SubjectAnswerBO> optionList;

}

