package com.morkaragh.dictadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestDictadminApplication {

	public static void main(String[] args) {
		SpringApplication.from(DictadminApplication::main).with(TestDictadminApplication.class).run(args);
	}

}
