public class Main {
    public static void my() {
        System.out.println( "Hallo!" ); }
    public static void beta() { 
        my(); my(); }
    public static void main( String[] args ) { 
        beta(); my(); }
}
