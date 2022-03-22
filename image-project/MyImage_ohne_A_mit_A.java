import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import flanagan.io.Db;
import flanagan.io.FileNameSelector;
import java.util.regex.Pattern;

public class MyImage_ohne_A_mit_A {

    public static void main(String [] args) {

        boolean answer = false, file_exist = false;
        String inFileName, inFileNamePfad, outFileName, outFileNamePfad,
               outFormat = "";

        FileNameSelector fc = new FileNameSelector("img/");
                 fc.setPath("img/Sample_204_255_20_147.png");

        File fin = null, fout = null;            

        while (!answer && !file_exist) {       
            inFileName = fc.selectFile("Wähle das Input-File:");
            //         System.out.println(fc.getPathName());
            inFileNamePfad = "img/" + inFileName;
            //             System.out.println("inFileNamePfad = " + inFileNamePfad);

            fin = new File("img/Sample_204_255_20_147.png"); // input file path

            String [] inFileName_Teil = inFileName.split(Pattern.quote(".")); 
            // Ermitteln den Stamm- und die Erweiterung-Teile von inFileName:
            // inFileName_Teil[0] = Stammname, inFileName_Teil[1] = Erweiterung (png, jpg, ...)

            outFileName = Db.readLine("Geben Sie den Namen des Output-Files" + 
                                      "MIT einer Erweiterung (png, jpg, etc.)" +
                                      "ein\nund drücken die ENTER-" + 
                                      "Taste für Bestätigung!",
                                      inFileName_Teil[0] + ".jpg");

            String [] outFileName_Teil = outFileName.split(Pattern.quote(".")); 
            // Ermitteln den Stamm- und die Erweiterung-Teile von outFileName:
            // outFileName_Teil[0] = Stammname,
            // outFileName_Teil[1] = Erweiterung (png, jpg, ...)
            outFileNamePfad = "img/" + outFileName;

            outFormat = outFileName_Teil[1].trim();

            fout = new File(outFileNamePfad); // output file path

            if (inFileNamePfad.equals(outFileNamePfad)) { 
                file_exist = Db.noYes("Die Input- und Output-Bilddateien" +
                                      "haben die gleichen Namen!\n" +
                                      "Möchten Sie trotzdem fortsetzen?");

                if (!file_exist) {
                    System.out.println("file_exist = " + file_exist +
                                       " answer = " + answer);
                    continue;
                }

            }

            answer = Db.yesNo("Die Angaben lauten:" + "\n" +
                              "Input-Bilddatei: " + "\"" + inFileNamePfad +
                              "\"" + "\n" +
                              "Output-Bilddatei: " + "\"" + outFileNamePfad +
                              "\"" + "\n" +
                              "Die Ertweiterung des Input-Files: " + "\"" +
                              inFileName_Teil[1] + "\"" + "\n" +
                              "Die Ertweiterung des Output-Files: " + "\"" +
                              outFileName_Teil[1] + "\"" + "\n\n" +
                              "Sind Sie damit einverstanden?");
        }

        BufferedImage image_on_disk = null, image_memory = null;
        boolean Alpha;

        //******************** Image einlesen ************************

        try {
            image_on_disk = ImageIO.read(fin);
            System.out.println("Reading " + fin + " complete !"); }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }

        int width =  image_on_disk.getWidth();
        int height =  image_on_disk.getHeight();

        int zahlenwert = image_on_disk.getRGB(0,0);
        System.out.println("\nZAHLENWERT (0,0): \n" + zahlenwert);
        int a = (zahlenwert >> 24) & 0xFF;
        int r = (zahlenwert >> 16) & 0xFF;
        int g = (zahlenwert >> 8) & 0xFF;
        int b = zahlenwert & 0xFF;
        System.out.println("a = " + a + " = " + Integer.toString(a, 2) + 
                           "\nr = " + r + " = " + Integer.toString(r, 2) + 
                           "\ng = " + g + " = " + Integer.toString(g, 2) + 
                           "\nb = " + b + " = " + Integer.toString(b, 2));

        int new_a = 255, new_r = 100, new_g = 150, new_b = 200, new_p = 0;

        new_p = (new_a << 24) | (new_r << 16) | (new_g << 8) | new_b;


        System.out.println("\n" + "width = " + width + " height = " + height + "\n");

        if (image_on_disk.getColorModel().hasAlpha()) {
            Alpha = true;
            System.out.println("Die Datei HAT Alpha-Kanal\n");
        } else {
            Alpha = false;
            System.out.println("Die Datei hat KEINEN Alpha-Kanal\n");
        }

        //******************** Image kreieren und anpassen **********************

        if (outFormat.equals("png") && Alpha) { // png4 <-> png4
            //             System.out.println("Wir sind da: 1\n");
            image_memory = new BufferedImage(width, height,
                                             BufferedImage.TYPE_INT_ARGB); 
            // Typ TYPE_INT_ARGB, 4 Kanäle: ARGB,d.h. MIT Alpha-Kanal

            /* Kreieren das GLEICHE 4-Kanal Image wie image_on_disk und mit
               Aufrechtserhaltung des Alpha-Kanals */
            image_memory.createGraphics().drawImage(image_on_disk, 0, 0, null);
        }
        else  { // png4/3 -> jpg oder png3 -> png3 oder jpg -> png3
            //             System.out.println("Wir sind da: 2\n");
            image_memory = new BufferedImage(width, height,
                                             BufferedImage.TYPE_INT_RGB);
            // Typ TYPE_INT_RGB, 3 Kanäle: RGB, d.h. OHNE Alpha-Kanal

            // Kreieren ein Image mit der gleichen Breite and Höhe wie
            // image_on_disk und WEISSEM Hintergrund zum Erzeten des A-Kanal
            image_memory.createGraphics().drawImage(image_on_disk, 0, 0,
                                                    Color.RED, null);
        }

        //******************** Image schreiben ************************

        try {
            image_memory.setRGB(0, 0, new_p);
            ImageIO.write(image_memory, outFormat, fout);
            System.out.println("Writing " + fout + " complete !"); }
        catch(IOException e) {
            System.out.println("Error: " + e); 
            System.exit(1);
        }

        System.exit(0);
    }
}
