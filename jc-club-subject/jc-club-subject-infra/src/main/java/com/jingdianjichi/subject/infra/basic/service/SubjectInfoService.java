package com.jingdianjichi.subject.infra.basic.service;

import com.jingdianjichi.subject.infra.basic.entity.SubjectInfo;

import java.util.List;

/**
 * 题目信息表(SubjectInfo)表服务接口
 *
 * @author makejava
 * @since 2024-06-23 14:22:46
 */
public interface SubjectInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectInfo queryById(Long id);

    /**
     * 新增数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    int insert(SubjectInfo subjectInfo);

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    SubjectInfo update(SubjectInfo subjectInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     *
     * @param subjectInfo 题目信息
     * @param categoryId 分类id
     * @param labelId 标签id
     * @return 符合条件的题目数量
     */
    int countByCondition(SubjectInfo subjectInfo, Integer categoryId, Integer labelId);


    /**
     * 分页查询
     * @param subjectinfo 题目信息
     * @param categoryId 分类id
     * @param labelIds 标签id
     * @param start 起始位置
     * @param pageSize 每页数量
     * @return 符合条件的题目信息
     */
    List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Integer categoryId, List<Integer> labelIds, int start, Integer pageSize);

    List<SubjectInfo> getContributeCount();
}
