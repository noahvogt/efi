import flanagan.io.KeyboardInput;
import java.math.BigInteger;

public class quersumme {
    public static void main(String arg[]) {
        KeyboardInput kb = new KeyboardInput();
        String decimalNumber = kb.readLine("decimal number =");
        
        int sum = 0;
        String currentDigit;
        
        for (int i = 0; i < decimalNumber.length(); i++) {
            currentDigit = decimalNumber.substring(i, i+1);
            System.out.printf(currentDigit + " ");
            sum += Integer.parseInt(currentDigit);
        }
        
        System.out.printf("\nquersumme = %d\n", sum);
    }
}
