import java.util.Scanner;

public class aufgabe2c
{
    public static int berechnePotenz(int a, int n)
    {
        /* special case: a^x = 0, if x in N */
        if (a == 0)
            return 0;
        /* special case: x^0 = 1, if x in N and a != 0 */
        if (n == 0)
            return 1;

        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= a;
        }
        
        return res;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.printf("Gib einen Wert > 0 fuer a ein: ");
            int a = scanner.nextInt();
            System.out.printf("Gib einen Wert > 0 fuer n ein: ");
            int n = scanner.nextInt();
            scanner.close();

            int ergebnis = berechnePotenz(a, n);
            System.out.println("Das Ergebnis ist: " + ergebnis);
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
