/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.infra.basic.entity
 * @className com.jingdianjichi.subject.infra.basic.entity.SubjectInfoEs
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.infra.basic.entity;

import com.jingdianjichi.subject.common.entity.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * SubjectInfoEs
 * @author zxf
 * @date 2024/7/18 17:54
 * @version 1.0
 */
@Data
public class SubjectInfoEs extends PageInfo implements Serializable {

    private Long subjectId;

    private Long docId;

    private String subjectName;

    private String subjectAnswer;

    private String createUser;

    private Long createTime;

    private Integer subjectType;

    private String keyWord;

    private BigDecimal score;

}

