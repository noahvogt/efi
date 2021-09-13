import flanagan.io.KeyboardInput;
import java.math.BigInteger;

public class modulo {
    public static void main(String arg[]) {
        KeyboardInput kb = new KeyboardInput();
        BigInteger a = kb.readBigInteger("a =", 1);
        int b = kb.readInt("b =", 1);

        BigInteger r = a.mod(BigInteger.valueOf(b));
        BigInteger k = a.subtract(r).divide(BigInteger.valueOf(b));

        System.out.println("a = k * b + r");
        System.out.printf("k = %d, r = %d\n", k, r);
    }
}
