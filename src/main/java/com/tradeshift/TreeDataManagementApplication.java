package com.tradeshift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:tree-data-management-queries.xml")
public class TreeDataManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreeDataManagementApplication.class, args);
	}
}
