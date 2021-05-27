import javax.swing.JOptionPane;
import java.util.Arrays;
import flanagan.io.Db;
import java.math.BigInteger;

public class bigIntegerFakultaet {
    public static void main(String [] args) {
        
        // init variables
        int factorial = 0;
        BigInteger res = BigInteger.valueOf(1);
        BigInteger resn = BigInteger.valueOf(1);

        // get factorial input
        try {
            factorial = Db.readInt("factorial = ");
        } catch (NumberFormatException e) {
            Db.show("Error: no valid integer input provided");
            System.exit(1);
        }

        //  validate that: factorial >= 0
        if (factorial < 0) {
            Db.show("Error: input cannot be negative");
            System.exit(1);
        }

        // print top table row
        System.out.format("n \tn!\n\n");

        // special case: 0! = 1
        if (factorial == 0) {
            System.out.format("%d \t%d (%d-digit)\n", 0, 1, res.toString().length());
            System.exit( 0 );
        }

        // use big integer
        BigInteger bigFactorial = BigInteger.valueOf(factorial);

        for (BigInteger n = BigInteger.valueOf(1); n.compareTo(bigFactorial) <= 0; n = n.add(BigInteger.ONE))
        {
            res = n.multiply(resn); // current result
            resn = res; // new overall result
            System.out.format("%d \t%d (%d-digit)\n", n, res, res.toString().length());
        }
    }
}
