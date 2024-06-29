package com.jingdianjichi.subject.infra.basic.service;

import com.jingdianjichi.subject.infra.basic.entity.SubjectMapping;

import java.util.List;

/**
 * 题目分类关系表(SubjectMapping)表服务接口
 *
 * @author makejava
 * @since 2024-06-23 10:24:02
 */
public interface SubjectMappingService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectMapping queryById(Long id);

    /**
     * 新增数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    int insert(SubjectMapping subjectMapping);

    /**
     * 修改数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    int update(SubjectMapping subjectMapping);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 通过分类id查询标签id
     * @param subjectMapping 分类对象：id
     * @return 标签idList
     */
    List<SubjectMapping> queryLabelId(SubjectMapping subjectMapping);

    /**
     * 批量插入题目与分类映射
     * @param mappingList 映射列表
     */
    void batchInsert(List<SubjectMapping> mappingList);


}
