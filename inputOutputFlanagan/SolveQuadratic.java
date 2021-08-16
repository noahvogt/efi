import java.util.Scanner;
import flanagan.io.KeyboardInput; // Konsole-Input
import flanagan.io.Db; // Input/Out übers Menu
import flanagan.io.FileChooser; // File-Wahl über Menu
import flanagan.io.FileOutput; //  Schreiben ins vorgebene File
import flanagan.io.PrintToScreen; // Ausgabe von 2-dim Arrays auf die Konsole 
import java.util.Arrays;
import javax.swing.table.*;
import java.lang.Math;

public class SolveQuadratic {

    public static void main(String arg[])
    {
        KeyboardInput kb = new KeyboardInput();
        double a = kb.readDouble("a = " +
                "bestätige mit ENTER ",-1.0);
        double b = kb.readDouble("b = " +
                "bestätige mit ENTER ",-1.0);
        double c = kb.readDouble("c = " +
                "bestätige mit ENTER ",-1.0);
        System.out.printf("x1 = %f\n", (-b+(Math.pow(b,2)-4*a*c)/2));
        System.out.printf("x2 = %f\n", (-b-(Math.pow(b,2)-4*a*c)/2));
    }
}
