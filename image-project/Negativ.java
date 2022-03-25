import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Negativ {

    public static void main(String [] args) {

        String outFormat = "png";
        File inputPath = new File("img/Taj_Mahal4.png");
        File outputPath = new File("img/Taj_Mahal4_grau.png");

        BufferedImage original_image = null;

        try {
            original_image = ImageIO.read(inputPath);
            System.out.println("Reading " + inputPath + " complete !"); }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }

        int width =  original_image.getWidth();
        int height =  original_image.getHeight();

        System.out.println("\n" + "width = " + width + " height = " +
                           height + "\n");

        BufferedImage newImage = new BufferedImage(width, height,
                                         BufferedImage.TYPE_INT_ARGB); 
        newImage.createGraphics().drawImage(original_image, 0, 0, null);

    
        int p, new_p, a, r, g, b;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                p = original_image.getRGB(x, y);

                a = (p >> 24) & 0xFF; r = (p >> 16) & 0xFF;
                g = (p >> 8) & 0xFF; b = p & 0xFF;

                new_p = (a << 24) | (255 - r << 16) | (255 - g << 8) | 255 - b;

                newImage.setRGB(x, y, new_p);
            }
        }

        try {
            ImageIO.write(newImage, outFormat, outputPath);
            System.out.println("Writing " + outputPath + " complete !"); }
        catch(IOException e) {
            System.out.println("Error: " + e); 
            System.exit(1);
        }

        System.exit(0);
    }
}
