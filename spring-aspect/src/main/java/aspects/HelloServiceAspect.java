package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloServiceAspect {

    @Before("execution(* services.HelloService.sayHello(..))")
    public void before(){
        System.out.println("Before executing sayHello");
    }

    @After("execution(* services.HelloService.sayHello(..))")
    public void after(){
        System.out.println("After executing sayHello");
    }

    @AfterReturning("execution(* services.HelloService.sayHello(..))")
    public void afterReturning(){
        System.out.println("After returning sayHello");
    }

    @AfterThrowing("execution(* services.HelloService.sayHelloButThrow(..))")
    public void afterThrowing(){
        System.out.println("After Throwing sayHello");
    }

    @Around("execution(* services.HelloService.sayHello(..))")
    public Object upperCase(ProceedingJoinPoint joinPoint) {
       String object = (String) joinPoint.getArgs()[0];
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        return object.toUpperCase();
    }
}
