/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.infra.basic.entity
 * @className com.jingdianjichi.subject.infra.basic.entity.EsSubjectFields
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.infra.basic.entity;

/**
 * EsSubjectFields
 * @author zxf
 * @date 2024/7/18 20:27
 * @version 1.0
 */
public class EsSubjectFields {
    public static final String DOC_ID = "doc_id";

    public static final String SUBJECT_ID = "subject_id";

    public static final String SUBJECT_NAME = "subject_name";

    public static final String SUBJECT_ANSWER = "subject_answer";

    public static final String SUBJECT_TYPE = "subject_type";

    public static final String CREATE_USER = "create_user";

    public static final String CREATE_TIME = "create_time";

    public static final String[] FIELD_QUERY = {
            SUBJECT_ID, SUBJECT_NAME, SUBJECT_ANSWER, SUBJECT_TYPE, DOC_ID, CREATE_USER, CREATE_TIME
    };

}

