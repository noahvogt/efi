public class IterativFaku {
    public static long berechneFakultaet(int n) {
        long faku = 1;
        for (int i = 1; i <= n; i++)
            faku = faku * i;
        return faku;
    }

    public static void main(String[] args) {
        long faku = berechneFakultaet(20);
        System.out.println("10! = " + faku);
    }
}
