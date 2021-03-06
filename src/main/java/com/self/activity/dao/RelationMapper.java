package com.self.activity.dao;

import java.util.List;

import com.self.activity.model.Relation;
import com.self.activity.vo.QueryRelationResult;

public interface RelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_relation
     *
     * @mbggenerated Fri Nov 25 09:37:25 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_relation
     *
     * @mbggenerated Fri Nov 25 09:37:25 CST 2016
     */
    int insert(Relation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_relation
     *
     * @mbggenerated Fri Nov 25 09:37:25 CST 2016
     */
    int insertSelective(Relation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_relation
     *
     * @mbggenerated Fri Nov 25 09:37:25 CST 2016
     */
    Relation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_relation
     *
     * @mbggenerated Fri Nov 25 09:37:25 CST 2016
     */
    int updateByPrimaryKeySelective(Relation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_relation
     *
     * @mbggenerated Fri Nov 25 09:37:25 CST 2016
     */
    int updateByPrimaryKey(Relation record);
    
    List<QueryRelationResult> searchBycustId(String custId);
}