package com.self.activity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.self.activity.model.Customer;
import com.self.activity.vo.QueryCustParam;
import com.self.activity.sdk.bean.PageBean;

public interface CustomerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_customer
     *
     * @mbggenerated Fri Nov 25 09:37:25 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_customer
     *
     * @mbggenerated Fri Nov 25 09:37:25 CST 2016
     */
    int insert(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_customer
     *
     * @mbggenerated Fri Nov 25 09:37:25 CST 2016
     */
    int insertSelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_customer
     *
     * @mbggenerated Fri Nov 25 09:37:25 CST 2016
     */
    Customer selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_customer
     *
     * @mbggenerated Fri Nov 25 09:37:25 CST 2016
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_customer
     *
     * @mbggenerated Fri Nov 25 09:37:25 CST 2016
     */
    int updateByPrimaryKey(Customer record);
    
    List<Customer> search(@Param(value="cust")QueryCustParam custparam,@Param(value="page")PageBean pageBean);
    
    Customer searchById(Long id);
    
    int delete(Long id);
    
    long searchCount(QueryCustParam custparam);
    
    long isDup(Customer customer);
    
    int register(Customer customer);
    
    int alter(Customer customer);
    
    
}