import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MyImageInfo{
    public static void main(String args[]) throws IOException{
        BufferedImage image_on_disk = null;
        //         File fin = new File("Images/Computer3.png"),
        //         fout = new File("Images/Computer3.jpg"); // input/output file paths
        File fin = new File("Images/Taj_Mahal3.png"), // input file path
        fout = new File("Images/Taj_Mahal3.jpg"); // output file path

        ImageInfo imageInfo = new ImageInfo(fin);
        System.out.println("Informationen zum input-File " + fin + ":\n" + imageInfo + "\n");

        int width = imageInfo.width;     // width of the image
        int height = imageInfo.height;   // height of the image

        image_on_disk = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        //read image
        try {
            image_on_disk = ImageIO.read(fin);
            System.out.println("Reading " + fin + " complete !");
        } catch(IOException e){
            System.out.println("Error: " + e);
        }

        //write image
        try {
            ImageIO.write(image_on_disk, "jpg", fout);
            System.out.println("Writing " + fout + " complete !");
        } catch(IOException e){
            System.out.println("Error: " + e);
        }
    }//main() ends here
}//class ends here

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