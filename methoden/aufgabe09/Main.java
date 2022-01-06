public class Main {
    static void tom() {
        System.out.println("Tomaten");
    }

    static void kohl() {
        System.out.println("Rotkohl Gruenkohl");
    }

    static void gen(String str) {
        System.out.println(str);
    }

    public static void main( String[] args ) {
        tom();
        kohl();
        gen("Gurken");
        tom();
        kohl();
        gen("Spinat");
        tom();
        kohl();
        gen("Kohlrabi");
    }
}
