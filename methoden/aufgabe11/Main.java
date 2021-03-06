public class Main {
    static double multiply(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) {
        double a = 0, b = 0;
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
        System.out.println(multiply(a, b));
    }
}
