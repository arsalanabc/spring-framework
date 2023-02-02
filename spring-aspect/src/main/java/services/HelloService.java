package services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayHello(String name){
        String format = String.format("hello, %s !", name);
        System.out.println(format);
        return format;
    }

    public String sayHelloButThrow(){
        throw new RuntimeException(":(");
    }
}
