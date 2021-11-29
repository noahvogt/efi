import flanagan.io.KeyboardInput;
import java.math.BigInteger;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class chosen_base_to_chosen_base {

    public static void main(String arg[]) {
        KeyboardInput kb = new KeyboardInput();
        String input_number = kb.readLine("input number =");
        BigInteger input_base = kb.readBigInteger("input base =");
        BigInteger output_base = kb.readBigInteger("output base =");

        BigInteger current_number, decimal_number = BigInteger.ZERO;
        String chartable = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        /* exit when one of the chosen bases is too big for the chartable */
        if (input_base.compareTo(BigInteger.valueOf(chartable.length())) == 1 ||
            output_base.compareTo(BigInteger.valueOf(chartable.length())) == 1 ) {
            System.out.println("Error: chosen base was out too big in " +
                "respect to the chartable defined by this program");
            System.exit(1);
        }

        /* calc decimal number */
        for (int i = 0; i < input_number.length(); i++) {
            current_number = BigInteger.valueOf(chartable.indexOf(
                input_number.substring(i,i + 1)));
            /* exit when digit is bigger than base allows */
            if (input_base.compareTo(current_number) < 1 ) {
                System.out.println("Error: Nonsensical input. Plase make sure " +
                    "not to use digits bigger than the base allows");
                System.exit(1);
            }
            decimal_number = decimal_number.add(current_number.multiply(
                input_base.pow(input_number.length() - i - 1)));
            
        }

        ArrayList<Character> remainders = new ArrayList<Character>();
        String output_number = "";

        /* calculate remainders */
        while(decimal_number.compareTo(BigInteger.ZERO) > 0){
            remainders.add(chartable.charAt(decimal_number.mod(output_base).intValue()));
            decimal_number = decimal_number.divide(output_base);
        }

        /* reverse remainders to get the output number */
        for (int i = 1;i <= remainders.size(); i++){
            output_number += remainders.get(remainders.size()-i);
        }

        System.out.println(output_number);
        System.out.printf("length: %d\n", output_number.length());
        System.exit(0);
    }
}
