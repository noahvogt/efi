import javax.swing.JOptionPane;
import java.util.Arrays;
import flanagan.io.Db;
import java.math.BigInteger;

public class bigIntegerPotenzen {
    public static void main(String [] args) {

        // init variables
        int exponent = 0;
        int base = 3;
        BigInteger res;

        // get base input
        try {
            base = Db.readInt("base = ");
            System.out.println("base input = " + base);
        } catch (NumberFormatException e) {
            Db.show("Error: no valid integer input provided");
            System.exit(1);
        }

        // get exponent input
        try {
            exponent = Db.readInt("exponent = ");
            System.out.println("exponent input = " + exponent);
        } catch (NumberFormatException e) {
            Db.show("Error: no valid integer input provided");
            System.exit(1);
        }

        // print dashes
        for (int i = 0; i < 80; i++) {
            System.out.format("-");
        }
        System.out.println();

        //  validate that: exponent, base >= 0
        if (base < 0) {
            Db.show("Error: 'base' cannot be negative");
            System.exit(1);
        } else if (exponent < 0) {
            Db.show("Error: 'exponent' cannot be negative");
            System.exit(1);
        }

        // use big integer
        BigInteger bigN = BigInteger.valueOf(exponent);
        BigInteger bigB = BigInteger.valueOf(base);

        for (int n = 0; n <= exponent; n++) {
            res = bigB.pow(n);

            System.out.format("n = %d \t %d^%d \t %d (%d-digit)\n", n, base, n, res, res.toString().length());
        }
        
        // print dashes
        for (int i = 0; i < 80; i++) {
            System.out.format("-");
        }
        System.out.println();

        System.out.println("Successfully executed the task ...");
        System.exit(0);
    }
}
