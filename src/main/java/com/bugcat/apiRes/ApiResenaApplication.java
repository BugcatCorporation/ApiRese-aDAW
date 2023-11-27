package com.bugcat.apiRes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class ApiResenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiResenaApplication.class, args);
	}

}
