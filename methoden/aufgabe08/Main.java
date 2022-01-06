import java.lang.Thread;

public class Main {
    static void dumpStack() {
        Thread.dumpStack();
    }
    public static void main( String[] args ) {
        dumpStack();
    }
}
