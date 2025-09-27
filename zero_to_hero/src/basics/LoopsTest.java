package basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LoopsTest {
    public static void main(String[] args) {
        int cnt = 0;
        while(cnt < 5){
            cnt++;
        }
        System.out.println("cnt : " + cnt);

        // labels
        loop1 :
        for (int i = 0; i < 5; i++) {
            System.out.println("counter i : " + i);
            loop2 :
            for (int j = 0; j < 5; j++) {
                System.out.println("counter j : " + j);
                if (j >= 0 && j < 3){
                    System.out.println("continue loop2");
                    continue loop2;
                }else{
                    System.out.println("break loop1");
                    break loop1;
                }
            }
        }

//Ex1
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        while (num > 0){
            list.add(num % 10);
            num /= 10;
        }
        Collections.reverse(list);
        for(Integer item: list)
            System.out.println(item);

//Ex2
        int height = sc.nextInt();
        for (int i = 0; i < height; i++) {
            System.out.println("*".repeat(i + 1));
        }
        for (int i = height - 1; i >= 1; i--) {
            System.out.println("*".repeat(i));
        }

//        Ex3
        int[][] matrix = {
                {1, 2, 3, 4, 5,},
                {6, 7},
                {8, 9, 10}
        };

        for(int[] row : matrix){
            for(int item: row){
                System.out.print(item);
            }
            System.out.println();
        }
    }
}
