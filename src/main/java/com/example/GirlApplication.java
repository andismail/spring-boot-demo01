package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GirlApplication {

	//启动方式一:直接在IDE中run
    //启动方式二:mvn package 后 java -jar girl-0.0.1-SNAPSHOT.jar
    //启动方式三:mvn spring-boot:run
    //注意:后两种启动方式需确保运行环境的java版本
	public static void main(String[] args) {
		SpringApplication.run(GirlApplication.class, args);
	}
}
