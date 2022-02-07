import java.util.Scanner;

public class palindrome {
    public static boolean isPalindrom(String str, boolean firstRun) {
        System.out.println("Aufruf mit: " + str);
        int length = str.length();

        if (firstRun && length == 0) {
            System.out.println("Warning: Zero length strings are not" +
                               "considered palindromes");
            return false;
        }

        if (length == 0)
            return true;
        else if (length == 1)
            return false;
        else if (str.charAt(0) == str.charAt(length-1)) 
            return isPalindrom(str.substring(1, length-1), false);
        else 
            return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf(" >>>  ");
        String input = scanner.nextLine();
        scanner.close();

        boolean bool = isPalindrom(input, true);
        System.out.println(" = " + bool);
    }
}
