package basics;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodsTest {
    private static int sum(int... ints) {
        int sum = 0;
        for (int i : ints) sum += i;
        return sum;
    }

    public static int findMaxIntInArray(int[] intArray) {
        int maxVal = Integer.MIN_VALUE;
        for (int val : intArray) {
            maxVal = Math.max(maxVal, val);
        }
        return maxVal;
    }

    public static void drawRectangle(int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

    public static int getWordsAmount(String text) {
        String[] words = text.split("\\W+");
        return words.length;
    }

    public static String[] filterWordsByLength(int minLength, String[] words) {
        return Arrays.stream(words).filter(word -> word.length() >= minLength).toArray(String[]::new);
    }

    private static void transposeMatrix(double[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // start from i+1
                double temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void verticalReflection(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows / 2; i++) {
            double[] temp = matrix[i];
            matrix[i] = matrix[rows - 1 - i];
            matrix[rows - 1 - i] = temp;
        }
    }

    private static void horizontalReflection(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                double temp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - 1 - j];
                matrix[i][cols - 1 - j] = temp;
            }
        }
    }

    /**
     * The method extends array.
     * If array {1, 2, 3} has been passed to this method then array {1, 2, 3, 2, 4, 6}
     * is returned from this method.
     *
     * @param arr - base of extension. Extended array contains elements from this array
     *            and additionally contains the same elements multiplied by two.
     * @return extended array.
     */
    public static int[] extendArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n * 2];

        for (int i = 0; i < n; i++) {
            ans[i] = arr[i];          // first copy
            ans[i + n] = arr[i] * 2;  // second copy, multiplied by 2
        }

        return ans;
    }

    public static int[] generateRandomArray(int amountOfElements) {
        int[] array = new int[amountOfElements];
        Random random = new Random();

        for (int i = 0; i < amountOfElements; i++) {
            array[i] = random.nextInt(100) + 1;
        }

        return array;
    }

    public static int gcdRecursive(int firstNumber, int secondNumber) {
        firstNumber = Math.abs(firstNumber);
        secondNumber = Math.abs(secondNumber);
        if (secondNumber == 0) return firstNumber;
        return gcdRecursive(secondNumber, firstNumber % secondNumber);
    }

    public static int sumDigitsInNumber(int number) {
        number = Math.abs(number);
        int ans = 0;
        while (number > 0) {
            ans += (number % 10);
            number /= 10;
        }
        return ans;
    }

    public static String convert1(String input) {
        StringBuilder sb = new StringBuilder();
        String[] lines = input.split("\\R");
        for (int i = 1; i < lines.length; i++) {
            String[] parts = lines[i].split(";");
            String login = parts[0].trim();
            String email = parts[2].trim();
            sb.append(login).append(" ==> ").append(email).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert2(String input) {
        StringBuilder sb = new StringBuilder();
        String[] lines = input.split("\\R");
        for (int i = 1; i < lines.length; i++) {
            String[] parts = lines[i].split(";");
            String fullName = parts[1].trim();
            String email = parts[2].trim();
            sb.append(fullName).append(" (email: ").append(email).append(")").append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String firstCharToTitleCase(String string) {
        StringBuilder result = new StringBuilder(string);

        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(string);

        int offset = 0; // to adjust indices after replacement
        while (matcher.find()) {
            int start = matcher.start() + offset;
            int end = matcher.end() + offset;
            String word = result.substring(start, end);
            String capitalized = Character.toUpperCase(word.charAt(0))
                    + word.substring(1).toLowerCase();
            result.replace(start, end, capitalized);
            offset += capitalized.length() - word.length();
        }

        return result.toString();
    }

    public static void main(String[] args) {

    }
}