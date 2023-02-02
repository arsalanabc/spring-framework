package org.example;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.HelloService;

public class Main {
    public static void main(String[] args) {

        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            HelloService helloService = c.getBean(HelloService.class);
            System.out.println("FROM main " + helloService.sayHello("John"));
        }
    }
}