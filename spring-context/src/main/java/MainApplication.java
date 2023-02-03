import beans.*;
import configs.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


public class MainApplication {


    public static void main(String[] args) {
        try {
            var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
            BeanOne beanPrimary = context.getBean(BeanOne.class);
            BeanOne beanByValue = context.getBean("beanByValue", BeanOne.class);
            BeanOne beanByName = context.getBean("beanByName", BeanOne.class);
            BeanOne beanByMethodName = context.getBean("beanByMethodName", BeanOne.class);

            System.out.println(beanByValue.getText());
            System.out.println(beanPrimary.getText());
            System.out.println(beanByName.getText());
            System.out.println(beanByMethodName.getText());


            // Using component annotations
            var beanByComponent = context.getBean(BeanByComponent.class);
            System.out.println(beanByComponent.getText());

            var beanByAutowire = context.getBean(BeanByAutowire.class);
            System.out.println(beanByAutowire.getText());

            // using autowiring and qualifiers
            var owner = context.getBean(Owner.class);
            System.out.println(owner);


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
