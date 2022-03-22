import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MyImageInfo{
    public static void main(String args[]) throws IOException{
        BufferedImage image_on_disk = null;
        File inputFilePath = new File("img/Sample_204_255_20_147.png"),
            outputFilePath = new File("img/Sample_204_255_20_147.jpg");

        ImageInfo imageInfo = new ImageInfo(inputFilePath);
        System.out.println("Informationen zum input-File " + inputFilePath +
                           ":\n" + imageInfo + "\n");

        int width = imageInfo.width;
        int height = imageInfo.height;

        image_on_disk = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        //read image
        try {
            image_on_disk = ImageIO.read(inputFilePath);
            System.out.println("Reading " + inputFilePath + " complete !");
        } catch(IOException e){
            System.out.println("Error: " + e);
        }

        //write image
        try {
            ImageIO.write(image_on_disk, "jpg", outputFilePath);
            System.out.println("Writing " + outputFilePath + " complete !");
        } catch(IOException e){
            System.out.println("Error: " + e);
        }
    }
}

// BufferedImage bufferedImage;
// 
// 	try {
// 
// 	  //read image file
// 	  bufferedImage = ImageIO.read(new File("c:\\javanullpointer.png"));
// 
// 	  // create a blank, RGB, same width and height, and a white background
// 	  BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(),
// 			bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
// 	  newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
// 
// 	  // write to jpeg file
// 	  ImageIO.write(newBufferedImage, "jpg", new File("c:\\javanullpointer.jpg"));
// 
// 	  System.out.println("Done");
// 
// 	} catch (IOException e) {
// 
// 	  e.printStackTrace();
// 
// 	}
// 
//    }
// 
// }
