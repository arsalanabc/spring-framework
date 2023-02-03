package beans;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Data
public class BeanByComponent {
    private String text;

    @PostConstruct
    void init(){
        text = "Can't create a default instance of with Component annotation \nSo we have to use post construct";
    }
}

