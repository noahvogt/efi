import java.util.Scanner;

public class recMult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("first number >>>  ");
        int a = scanner.nextInt();
        System.out.printf("second number >>> ");
        int b = scanner.nextInt();

        scanner.close();

        System.out.println("a * b = " + recMultiply(a,b));
    }

public static int recMultiply(int a, int b) {
    //System.out.println("call with a = " + a);
    if (a > 1)
        return b + recMultiply(a - 1, b);
    return b;
    }
}
