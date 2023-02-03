package configs;

import beans.BeanByAutowire;
import beans.BeanOne;
import beans.Cat;
import beans.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {

    @Autowired
    BeanByAutowire beanByAutowire;

    @Bean
    @Primary
    public BeanOne beanPrimary(){
        BeanOne beanOne = new BeanOne();
        beanOne.setText("beanPrimary");
        return beanOne;
    }

    @Bean
    public BeanOne beanByMethodName(){
        BeanOne beanOne = new BeanOne();
        beanOne.setText("beanByMethodName");
        return beanOne;
    }

    @Bean(value = "beanByValue")
    public BeanOne beanByValue(){
        BeanOne beanOne = new BeanOne();
        beanOne.setText("beanByValue");
        return beanOne;
    }

    @Bean(name = "beanByName")
    public BeanOne beanByName(){
        BeanOne beanOne = new BeanOne();
        beanOne.setText("beanByName");
        return beanOne;
    }

    @Bean
    public Cat cat(){
        Cat cat = new Cat();
        cat.setName("Leo");
        cat.setAge(22);
        return cat;
    }

    @Bean("dog1") // could also use @Qualifier("dog1")
    public Dog dog1(){
        Dog dog = new Dog();
        dog.setName("max");
        return dog;
    }

    @Bean("dog2") // could also use @Qualifier("dog2")
    public Dog dog2(){
        Dog dog = new Dog();
        dog.setName("Jessie");
        return dog;
    }
}
