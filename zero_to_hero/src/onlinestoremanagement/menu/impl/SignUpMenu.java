package onlinestoremanagement.menu.impl;

import onlinestoremanagement.configs.ApplicationContext;
import onlinestoremanagement.entities.User;
import onlinestoremanagement.entities.impl.DefaultUser;
import onlinestoremanagement.menu.Menu;
import onlinestoremanagement.services.UserManagementService;
import onlinestoremanagement.services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class SignUpMenu implements Menu {
    private UserManagementService userManagementService;
    private ApplicationContext context;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();

        Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter your first name: ");
        String firstName = sc.next();
        System.out.print("Please, enter your last name: ");
        String lastName = sc.next();
        System.out.print("Please, enter your password: ");
        String password = sc.next();
        System.out.print("Please, enter your email: ");

        sc = new Scanner(System.in);
        String email = sc.nextLine();

        User user = new DefaultUser(firstName, lastName, password, email);

        String errorMessage = userManagementService.registerUser(user);
        if (errorMessage == null || errorMessage.isEmpty()) {
            context.setLoggedInUser(user);
            System.out.println("New user is created");
        } else {
            System.out.println(errorMessage);
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** SIGN UP *****");
    }
}
