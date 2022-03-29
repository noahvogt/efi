import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageMirror {

    public static void main(String [] args) {

        String outFormat = "png";
        File inputPath = new File("img/Doctor_Strange.png");
        File outputPath = new File("img/Doctor_Strange_spiegel.png");

        BufferedImage original_image = null;

        try {
            original_image = ImageIO.read(inputPath);
            System.out.println("Reading " + inputPath + " complete !"); }
        catch (IOException e) {
            System.out.println("Error: " + e);
            System.exit(1);
        }

        int width =  original_image.getWidth();
        int height =  original_image.getHeight();

        System.out.println("\n" + "width = " + width + " height = " +
                           height + "\n");

        BufferedImage newImage = new BufferedImage(width * 2, height,
                                         BufferedImage.TYPE_INT_ARGB); 
        newImage.createGraphics().drawImage(original_image, 0, 0, null);
    
        int p;

        for (int y = 0; y < height; y++) {
            // lx/rx starts from the left/right side of the image
            for (int lx = 0, rx = width*2 - 1; lx < width; lx++, rx--) {
                // Pixelwert an der Koordinate (lx, y) abfragen und speichern
                p = newImage.getRGB(lx, y);
                // Spiegel-Pixel-Wert p an der Koordinate (lx, y) setzen
                newImage.setRGB(lx, y, p);
                // Spiegel-Pixel-Wert p an der Koordinate (rx, y) setzen
                newImage.setRGB(rx, y, p);
                }
        }

        try {
            ImageIO.write(newImage.getSubimage(width, 0, width, height), outFormat, outputPath);
            System.out.println("Writing " + outputPath + " complete !"); }
        catch(IOException e) {
            System.out.println("Error: " + e); 
            System.exit(1);
        }

        System.exit(0);
    }
}
