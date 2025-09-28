package onlinestoremanagement.menu.impl;

import onlinestoremanagement.configs.ApplicationContext;
import onlinestoremanagement.entities.User;
import onlinestoremanagement.menu.Menu;
import onlinestoremanagement.services.UserManagementService;
import onlinestoremanagement.services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        User[] users = userManagementService.getUsers();

        if (users.length == 0) {
            System.out.println("Unfortunately, there are no customers.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** USERS *****");
    }
}
