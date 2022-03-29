import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.concurrent.ThreadLocalRandom;

public class RandomImage {
    public static void main(String args[]) throws IOException {

        int width = 640;
        int height = 320;
        int p, a, r, g, b;

        BufferedImage img = new BufferedImage (width, height, BufferedImage.TYPE_INT_ARGB);
        File fout = new File("img/Random_Image_6.png");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.println("x = " + x + ", y = " + y);
                a =  ThreadLocalRandom.current().nextInt(0, 256);
                //a = 0;
                r =  ThreadLocalRandom.current().nextInt(0, 256);
                g =  ThreadLocalRandom.current().nextInt(0, 256);
                b =  ThreadLocalRandom.current().nextInt(0, 256);
                p = (a << 24) | (r << 16) | (g << 8) | b;
                System.out.println("r = " + r + ", g = " + g + ", b = " + b);
                System.out.println("x = " + x + ", y = " + y + ", p = " + p);
                img.setRGB(x, y, p);
            }
        }

        try {
            ImageIO.write(img, "png", fout);
        } catch (IOException e) {
            System.out.println(e) ;
        }
    }
}
