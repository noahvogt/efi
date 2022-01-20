public class RekursivFaku {
    public static long berechneFakultaet(int n) {
        System.out.println("Aufruf mit: " + n);
        if (n >= 1) // Abbruchbedingung noch nicht erreicht
            return n * berechneFakultaet(n - 1);
        else // Abbruchbedingung erfüllt, d.h. n ist gleich 0.
            return 1;
    }
    public static void main(String[] args) {
        int n = 10;
        long z = berechneFakultaet(n);
        System.out.println("10! = " + z);
    }
}
