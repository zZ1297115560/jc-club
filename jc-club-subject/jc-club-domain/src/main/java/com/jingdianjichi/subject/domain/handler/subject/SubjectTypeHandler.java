/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.handler.subject
 * @className com.jingdianjichi.subject.domain.handler.subject.SubjectTypeHandler
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.entity.SubjectOptionBO;

/**
 * SubjectTypeHandler
 * @author zxf
 * @date 2024/6/24 13:02
 * @version 1.0
 */
public interface SubjectTypeHandler {
    /**
     * 枚举身份的识别
     * @return 枚举类型
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际题目的插入
     * @param subjectInfoBO 题目信息
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 根据题目id查询题目信息
     * @param subjectId 题目id
     * @return 题目信息
     */
    SubjectOptionBO query(Integer subjectId);
}

