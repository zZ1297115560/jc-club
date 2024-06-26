/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.handler.subject
 * @className com.jingdianjichi.subject.domain.handler.subject.MultipleTypeHandler
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.IsDeleteFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.domain.convert.MultipleSubjectConverter;
import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.entity.SubjectOptionBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectMultiple;
import com.jingdianjichi.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 多选题策略类
 * @author zxf
 * @date 2024/6/24 13:06
 * @version 1.0
 */
@Component
public class MultipleTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        List<SubjectMultiple> subjectMultiList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option->{
            SubjectMultiple subjectMultiple = MultipleSubjectConverter.INSTANCE.convertBoToEntity(option);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultiple.setIsDeleted(IsDeleteFlagEnum.UN_DELETED.getCode());
            subjectMultiList.add(subjectMultiple);
        });
        subjectMultipleService.batchInsert(subjectMultiList);
    }

    @Override
    public SubjectOptionBO query(Integer subjectId) {
        SubjectMultiple subjectMultiple = new SubjectMultiple();
        subjectMultiple.setSubjectId(subjectId.longValue());
        subjectMultiple.setIsDeleted(IsDeleteFlagEnum.UN_DELETED.getCode());
        List<SubjectMultiple> subjectJudgeList = subjectMultipleService.queryByCondition(subjectMultiple);
        List<SubjectAnswerBO> subjectAnswerBoList = MultipleSubjectConverter.INSTANCE.convertEntityListToBoList(subjectJudgeList);

        SubjectOptionBO optionBO = new SubjectOptionBO();
        optionBO.setOptionList(subjectAnswerBoList);
        return optionBO;
    }

}

