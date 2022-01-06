public class Main {
    static int multiply(int a, int b) {
        return a * b;
    }

    static int divide(int a, int b) {
        return a / b;
    }

    static int add(int a, int b) {
        return a + b;
    }

    static int substract(int a, int b) {
        return a - b;
    }

    static int inverseSign(int a) {
        return -1 * a;
    }

    public static void main(String[] args) {
        int a = 3, b = 7;
        System.out.println(multiply(a, b));
        System.out.println(divide(a, b));
        System.out.println(substract(a, b));
        System.out.println(add(a, b));
        System.out.println(inverseSign(a));
    }
}
