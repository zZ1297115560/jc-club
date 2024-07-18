/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.infra.basic.service.impl
 * @className com.jingdianjichi.subject.infra.basic.service.impl.SubjectEsServiceImpl
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.infra.basic.service.impl;

import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.infra.basic.entity.EsSubjectFields;
import com.jingdianjichi.subject.infra.basic.entity.SubjectInfoEs;
import com.jingdianjichi.subject.infra.basic.es.EsIndexInfo;
import com.jingdianjichi.subject.infra.basic.es.EsRestClient;
import com.jingdianjichi.subject.infra.basic.es.EsSourceData;
import com.jingdianjichi.subject.infra.basic.service.SubjectEsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * SubjectEsServiceImpl
 * @author zxf
 * @date 2024/7/18 17:55
 * @version 1.0
 */
@Service
@Slf4j
public class SubjectEsServiceImpl implements SubjectEsService {
    @Override
    public boolean insert(SubjectInfoEs subjectInfoEs) {
        EsSourceData esSourceData = new EsSourceData();
        Map<String, Object> data = convert2EsSourceData(subjectInfoEs);
        esSourceData.setDocId(subjectInfoEs.getDocId().toString());
        esSourceData.setData(data);
        return EsRestClient.insertDoc(getEsIndexInfo(), esSourceData);
    }

    private Map<String, Object> convert2EsSourceData(SubjectInfoEs subjectInfoEs) {
        Map<String,Object> data = new HashMap<>();
        data.put(EsSubjectFields.SUBJECT_ID,subjectInfoEs.getSubjectId());
        data.put(EsSubjectFields.DOC_ID,subjectInfoEs.getDocId());
        data.put(EsSubjectFields.SUBJECT_NAME,subjectInfoEs.getSubjectName());
        data.put(EsSubjectFields.SUBJECT_ANSWER,subjectInfoEs.getSubjectAnswer());
        data.put(EsSubjectFields.SUBJECT_TYPE,subjectInfoEs.getSubjectType());
        data.put(EsSubjectFields.CREATE_USER,subjectInfoEs.getCreateUser());
        data.put(EsSubjectFields.CREATE_TIME,subjectInfoEs.getCreateTime());
        return data;
    }

    @Override
    public PageResult<SubjectInfoEs> querySubjectList(SubjectInfoEs subjectInfoEs) {
        return null;
    }

    private EsIndexInfo getEsIndexInfo() {
        EsIndexInfo esIndexInfo = new EsIndexInfo();
        esIndexInfo.setClusterName("73438a827b55");
        esIndexInfo.setIndexName("subject_index");
        return esIndexInfo;
    }

}


