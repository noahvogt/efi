import flanagan.io.KeyboardInput;
import java.math.BigInteger;
import java.lang.Math;

public class binary2dec{

    public static void main(String arg[]) {
        KeyboardInput kb = new KeyboardInput();
        String binaryNumber = kb.readLine("binary number =");

        int currentNumber, sum = 0;

        for (int i = 0; i < binaryNumber.length(); i++) {
            currentNumber = Integer.parseInt(binaryNumber.substring(i,i + 1));
            if (currentNumber == 1) {
                sum += Math.pow(2, binaryNumber.length() - i - 1);
            }
        }

        System.out.println(sum);
    }
}
