package com.self.activity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.self.activity.dao.CustomerMapper;
import com.self.activity.model.Customer;
import com.self.activity.vo.CustomerVO;
import com.self.activity.vo.QueryCustParam;
import com.self.activity.vo.QueryCustResult;
import com.self.activity.sdk.bean.PageBean;
import com.self.activity.sdk.exception.ErrorHandler;

@Service("customerService")
public class CustomerService {
	@Resource
	private CustomerMapper customerMapper;
	
	@Transactional
	public void register(CustomerVO customer){
		if(customer.getIdCardNo()!=null&&!"".equals(customer.getIdCardNo())){
			long dup = customerMapper.isDup(customer);
			if(dup>0){				
				ErrorHandler.reportError("CUS10010");
			}
		}
		customer.setId(UUID.randomUUID().toString().replace("-", ""));
		customerMapper.register(customer);
	}
	@Transactional
	public void alter(CustomerVO customer){
		if(customer.getIdCardNo()!=null&&!"".equals(customer.getIdCardNo())){
			long dup = customerMapper.isDup(customer);
			if(dup>0){
				ErrorHandler.reportError("CUS10010");
			}
		}
		customerMapper.alter(customer);
	}
	public List<Customer> search(QueryCustParam custparam,PageBean pageBean){
		pageBean.init();
		return customerMapper.search(custparam,pageBean);
	}
	public Customer searchById(String id){
		return customerMapper.searchById(id);
	}
	public int delete(String id){
		return customerMapper.delete(id);
	}
	public long searchCount(QueryCustParam custparam){
		return customerMapper.searchCount(custparam);
	}
	public List<QueryCustResult> searchCust(QueryCustParam custparam,PageBean pageBean){
		pageBean.init();
		return customerMapper.searchCust(custparam, pageBean);
	}
}
