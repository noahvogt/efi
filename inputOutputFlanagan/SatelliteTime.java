import java.util.Scanner;
import flanagan.io.KeyboardInput;
import flanagan.io.Db;
import flanagan.io.FileChooser;
import flanagan.io.FileOutput;
import flanagan.io.PrintToScreen;
import java.util.Arrays;
import javax.swing.table.*;
import java.lang.Math;

public class SatelliteTime {

    public static void main(String arg[])
    {
        KeyboardInput kb = new KeyboardInput();
        int seconds = kb.readInt("seconds = " +
                "bestätige mit ENTER ",1);

        int rest = 0;


        rest = seconds % 3600;
        int d = (seconds - rest) / 3600;
        seconds = rest;
        
        rest = seconds % 60;
        int h = (seconds - rest) / 60;
        seconds = rest;

        System.out.printf("%dd %dh %ds\n", d, h, seconds);
    }
}
