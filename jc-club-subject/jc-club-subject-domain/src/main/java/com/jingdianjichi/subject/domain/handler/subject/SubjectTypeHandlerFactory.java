/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.handler.subject
 * @className com.jingdianjichi.subject.domain.handler.subject.SubjectTypeHandlerFactory
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SubjectTypeHandlerFactory
 * @author zxf
 * @date 2024/6/24 13:08
 * @version 1.0
 */
@Component
@Slf4j
public class SubjectTypeHandlerFactory implements InitializingBean {
    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlers;

    private final Map<SubjectInfoTypeEnum,SubjectTypeHandler> handlerMap = new HashMap<>();

    public SubjectTypeHandler getHandler(int subjectType){
        SubjectInfoTypeEnum byCode = SubjectInfoTypeEnum.getByCode(subjectType);

        if (byCode == null){
            log.error("SubjectTypeHandlerFactory.getHandler.byCode==null 未找到对应的处理器{}",byCode);
            throw new RuntimeException("未找到对应的处理器");
        }
        return handlerMap.get(byCode);
    }

    @Override
    public void afterPropertiesSet() {

        subjectTypeHandlers.forEach(subjectTypeHandler -> handlerMap.put(subjectTypeHandler.getHandlerType(),subjectTypeHandler));
    }
}

