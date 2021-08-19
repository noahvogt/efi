import java.util.Arrays;
import javax.swing.table.*;
import java.lang.Math;

public class geradengleichung {

    static void errorExit(String errorMsg) {
        System.out.println("Error: " + errorMsg);
        System.exit(1);
    }
    
    public static void main(String args[]) {
        if (args.length != 4) {
            errorExit("please provide 4 commandline arguments");
        }

    int Px = 0, Py = 0, Qx = 0, Qy = 0;
    try {
        Px = Integer.parseInt(args[0]);
        Py = Integer.parseInt(args[1]);
        Qx = Integer.parseInt(args[2]);
        Qy = Integer.parseInt(args[3]);
    } catch (NumberFormatException e) {
        errorExit("please only provide integer input");
    }

    double delta_y = Math.abs(Py-Qy);
    double delta_x = Math.abs(Px-Qx); 
    double a = delta_y / delta_x;
    double b = Math.min(Py, Qy);
    
    System.out.printf("f(x) = %fx + %f\n", a, b);
    }
}
