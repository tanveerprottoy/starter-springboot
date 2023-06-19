package com.github.tanveerprottoy.starterspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StarterSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(StarterSpringBootApplication.class, args);
		printAllBeans(applicationContext);
	}

	private static void printAllBeans(ApplicationContext applicationContext) {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		for(String beanName : allBeanNames) {
			System.out.println(beanName);
		}
	}
}
