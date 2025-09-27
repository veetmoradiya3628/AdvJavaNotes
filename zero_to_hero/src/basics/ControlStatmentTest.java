package basics;

import java.util.Random;
import java.util.Scanner;

public class ControlStatmentTest {
    public static void main(String[] args) {
        int balance = 20;
        int price = 10;

        if (balance >= price) {
            System.out.println("purchase possible");
        } else {
            System.out.println("In sufficient balance");
        }

//        boolean isFloat = (args[0].contains(".")) || args[1].contains(".");
//        if (isFloat) {
            // At least one floating point → calculate as double
//            double number1 = Double.parseDouble(args[0]);
//            double number2 = Double.parseDouble(args[1]);
//            double ans = number1 + number2;
//            System.out.println(ans);
//        } else {
//            // Both are integers → calculate as int
//            int number1 = Integer.parseInt(args[0]);
//            int number2 = Integer.parseInt(args[1]);
//            int ans = number1 + number2;
//            System.out.println(ans);
//        }

        int age = (((int)(Math.random() * 100)) % 30) + 1;
        switch (age){
            case 1: case 2: case 3: case 4: case 5:
            case 6: case 7: case 8: case 9: case 10:
                System.out.println("Age in range of 1 to 10 which is : " + age);
                break;
            default:
                System.out.println("Other age: " + age);
        }

        System.out.print("Please, enter action name: ");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        switch (userInput){
            case "login":
                System.out.println("Please, enter your username");
                break;
            case "sign_up":
                System.out.println("Welcome!");
                break;
            case "terminate_program":
                System.out.println("Thank you! Good bye!");
                break;
            case "main_menu":
                System.out.println("Main menu");
                break;
            case "about_app":
                System.out.println("This app is created by me and support of \u00AEIT-Bulls.com");
                break;
            default:
                System.out.println("Please, enter one of these values: login, sign_up, terminate_program, main_menu, about_app");
        }

        Random r = new Random(); // pseudo random number - fully random number is not possible to generate in real world
        System.out.println(r.nextDouble());
        System.out.println(r.nextFloat());
    }
}