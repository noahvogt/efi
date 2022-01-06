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
        System.out.println(inverseSign(divide(175, substract(add(multiply(5, 10), 30), 45))));
    }
}
