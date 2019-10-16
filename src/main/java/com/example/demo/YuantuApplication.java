package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
/* @ComponentScan(basePackages = {"com.example.demo.dao"}) */

@MapperScan("com.example.demo.dao") //扫描的mapper
public class YuantuApplication {

	public static void main(String[] args) {
		SpringApplication.run(YuantuApplication.class, args);
	}

}
