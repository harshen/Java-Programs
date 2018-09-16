package com.example.spring5tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
//@SpringBootApplication(scanBasePackageClasses = {JpSpring5TutorialApplication.class, Abc.class})
public class JpSpring5TutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpSpring5TutorialApplication.class, args);
	}
}
