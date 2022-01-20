import java.util.Scanner;

public class aufgabe5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("first number >>>  ");
        int a = scanner.nextInt();
        System.out.printf("second number >>> ");
        int b = scanner.nextInt();

        scanner.close();

        System.out.println("a + b = " + recSum(a, b, 0));
        System.out.println("a * b = " + recMultiply(a,b));
    }

    public static int recSum(int a, int b, int result) {
        //System.out.println("a = " + a + " b = " + b + " result = " + result);
        if (a >= 1)
            return recSum(a - 1, b, result + 1);
        if (b >= 1)
            return recSum(a, b - 1, result + 1);
        return result;
    }

    public static int recMultiply(int a, int b) {
        //System.out.println("call with a = " + a);
        if (a > 1)
            return recSum(b, recMultiply(a - 1, b), 0);
        return b;
    }
}

