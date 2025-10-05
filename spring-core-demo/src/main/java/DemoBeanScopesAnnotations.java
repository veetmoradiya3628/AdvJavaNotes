import com.myapp.entities.User;
import com.myapp.entities.User2;
import com.myapp.entities.User3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoBeanScopesAnnotations {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext();
        context.scan("com.myapp.entities");
        context.refresh();

        User2 user1 = context.getBean("user", User2.class);
        User2 user2 = context.getBean("user", User2.class);

        System.out.println("user1 == user2 : " + (user1 == user2));

        User3 user3 = context.getBean("userPrototype", User3.class);
        User3 user4 = context.getBean("userPrototype", User3.class);

        System.out.println("user3 == user4 : " + (user3 == user4));
    }
}
