import flanagan.io.KeyboardInput;

public class reverse {
    public static void main(String arg[]) {
        KeyboardInput kb = new KeyboardInput();
        String input = kb.readLine("decimal number =");
        
        char currentDigit;
        String reverse = "";
        Boolean isNegativeNumber = false;

        if (input.charAt(0) == '-')
            isNegativeNumber = true;
        
        for (int i = input.length()-1; i >= 0; i--) {
            currentDigit = input.charAt(i);
            reverse += currentDigit;
        }

        if (isNegativeNumber)
            reverse = "-" + reverse.substring(0,reverse.length()-1);
        
        System.out.printf("\nreversed => %s\n", reverse);
    }
}
