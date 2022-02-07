import java.util.Scanner;

public class recPrime {
    public static boolean isPrime(int p, int z) {
        System.out.println("Aufruf mit: p = " + p + " , z = " + z);
        if (z == 1)
            return true;
        else if (p % z == 0)
            return false;
        else
            return isPrime(p, z-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("please enter an integer >>>  ");
        int input = scanner.nextInt();
        scanner.close();

        boolean bool = isPrime(input, input-1);
        System.out.println("Prime => " + bool);
    }
}
