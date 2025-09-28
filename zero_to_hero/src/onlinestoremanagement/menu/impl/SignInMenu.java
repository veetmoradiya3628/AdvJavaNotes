package onlinestoremanagement.menu.impl;

import onlinestoremanagement.configs.ApplicationContext;
import onlinestoremanagement.entities.User;
import onlinestoremanagement.menu.Menu;
import onlinestoremanagement.services.UserManagementService;
import onlinestoremanagement.services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class SignInMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);

        System.out.print("Please, enter your email: ");
        String userEmail = sc.next();

        System.out.print("Please, enter your password: ");
        String userPassword = sc.next();

        User user = userManagementService.getUserByEmail(userEmail);
        if (user != null && user.getPassword().equals(userPassword)) {
            System.out.printf("Glad to see you back %s %s", user.getFirstName(),
                    user.getLastName() + System.lineSeparator());
            context.setLoggedInUser(user);
        } else {
            System.out.println("Unfortunately, such login and password doesn't exist");
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Sign In *****");
    }
}
