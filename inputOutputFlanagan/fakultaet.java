import javax.swing.JOptionPane;
import java.util.Arrays;
import flanagan.io.Db;

/**
 * Das Program liest eine ganze Zahl N (0 <= N <= 20) und
 * berechnet den Wert von N! = 1 * 2 * ... * (N - 1) * N, wobei
 * 0! = 1 (nach Definition)
 */
public class fakultaet
{
    public static void main(String [] args)
    {
        int N = 0;

        /* Bedeutung: 
         * N = die gesuchte Fakultaet (0 <= N <= 20)
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

        //  validate that: N >= 0 und N <= 20

        if ( N < 0 ) {
                Db.show(
                "Falsche Eingabe: der Input-Parameter N < 0 \n"+
                "Probieren Sie nochmals! Das Programm ist sofort beendet!");
            System.exit(1);
        } else if ( N >= 21 ) {
                Db.show(
                "Falsche Eingabe: der Input-Parameter N > 20 \n"+
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

        int res = 1, resn = 1;

        // loop over n = 1, 2, 3, ... N

        for (int n = 1; n <= N; n++)    // FOR-Schleife ueber die Variable n = 1,2, ... , N
        {
            res = n*resn; // n! = n*(n - 1)! = laufender n-Wert mal "resn"
            resn = res;    //  neuer resn = n!
            System.out.format("\n %2d \t %-20d", n, res);
        }

        System.out.format("\n-------------------------------------\n");

        // solution prompt

        JOptionPane.showMessageDialog (null,
            N + "! = " + res,
            "Lösung", JOptionPane.INFORMATION_MESSAGE); 
    }
}
