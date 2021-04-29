import javax.swing.JOptionPane;
import java.util.Arrays;
import flanagan.io.Db;
import java.math.BigInteger;

/**
 * Das Program liest eine ganze Zahl N (0 <= N <= 20) und
 * berechnet den Wert von N! = 1 * 2 * ... * (N - 1) * N, wobei
 * 0! = 1 (nach Definition)
 */
public class bigIntegerFakultaet
{
    public static void main(String [] args)
    {
        int N = 0;

        /* Bedeutung: 
         * N = die gesuchte Fakultaet
         * n = laufende Fakultaet-Zahl
         * resn = leufende Fakultaet: resn = (n - 1)!, n = 0, 1, 2, ... N
         * res = Resultat: res = n! = n*(n - 1)!, n = 0, 1, 2, ... N
         *     = n* resn 
         */

        boolean valid = false;

        try {
            N = Db.readInt("Gib die Grundzahl als eine Integer-Zahl ein und " +
                "bestätige mit ENTER ");
        } catch (NumberFormatException e) {
            System.exit(1);
        }

        //  validate that: N >= 0

        if ( N < 0 ) {
                Db.show(
                "Falsche Eingabe: der Input-Parameter N < 0 \n"+
                "Probieren Sie nochmals! Das Programm ist sofort beendet!");
            System.exit(1);
        }

        // validation prompt

        Db.show(
            "Die Eingabe ist OK! Sie möchten also " + N + "! berechnen!");

        // special case: 0! = 1

        if (N == 0) {
            System.out.println("Fakultaet  " + N + "! = " + 1);
            System.exit( 0 );
        }

        System.out.format("\n%s \t n! \n-------------------------------------", " n", N);


        // use big integer
        BigInteger bigN = BigInteger.valueOf(N);
        bigN.add(BigInteger.ONE);
        bigN = bigN.add(BigInteger.ONE);
        System.out.println(bigN);
        BigInteger res = BigInteger.valueOf(1);
        BigInteger resn = BigInteger.valueOf(1);

        for (BigInteger n = BigInteger.valueOf(1); n.compareTo(bigN) < 0; n = n.add(BigInteger.ONE))
        {
            res = n.multiply(resn); // current result
            resn = res; // new overall result
            System.out.format("\n %2d \t %-20d", n, res);
        }

        System.out.format("\n-------------------------------------");

        // solution prompt

        JOptionPane.showMessageDialog (null,
            N + "! = " + res,
            "Lösung", JOptionPane.INFORMATION_MESSAGE); 
    }
}
