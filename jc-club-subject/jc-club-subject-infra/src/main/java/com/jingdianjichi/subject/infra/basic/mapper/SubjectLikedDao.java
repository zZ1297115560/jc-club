/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.infra.basic.mapper
 * @className com.jingdianjichi.subject.infra.basic.mapper.SubjectLikedDao
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jingdianjichi.subject.infra.basic.entity.SubjectLiked;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SubjectLikedDao
 * @author zxf
 * @date 2024/7/19 2:11
 * @version 1.0
 */
@Repository
public interface SubjectLikedDao extends BaseMapper<SubjectLiked> {
    int insertBatch(@Param("entities") List<SubjectLiked> entities);

}


