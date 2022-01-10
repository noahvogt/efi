public class Main {
    static double a;
    static double b;
    static void multiply() {
        System.out.println(a * b);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Error, please enter two number as arguments");
            System.exit(1);
        }
        try {
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Error, please enter two doubles as arguments");
            System.exit(1);
        }
        multiply();
    }
}
