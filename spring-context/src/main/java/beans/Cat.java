package beans;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@Component
public class Cat {
    private String name;
    private int age; // this is set in the  @Configuration bean

    @PostConstruct // this is run after the @Configuration bean
    private void init(){
        name = "tom";
    }
}
