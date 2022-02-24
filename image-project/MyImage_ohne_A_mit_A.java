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

        /**
         * 1. Geben Sie den Namen des Input-Files an.
         * 2. Geben Sie den Namen des Output-Files an
         * 
         * @author (your name) 
         * @version (a version number or a date)
         */

        boolean answer = false, file_exist = false;
        String inFileName, inFileNamePfad, outFileName, outFileNamePfad, outFormat = "";

        FileNameSelector fc = new FileNameSelector("Images/");
        //         fc.setPath("Images/");

        File fin = null, fout = null;            

        while (!answer && !file_exist) {       
            inFileName = fc.selectFile("Wähle das Input-File:");
            //         System.out.println(fc.getPathName());
            inFileNamePfad = "Images/" + inFileName;
            //             System.out.println("inFileNamePfad = " + inFileNamePfad);

            fin = new File(inFileNamePfad); // input file path

            String [] inFileName_Teil = inFileName.split(Pattern.quote(".")); // Ermitteln den Stamm- und die Erweiterung-Teile von inFileName:
            // inFileName_Teil[0] = Stammname, inFileName_Teil[1] = Erweiterung (png, jpg, ...)

            outFileName = Db.readLine("Geben Sie den Namen des Output-Files MIT einer Erweiterung (png, jpg, etc.) ein" + "\n" + 
                "und drücken die ENTER-Taste für Bestätigung!", inFileName_Teil[0] + ".jpg");

            String [] outFileName_Teil = outFileName.split(Pattern.quote(".")); // Ermitteln den Stamm- und die Erweiterung-Teile von outFileName:
            // outFileName_Teil[0] = Stammname, outFileName_Teil[1] = Erweiterung (png, jpg, ...)
            outFileNamePfad = "Images/" + outFileName;

            outFormat = outFileName_Teil[1].trim();

            fout = new File(outFileNamePfad); // output file path

            if (inFileNamePfad.equals(outFileNamePfad)) { 
                file_exist = Db.noYes("Die Input- und Output-Bilddateien haben die gleichen Namen!" + "\n" +
                    "Möchten Sie trotzdem fortsetzen?");

                if (!file_exist) {
                    //                     file_exist = false;
                    System.out.println("file_exist = " + file_exist + " answer = " + answer);
                    continue;
                }

            }

            answer = Db.yesNo("Die Angaben lauten:" + "\n" +
                "Input-Bilddatei: " + "\"" + inFileNamePfad + "\"" + "\n" +
                "Output-Bilddatei: " + "\"" + outFileNamePfad + "\"" + "\n" +
                "Die Ertweiterung des Input-Files: " + "\"" + inFileName_Teil[1] + "\"" + "\n" +
                "Die Ertweiterung des Output-Files: " + "\"" + outFileName_Teil[1] + "\"" + "\n\n" +
                "Sind Sie damit einverstanden?");
        }

        BufferedImage image_on_disk = null, image_memory = null;
        boolean Alpha;

        //******************** Image einlesen ************************

        try {
            image_on_disk = ImageIO.read(fin);
            System.out.println("Reading " + fin + " complete !"); } // end try
        catch(IOException e){
            System.out.println("Error: " + e); } // end catch

        int width =  image_on_disk.getWidth(); // Breite des Images
        int height =  image_on_disk.getHeight(); // Höhe des Images  

        System.out.println("\n" + "width = " + width + " height = " + height + "\n");

        if (image_on_disk.getColorModel().hasAlpha()) {
            Alpha = true;
            System.out.println("Die Datei HAT Alpha-Kanal\n"); // image_on_disk hat A-Kanal
        } else {
            Alpha = false;
            System.out.println("Die Datei hat KEINEN Alpha-Kanal\n"); // image_on_disk hat keinen A-Kanal
        }

        //******************** Image kreieren und anpassen **********************

        if (outFormat.equals("png") && Alpha) { // png4 <-> png4
            //             System.out.println("Wir sind da: 1\n");
            image_memory = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); // Typ TYPE_INT_ARGB, 4 Kanäle: ARGB,d.h. MIT Alpha-Kanal

            // Kreieren das GLEICHE 4-Kanal Image wie image_on_disk und mit Aufrechtserhaltung des Alpha-Kanals
            image_memory.createGraphics().drawImage(image_on_disk, 0, 0, null);
        }
        else  { // png4/3 -> jpg oder png3 -> png3 oder jpg -> png3
            //             System.out.println("Wir sind da: 2\n");
            image_memory = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // Typ TYPE_INT_RGB, 3 Kanäle: RGB, d.h. OHNE Alpha-Kanal

            // Kreieren ein Image mit der gleichen Breite and Höhe wie image_on_disk und WEISSEM Hintergrund zum Erzeten des A-Kanal
            image_memory.createGraphics().drawImage(image_on_disk, 0, 0, Color.WHITE, null);
        }

        //******************** Image schreiben ************************

        try {
            ImageIO.write(image_memory, outFormat, fout);
            System.out.println("Writing " + fout + " complete !"); } // end try 
        catch(IOException e) {
            System.out.println("Error: " + e); } // end catch

        System.exit(1); // Programm beenden

    } // end main
} // end class MyImage_ohne_A_mit_A