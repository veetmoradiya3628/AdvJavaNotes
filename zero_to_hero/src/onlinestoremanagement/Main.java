package onlinestoremanagement;

import onlinestoremanagement.menu.Menu;
import onlinestoremanagement.menu.impl.MainMenu;

public class Main {
    public static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        Menu mainMenu = new MainMenu();
        mainMenu.start();
    }
}
