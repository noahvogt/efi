import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static int wirkmethode() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }

    public static void main(String[] args) {
        System.out.println(wirkmethode());
    }
}
