import flanagan.io.KeyboardInput;
import java.math.BigInteger;
import java.lang.Math;

public class dec {
    public static void main(String arg[]) {
        KeyboardInput kb = new KeyboardInput();
        int decimalNumber = kb.readInt("decimal number =");

        int currentNumber, sum = 0, cur = 0; i = 0;

        while (true) {
            if (decimalNumber - Math.pow(2,i) < 0) {
                break;
            }
            i++;
        }

        String binary = "";
        for (int j = i - 1; j >= 0; j--) {
            if (decimalNumber - Math.pow(2,j) < 0) {
                binary += "0";
            } else {
                binary += "1";
                decimalNumber -= Math.pow(2,j);
            }
        }
        
        System.out.println(binary);
    }
}
