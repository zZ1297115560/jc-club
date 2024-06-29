/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.handler.subject
 * @className com.jingdianjichi.subject.domain.handler.subject.RadioTypeHandler
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.IsDeleteFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.domain.convert.RadioSubjectConverter;
import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.entity.SubjectOptionBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectRadio;
import com.jingdianjichi.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 单选题目策略类
 * @author zxf
 * @date 2024/6/24 13:04
 * @version 1.0
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {

        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        List<SubjectRadio> subjectRadioList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option->{
            SubjectRadio subjectRadio = RadioSubjectConverter.INSTANCE.convertBoToEntity(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadio.setIsDeleted(IsDeleteFlagEnum.UN_DELETED.getCode());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.batchInsert(subjectRadioList);
    }

    @Override
    public SubjectOptionBO query(Integer subjectId) {
        SubjectRadio subjectRadio = new SubjectRadio();
        subjectRadio.setSubjectId(subjectId.longValue());
        subjectRadio.setIsDeleted(IsDeleteFlagEnum.UN_DELETED.getCode());
        List<SubjectRadio> subjectRadioList = subjectRadioService.queryByCondition(subjectRadio);
        List<SubjectAnswerBO> subjectAnswerBoList = RadioSubjectConverter.INSTANCE.convertEntityListToBoList(subjectRadioList);

        SubjectOptionBO optionBO = new SubjectOptionBO();
        optionBO.setOptionList(subjectAnswerBoList);
        return optionBO;
    }
}

