package com.vmax;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.vmax.mapper")
@ServletComponentScan
public class WeimaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeimaiApplication.class, args);
	}
}
