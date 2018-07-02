package com.vmax;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.vmax.mapper")
public class WeimaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeimaiApplication.class, args);
	}
}
