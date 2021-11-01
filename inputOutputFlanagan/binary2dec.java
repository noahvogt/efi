import flanagan.io.KeyboardInput;
import java.math.BigInteger;
import java.lang.Math;

public class binary2dec{

    public static void main(String arg[]) {
        KeyboardInput kb = new KeyboardInput();
        String binaryNumber = kb.readLine("binary number =");

        BigInteger currentNumber, sum = BigInteger.ZERO;

        for (int i = 0; i < binaryNumber.length(); i++) {
            currentNumber = BigInteger.valueOf(Integer.parseInt(binaryNumber.substring(i,i + 1)));
            if (currentNumber.compareTo(BigInteger.ONE) == 0) {
                sum = sum.add(BigInteger.TWO.pow(binaryNumber.length() - i - 1));
            }
        }

        System.out.println(sum);
    }
}
