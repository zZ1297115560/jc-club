/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.infra.basic.esRepo
 * @className com.jingdianjichi.subject.infra.basic.esRepo.SubjectEsRepository
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.infra.basic.esRepo;

import com.jingdianjichi.subject.infra.basic.entity.SubjectInfoEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * SubjectEsRepository
 * @author zxf
 * @date 2024/7/18 17:54
 * @version 1.0
 */
@Component
public interface SubjectEsRepository extends ElasticsearchRepository<SubjectInfoEs, Long> {
}

