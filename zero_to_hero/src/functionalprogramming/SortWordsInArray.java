package functionalprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortWordsInArray {
    public static void main(String[] args) {
        System.out.print("Please, enter words separated by space: ");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] words = line.split("\\s+");

        Arrays.sort(words, (s1, s2) -> {
            int result = s2.length() - s1.length();
            if (result == 0) {
                result = s1.compareToIgnoreCase(s2);
            }
            return result;
        });
        for (String word : words){
            System.out.print(word + " ");
        }
    }
}
