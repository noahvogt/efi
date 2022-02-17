public class TowersOfHanoi {
    static int calls = 0;

    public static void main(String[] args) {
        bewegeScheiben(3, "links", "mitte", "rechts");
    }

    public static void bewegeScheiben(int scheiben, String von, String nach, String hilfsstab) {
        if (scheiben > 0) {
            bewegeScheiben(scheiben - 1, von, hilfsstab, nach);
            calls += 1;
            System.out.printf("Zug #" + calls + " ");
            System.out.println(scheiben + ".te Scheibe von " + von + " nach " + nach);
            bewegeScheiben(scheiben - 1, hilfsstab, nach, von);
        }
    }
}
