public class Main {
    static double multiply(double a, double b, double c) {
        return a * b * c;
    }

    public static void main(String[] args) {
        double a = 0, b = 0, c = 0;
        if (args.length < 3) {
            System.out.println("Error, please enter THREE number as arguments");
            System.exit(1);
        }
        try {
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
            c = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Error, please enter three DOUBLES as arguments");
            System.exit(1);
        }
        System.out.println(multiply(a, b, c));
    }
}
