package com.self.activity.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.self.activity.dao.CustomerMapper;
import com.self.activity.model.Customer;
import com.self.activity.vo.QueryCustParam;
import com.self.activity.sdk.bean.PageBean;
import com.self.activity.sdk.exception.ErrorHandler;

@Service("customerService")
public class CustomerService {
	@Resource
	private CustomerMapper customerMapper;
	
	@Transactional
	public void register(Customer customer){
		customer.setLastUpdatedTime(null);
		if(customer.getIdCardNo()!=null&&!"".equals(customer.getIdCardNo())){
			long dup = customerMapper.isDup(customer);
			if(dup>0){				
				ErrorHandler.reportError("CUS10010");
			}
		}
		customerMapper.register(customer);
	}
	@Transactional
	public int alter(Customer customer){
		customer.setLastUpdatedTime(null);
		if(customer.getIdCardNo()!=null&&!"".equals(customer.getIdCardNo())){
			long dup = customerMapper.isDup(customer);
			if(dup>0){
				//throw new BusinessException("CUS10010");
				ErrorHandler.reportError("CUS10010");
			}
		}
		return customerMapper.alter(customer);
	}
	public List<Customer> search(QueryCustParam custparam,PageBean pageBean){
		pageBean.init();
		return customerMapper.search(custparam,pageBean);
	}
	public Customer searchById(Long id){
		return customerMapper.searchById(id);
	}
	public int delete(Long id){
		return customerMapper.delete(id);
	}
	public long searchCount(QueryCustParam custparam){
		return customerMapper.searchCount(custparam);
	}
}
