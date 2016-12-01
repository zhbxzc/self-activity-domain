package com.self.activity.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.self.activity.service.CustomerService;
import com.self.activity.vo.QueryCustParam;
import com.self.activity.sdk.bean.PageBean;
import com.self.activity.sdk.bean.Result;
import com.self.activity.model.Customer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@Api
@RestController
@RequestMapping("cust")
public class CustomerController {
	@Resource
	private CustomerService customerService;
	@ApiOperation(value="客户注册",notes="客户的注册接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name="customer",required=true,value = "customer对象",dataType="Customer",paramType="body"),
		@ApiImplicitParam(name = "TK_BUSINESS_SERIALID", value = "交易流水", required = true,dataType="String",paramType="header",defaultValue="11111"),
		@ApiImplicitParam(name = "TK_REQUEST_SYS_CODE", value = "请求方系统编码", required = false,dataType="String",paramType="header",defaultValue="22222"),
		@ApiImplicitParam(name = "TK_REQUEST_MODULE_CODE", value = "请求方模块编码", required = false,dataType="String",paramType="header",defaultValue="33333"),
		@ApiImplicitParam(name = "TK_REQUEST_NODE_IP", value = "请求方节点IP", required = false,dataType="String",paramType="header",defaultValue="44444"),
		@ApiImplicitParam(name = "Accept", value = "接收属性", required = true,dataType="String",paramType="header",defaultValue="application/json"),
		@ApiImplicitParam(name = "Accept-Charset", value = "接收字符集", required = true,dataType="String",paramType="header",defaultValue="utf-8"),
		@ApiImplicitParam(name = "Content-Type", value = "内容类型", required = true,dataType="String",paramType="header",defaultValue="application/json; charset=UTF-8")
	})
	@RequestMapping(value="/customer",method=RequestMethod.POST,produces="application/json;charset='UTF-8'")
	public Result<Customer> register(@Valid @RequestBody Customer customer,BindingResult bindingResult,@RequestHeader HttpHeaders headers){
		customerService.register(customer);
		return new Result<Customer>("0",customer);
	}
	@ApiOperation(value="客户更新",notes="客户的更新接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name="customer",required=true,value = "customer对象",dataType="Customer",paramType="body"),
		@ApiImplicitParam(name = "TK_BUSINESS_SERIALID", value = "交易流水", required = true,dataType="String",paramType="header",defaultValue="11111"),
		@ApiImplicitParam(name = "TK_REQUEST_SYS_CODE", value = "请求方系统编码", required = false,dataType="String",paramType="header",defaultValue="22222"),
		@ApiImplicitParam(name = "TK_REQUEST_MODULE_CODE", value = "请求方模块编码", required = false,dataType="String",paramType="header",defaultValue="33333"),
		@ApiImplicitParam(name = "TK_REQUEST_NODE_IP", value = "请求方节点IP", required = false,dataType="String",paramType="header",defaultValue="44444"),
		@ApiImplicitParam(name = "Accept", value = "接收属性", required = true,dataType="String",paramType="header",defaultValue="application/json"),
		@ApiImplicitParam(name = "Accept-Charset", value = "接收字符集", required = true,dataType="String",paramType="header",defaultValue="utf-8"),
		@ApiImplicitParam(name = "Content-Type", value = "内容类型", required = true,dataType="String",paramType="header",defaultValue="application/json; charset=UTF-8")
	})
	@RequestMapping(value="/customer/{id}",method=RequestMethod.PUT,produces="application/json;charset='UTF-8'")
	public Result<Customer> alter(@PathVariable Long id,@Valid @RequestBody Customer customer,BindingResult bindingResult,@RequestHeader HttpHeaders headers){
		customer.setId(id);
		int num = customerService.alter(customer);
		if(num == 0){
			return new Result<Customer>("1");
		}
		return new Result<Customer>("0",customer);
	}
	@ApiOperation(value="客户查询",notes="客户查询接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name="name",required=false,value = "名称",dataType="String",paramType="query"),
		@ApiImplicitParam(name="idCardNo",required=false,value = "身份证号",dataType="String",paramType="query"),
		@ApiImplicitParam(name="email",required=false,value = "邮箱",dataType="String",paramType="query"),
		@ApiImplicitParam(name="birthday",required=false,value = "出生日期",dataType="Date",paramType="query"),
		@ApiImplicitParam(name="mobile",required=false,value = "移动电话",dataType="String",paramType="query"),
		@ApiImplicitParam(name="tel",required=false,value = "固定电话",dataType="String",paramType="query"),
		@ApiImplicitParam(name="nickname",required=false,value = "昵称",dataType="String",paramType="query"),
		@ApiImplicitParam(name="number",required=false,value = "页码",dataType="Int",paramType="query"),
		@ApiImplicitParam(name="size",required=false,value = "每页条数",dataType="Int",paramType="query"),
		@ApiImplicitParam(name = "TK_BUSINESS_SERIALID", value = "交易流水", required = true,dataType="String",paramType="header",defaultValue="11111"),
		@ApiImplicitParam(name = "TK_REQUEST_SYS_CODE", value = "请求方系统编码", required = false,dataType="String",paramType="header",defaultValue="22222"),
		@ApiImplicitParam(name = "TK_REQUEST_MODULE_CODE", value = "请求方模块编码", required = false,dataType="String",paramType="header",defaultValue="33333"),
		@ApiImplicitParam(name = "TK_REQUEST_NODE_IP", value = "请求方节点IP", required = false,dataType="String",paramType="header",defaultValue="44444"),
		@ApiImplicitParam(name = "Accept", value = "接收属性", required = true,dataType="String",paramType="header",defaultValue="application/json"),
		@ApiImplicitParam(name = "Accept-Charset", value = "接收字符集", required = true,dataType="String",paramType="header",defaultValue="utf-8"),
		@ApiImplicitParam(name = "Content-Type", value = "内容类型", required = true,dataType="String",paramType="header",defaultValue="application/json; charset=UTF-8")
	})
	@RequestMapping(value="/customer",method=RequestMethod.GET,produces="application/json;charset='UTF-8'")
	public Result<List<Customer>> search(QueryCustParam custparam,PageBean pageBean,@RequestHeader HttpHeaders headers){
		List<Customer> list = customerService.search(custparam,pageBean);
		Result<List<Customer>> result = new Result<List<Customer>>("0",list);
		if(pageBean.getNumber()!=null&&pageBean.getSize()!=null){
			if(pageBean.getNumber()!=0&&pageBean.getSize()!=0){
				long count = customerService.searchCount(custparam);
				pageBean.setTotalElements(count);
				pageBean.setTotalPages();
				result.setPage(pageBean);
			}
		}
		return result;
	}
	@ApiOperation(value="客户数量查询",notes="客户数量查询接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name="name",required=false,value = "名称",dataType="String",paramType="query"),
		@ApiImplicitParam(name="idCardNo",required=false,value = "身份证号",dataType="String",paramType="query"),
		@ApiImplicitParam(name="email",required=false,value = "邮箱",dataType="String",paramType="query"),
		@ApiImplicitParam(name="birthday",required=false,value = "出生日期",dataType="Date",paramType="query"),
		@ApiImplicitParam(name="mobile",required=false,value = "移动电话",dataType="String",paramType="query"),
		@ApiImplicitParam(name="tel",required=false,value = "固定电话",dataType="String",paramType="query"),
		@ApiImplicitParam(name="nickname",required=false,value = "昵称",dataType="String",paramType="query"),
		@ApiImplicitParam(name = "TK_BUSINESS_SERIALID", value = "交易流水", required = true,dataType="String",paramType="header",defaultValue="11111"),
		@ApiImplicitParam(name = "TK_REQUEST_SYS_CODE", value = "请求方系统编码", required = false,dataType="String",paramType="header",defaultValue="22222"),
		@ApiImplicitParam(name = "TK_REQUEST_MODULE_CODE", value = "请求方模块编码", required = false,dataType="String",paramType="header",defaultValue="33333"),
		@ApiImplicitParam(name = "TK_REQUEST_NODE_IP", value = "请求方节点IP", required = false,dataType="String",paramType="header",defaultValue="44444"),
		@ApiImplicitParam(name = "Accept", value = "接收属性", required = true,dataType="String",paramType="header",defaultValue="application/json"),
		@ApiImplicitParam(name = "Accept-Charset", value = "接收字符集", required = true,dataType="String",paramType="header",defaultValue="utf-8"),
		@ApiImplicitParam(name = "Content-Type", value = "内容类型", required = true,dataType="String",paramType="header",defaultValue="application/json; charset=UTF-8")
	})
	@RequestMapping(value="/customer/count",method=RequestMethod.GET,produces="application/json;charset='UTF-8'")
	public Result<PageBean> searchCount(QueryCustParam custparam,@RequestHeader HttpHeaders headers){
		Long count = customerService.searchCount(custparam);
		PageBean pb=new PageBean();
		pb.setTotalElements(count);
		return new Result<PageBean>("0",pb);
	}
	@ApiOperation(value="客户单体查询",notes="客户单体查询接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",required=true,value = "客户id",dataType="Long",paramType="path"),
		@ApiImplicitParam(name = "TK_BUSINESS_SERIALID", value = "交易流水", required = true,dataType="String",paramType="header",defaultValue="11111"),
		@ApiImplicitParam(name = "TK_REQUEST_SYS_CODE", value = "请求方系统编码", required = false,dataType="String",paramType="header",defaultValue="22222"),
		@ApiImplicitParam(name = "TK_REQUEST_MODULE_CODE", value = "请求方模块编码", required = false,dataType="String",paramType="header",defaultValue="33333"),
		@ApiImplicitParam(name = "TK_REQUEST_NODE_IP", value = "请求方节点IP", required = false,dataType="String",paramType="header",defaultValue="44444"),
		@ApiImplicitParam(name = "Accept", value = "接收属性", required = true,dataType="String",paramType="header",defaultValue="application/json"),
		@ApiImplicitParam(name = "Accept-Charset", value = "接收字符集", required = true,dataType="String",paramType="header",defaultValue="utf-8"),
		@ApiImplicitParam(name = "Content-Type", value = "内容类型", required = true,dataType="String",paramType="header",defaultValue="application/json; charset=UTF-8")
	})
	@RequestMapping(value="/customer/{id}",method=RequestMethod.GET,produces="application/json;charset='UTF-8'")
	public Result<Customer> searchById(@PathVariable Long id,@RequestHeader HttpHeaders headers){
		Customer customer = customerService.searchById(id);
		if(null == customer){
			return new Result<Customer>("CUS10030",customer);
		}
		return new Result<Customer>("0",customer);
	}
	@ApiOperation(value="客户删除",notes="客户删除接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",required=true,value = "客户id",dataType="Long",paramType="path"),
		@ApiImplicitParam(name = "TK_BUSINESS_SERIALID", value = "交易流水", required = true,dataType="String",paramType="header",defaultValue="11111"),
		@ApiImplicitParam(name = "TK_REQUEST_SYS_CODE", value = "请求方系统编码", required = false,dataType="String",paramType="header",defaultValue="22222"),
		@ApiImplicitParam(name = "TK_REQUEST_MODULE_CODE", value = "请求方模块编码", required = false,dataType="String",paramType="header",defaultValue="33333"),
		@ApiImplicitParam(name = "TK_REQUEST_NODE_IP", value = "请求方节点IP", required = false,dataType="String",paramType="header",defaultValue="44444"),
		@ApiImplicitParam(name = "Accept", value = "接收属性", required = true,dataType="String",paramType="header",defaultValue="application/json"),
		@ApiImplicitParam(name = "Accept-Charset", value = "接收字符集", required = true,dataType="String",paramType="header",defaultValue="utf-8"),
		@ApiImplicitParam(name = "Content-Type", value = "内容类型", required = true,dataType="String",paramType="header",defaultValue="application/json; charset=UTF-8")
	})
	@RequestMapping(value="customer/{id}",method=RequestMethod.DELETE,produces="application/json;charset='UTF-8'")
	public Result<Long> delete(@PathVariable Long id,@RequestHeader HttpHeaders headers){
		int count = customerService.delete(id);
		if(count == 0){
			return new Result<Long>("1");
		}
		return new Result<Long>("0",id);
	}
}
