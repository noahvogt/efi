import javax.swing.JOptionPane;
import java.util.Arrays;
import flanagan.io.Db;
import java.math.BigInteger;

/**
 * Das Program liest eine ganze Zahl N (0 <= N <= 20) und
 * berechnet den Wert von N! = 1 * 2 * ... * (N - 1) * N, wobei
 * 0! = 1 (nach Definition)
 */
public class bigIntegerPotenzen
{
    public static void main(String [] args)
    {
        int N = 0;
        int B = 3;

        /* Bedeutung: 
         * N = die gesuchte Fakultaet
         * n = laufende Fakultaet-Zahl
         * resn = leufende Fakultaet: resn = (n - 1)!, n = 0, 1, 2, ... N
         * res = Resultat: res = n! = n*(n - 1)!, n = 0, 1, 2, ... N
         *     = n* resn 
         */

        // get Basiszahl input
        try {
            B = Db.readInt("Basiszahl:" +
                "bestätige mit ENTER ");
        } catch (NumberFormatException e) {
            System.exit(1);
        }

        // get Exponent input
        try {
            N = Db.readInt("Exponent:" +
                "bestätige mit ENTER ");
        } catch (NumberFormatException e) {
            System.exit(1);
        }

        //  validate that: N, B >= 0

        if ( B < 0) {
                Db.show(
                "Falsche Eingabe: der Input-Parameter N < 0 \n"+
                "Probieren Sie nochmals! Das Programm ist sofort beendet!");
            System.exit(1);
        }

        // use big integer
        BigInteger bigN = BigInteger.valueOf(N);
        BigInteger bigB = BigInteger.valueOf(B);
        bigN.add(BigInteger.ONE);
        bigN = bigN.add(BigInteger.ONE);
        BigInteger res = BigInteger.valueOf(1);
        BigInteger resn = BigInteger.valueOf(1);

        //for (BigInteger n = BigInteger.valueOf(1); n.compareTo(bigN) < 0; n = n.add(BigInteger.ONE))
            if (N < 0) {
                //res = BigInteger.valueOf(1337);
                res = BigInteger.ONE.divide(BigInteger.valueOf(2));
                double negativeResult = res.doubleValue();
                JOptionPane.showMessageDialog (null,
                    B + "^" + N + " = " + negativeResult,
                    "Lösung", JOptionPane.INFORMATION_MESSAGE); 
            } else {
                res = bigB.pow(N);
                resn = res;

                JOptionPane.showMessageDialog (null,
                    B + "^" + N + " = " + res,
                    "Lösung", JOptionPane.INFORMATION_MESSAGE); 
            }

        // solution prompt

    }
}
