package com.cmdrawin.pdm.dashboard;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.cmdrawin.pdm.dashboard.mapper")
public class pdmDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(pdmDashboardApplication.class, args);
	}

}
