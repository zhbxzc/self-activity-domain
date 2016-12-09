package com.self.activity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * <p>DomainApplication</p>
 * <p>TODO</p>
 *
 * @author		张海滨(329458839@qq.com)
 * @version		0.0.0
 * <table style="border:1px solid gray;">
 * <tr>
 * <th width="100px">版本号</th><th width="100px">动作</th><th width="100px">修改人</th><th width="100px">修改时间</th>
 * </tr>
 * <!-- 以 Table 方式书写修改历史 -->
 * <tr>
 * <td>0.0.0</td><td>创建类</td><td>张海滨</td><td>2016年11月24日 下午1:32:52</td>
 * </tr>
 * <tr>
 * <td>XXX</td><td>XXX</td><td>XXX</td><td>XXX</td>
 * </tr>
 * </table>
 */
@MapperScan("com.self.activity.dao")
@EnableTransactionManagement
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class SelfActivityDomainApplication
{
	@Bean
	Sampler sampler()
	{
		return span -> true;
	}

	public static void main(String[] args)
	{
		SpringApplication.run(SelfActivityDomainApplication.class, args);
	}
}
