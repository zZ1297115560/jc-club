/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.infra.basic.service
 * @className com.jingdianjichi.subject.infra.basic.service.SubjectEsService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.infra.basic.service;

import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.infra.basic.entity.SubjectInfoEs;

/**
 * SubjectEsService
 * @author zxf
 * @date 2024/7/18 17:55
 * @version 1.0
 */
public interface SubjectEsService {
    boolean insert(SubjectInfoEs subjectInfoEs);

    PageResult<SubjectInfoEs> querySubjectList(SubjectInfoEs subjectInfoEs);

}


