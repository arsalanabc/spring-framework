package beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Component
public class Owner {

    private final Cat cat;

    private Dog dog;

    @Autowired
    public Owner(Cat cat, @Qualifier("dog1") Dog dog) {
        this.cat = cat;
        this.dog = dog;
    }
}
