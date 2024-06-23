/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.service.impl
 * @className com.jingdianjichi.subject.domain.service.impl.SubjectCategoryDomainServiceImpl
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.jingdianjichi.subject.common.enums.IsDeleteFlagEnum;
import com.jingdianjichi.subject.domain.convert.SubjectLabelConverter;
import com.jingdianjichi.subject.domain.entity.SubjectLabelBO;
import com.jingdianjichi.subject.domain.service.SubjectLabelDomainService;
import com.jingdianjichi.subject.infra.basic.entity.SubjectLabel;
import com.jingdianjichi.subject.infra.basic.service.SubjectLabelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * SubjectCategoryDomainServiceImpl
 * @author zxf
 * @date 2024/6/10 21:46
 * @version 1.0
 */
@Service
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;

    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()){
            log.info("SubjectLabelDomainServiceImpl.add.subjectLabelBO:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoToSubjectLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeleteFlagEnum.UN_DELETED.getCode());
        int result = subjectLabelService.insert(subjectLabel);
        return result > 0;
    }

    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()){
            log.info("SubjectLabelDomainServiceImpl.update.subjectLabelBO:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoToSubjectLabel(subjectLabelBO);
        int result = subjectLabelService.update(subjectLabel);
        return result > 0;
    }

    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()){
            log.info("SubjectLabelDomainServiceImpl.delete.subjectLabelBO:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoToSubjectLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeleteFlagEnum.DELETED.getCode());
        int result = subjectLabelService.update(subjectLabel);
        return result > 0;
    }
}

