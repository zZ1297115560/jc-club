package com.jingdianjichi.subject.domain.entity;

import com.jingdianjichi.subject.common.entity.PageInfo;
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
public class SubjectInfoBO extends PageInfo implements Serializable {
    private static final long serialVersionUID = -83741047711808489L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 题目名称
     */
    private String subjectName;
    /**
     * 题目难度
     */
    private Integer subjectDifficult;
    /**
     * 出题人名
     */
    private String settleName;
    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;
    /**
     * 题目分数
     */
    private Integer subjectScore;
    /**
     * 题目解析
     */
    private String subjectParse;

    /**
     * 题目答案
     */
    private String subjectAnswer;

    /**
     * 分类ids
     */
    private List<Integer> categoryIds;

    /**
     * 标签ids
     */
    private List<Integer> labelIds;

    /**
     * 标签名称
     */
    private List<String> labelNames;

    /**
     * 题目选项
     */
    private List<SubjectAnswerBO> optionList;

    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 标签id
     */
    private Integer labelId;

    private String keyWord;

    /**
     * 创建人昵称
     */
    private String createUser;

    /**
     * 创建人头像
     */
    private String createUserAvatar;

    /**
     * 题目数量
     */
    private Integer subjectCount;
    /**
     * 是否被当前用户点赞
     */
    private Boolean liked;

    /**
     * 当前题目点赞的数量
     */
    private Integer likedCount;
    /**
     * 下一题
     */
    private Long nextSubjectId;

    /**
     * 上一题
     */
    private Long lastSubjectId;

}

