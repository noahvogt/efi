import java.util.Scanner;

public class aufgabe2a
{
    public static int berechnePotenz(int a, int n)
    {
        if (n > 1)
            return a * berechnePotenz(a, n - 1);
        else
            return a;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.printf("Gib einen Wert > 0 fuer a ein: ");
            int a = scanner.nextInt();
            System.out.printf("Gib einen Wert > 0 fuer n ein: ");
            int n = scanner.nextInt();

            int ergebnis = berechnePotenz(a, n);
            System.out.println("Das Ergebnis ist: " + ergebnis);
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
