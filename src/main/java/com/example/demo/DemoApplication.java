package com.example.demo;

import com.example.demo.api.PersonController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
//@ComponentScan(basePackageClasses = PersonController.class)
public class DemoApplication {

	public static void main(String[] args) {
		//ApplicationContext ac = new ClassPathXmlApplicationContext("autowired.xml");
		SpringApplication.run(DemoApplication.class, args);
	}

}
