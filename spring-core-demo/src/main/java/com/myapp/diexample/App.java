package com.myapp.diexample;

import com.myapp.diexample.client.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
//      XML style config

//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        UserController userController = context.getBean("userController", UserController.class);
//        userController.processUser("veet.moradiya@google.com");


//        Annotation style config
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserController controller = context.getBean(UserController.class);
        controller.processUser("jane@example.com");
    }
}
