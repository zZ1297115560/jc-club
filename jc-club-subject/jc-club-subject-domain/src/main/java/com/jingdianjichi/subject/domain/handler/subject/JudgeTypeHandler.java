/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.handler.subject
 * @className com.jingdianjichi.subject.domain.handler.subject.JudgeTypeHandler
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.IsDeleteFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.domain.convert.JudgeSubjectConverter;
import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.entity.SubjectOptionBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectJudge;
import com.jingdianjichi.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 判断题策略类
 * @author zxf
 * @date 2024/6/24 13:07
 * @version 1.0
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectJudgeService subjectJudgeService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        SubjectJudge subjectJudge = new SubjectJudge();
        SubjectAnswerBO subjectAnswerBO = subjectInfoBO.getOptionList().get(0);
        subjectJudge.setSubjectId(subjectInfoBO.getId());
        subjectJudge.setIsDeleted(IsDeleteFlagEnum.UN_DELETED.getCode());
        subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
        subjectJudgeService.insert(subjectJudge);
    }

    @Override
    public SubjectOptionBO query(Integer subjectId) {
        SubjectJudge subjectJudge = new SubjectJudge();
        subjectJudge.setSubjectId(subjectId.longValue());
        subjectJudge.setIsDeleted(IsDeleteFlagEnum.UN_DELETED.getCode());
        List<SubjectJudge> subjectJudgeList = subjectJudgeService.queryByCondition(subjectJudge);
        List<SubjectAnswerBO> subjectAnswerBoList = JudgeSubjectConverter.INSTANCE.convertEntityListToBoList(subjectJudgeList);

        SubjectOptionBO optionBO = new SubjectOptionBO();
        optionBO.setOptionList(subjectAnswerBoList);
        return optionBO;
    }
}

