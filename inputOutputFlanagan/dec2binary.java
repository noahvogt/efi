import flanagan.io.KeyboardInput;
import java.math.BigInteger;
import java.lang.Math;

public class dec2binary {
    public static void main(String arg[]) {
        KeyboardInput kb = new KeyboardInput();
        BigInteger decimalNumber = kb.readBigInteger("decimal number =");

        int i = 0;
        String binary = "";

        /* special case when input = 0 */
        if (decimalNumber.compareTo(BigInteger.ZERO) == 0) {
            System.out.println(0);
            System.exit(0);
        }

        while (true) {
            if (decimalNumber.subtract(BigInteger.TWO.pow(i)).compareTo(BigInteger.ZERO) < 0) {
                break;
            }
            i++;
        }

        for (int j = i - 1; j >= 0; j--) {
            if (decimalNumber.subtract(BigInteger.TWO.pow(j)).compareTo(BigInteger.ZERO) < 0) {
                binary += "0";
            } else {
                binary += "1";
                decimalNumber = decimalNumber.subtract(BigInteger.TWO.pow(j));
            }
        }
        
        System.out.println(binary);
        System.exit(0);
    }
}
