package com.self.activity.common;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@EnableAutoConfiguration
public class SwaggerConfig {
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("cust")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.self.activity"))
				.build().apiInfo(new ApiInfo(
						"自我管理", "domain", "0.0.1", "无服务", "张海滨", 
						"联系我们", "15810357012"));
	}
}
