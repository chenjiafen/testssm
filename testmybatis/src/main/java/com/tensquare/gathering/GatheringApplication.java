package com.tensquare.gathering;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages ="com.tensquare.gathering.mapper" )
public class GatheringApplication {

	public static void main(String[] args) {
		SpringApplication.run( GatheringApplication.class, args);
	}


	
}
