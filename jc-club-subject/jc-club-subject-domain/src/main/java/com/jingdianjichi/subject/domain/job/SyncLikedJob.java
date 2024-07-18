/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.job
 * @className com.jingdianjichi.subject.domain.job.SyncLikedJob
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.job;

import com.jingdianjichi.subject.domain.service.SubjectLikedDomainService;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * SyncLikedJob
 * @author zxf
 * @date 2024/7/19 2:20
 * @version 1.0
 */
@Component
@Slf4j
public class SyncLikedJob {
    @Resource
    private SubjectLikedDomainService subjectLikedDomainService;

    /**
     * 同步点赞数据任务
     */
    @XxlJob("syncLikedJobHandler")
    public void syncLikedJobHandler() throws Exception {
        XxlJobHelper.log("syncLikedJobHandler.start");
        try {
            subjectLikedDomainService.syncLiked();
        } catch (Exception e) {
            XxlJobHelper.log("syncLikedJobHandler.error" + e.getMessage());
        }
    }

}

