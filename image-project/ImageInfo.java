// package XXX 

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings("all")
public class ImageInfo {
    int height; // private
    int width; // private
    String mimeType;// private

    private ImageInfo() {}

    public ImageInfo(File file) throws IOException {

        FileInputStream fileInputStream = null;

        try {           
            fileInputStream = new FileInputStream(file);
            processStream(fileInputStream);
        } catch(IOException e){
            System.out.println("Error: " + e + "\n" + "Program ist sofort beendet !");
            System.exit(0);
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                System.out.println("Error: " + e + "\n" + "Program ist sofort beendet !");
                System.exit(0);
            }
        }
    }

    public ImageInfo(InputStream inputStream) throws IOException {
        processStream(inputStream);
    }

    public ImageInfo(byte[] bytes) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(bytes);
        try {
            processStream(inputStream);
        } finally {
            inputStream.close();
        }
    }

    private void processStream(InputStream inputStream) throws IOException {
        int c1 = inputStream.read();
        int c2 = inputStream.read();
        int c3 = inputStream.read();

        mimeType = null;
        width = height = -1;

        if (c1 == 'G' && c2 == 'I' && c3 == 'F') { // GIF
            inputStream.skip(3);
            width = readInt(inputStream,2,false);
            height = readInt(inputStream,2,false);
            mimeType = "image/gif";
        } else if (c1 == 0xFF && c2 == 0xD8) { // JPG
            while (c3 == 255) {
                int marker = inputStream.read();
                int len = readInt(inputStream,2,true);
                if (marker == 192 || marker == 193 || marker == 194) {
                    inputStream.skip(1);
                    height = readInt(inputStream,2,true);
                    width = readInt(inputStream,2,true);
                    mimeType = "image/jpeg";
                    break;
                }
                inputStream.skip(len - 2);
                c3 = inputStream.read();
            }
        } else if (c1 == 137 && c2 == 80 && c3 == 78) { // PNG
            inputStream.skip(15);
            width = readInt(inputStream,2,true);
            inputStream.skip(2);
            height = readInt(inputStream,2,true);
            mimeType = "image/png";
        } else if (c1 == 66 && c2 == 77) { // BMP
            inputStream.skip(15);
            width = readInt(inputStream,2,false);
            inputStream.skip(2);
            height = readInt(inputStream,2,false);
            mimeType = "image/bmp";
        } else {
            int c4 = inputStream.read();
            if ((c1 == 'M' && c2 == 'M' && c3 == 0 && c4 == 42)
            || (c1 == 'I' && c2 == 'I' && c3 == 42 && c4 == 0)) { //TIFF
                boolean bigEndian = c1 == 'M';
                int ifd = 0;
                int entries;
                ifd = readInt(inputStream,4,bigEndian);
                inputStream.skip(ifd - 8);
                entries = readInt(inputStream,2,bigEndian);
                for (int i = 1; i <= entries; i++) {
                    int tag = readInt(inputStream,2,bigEndian);
                    int fieldType = readInt(inputStream,2,bigEndian);
                    long count = readInt(inputStream,4,bigEndian);
                    int valOffset;
                    if ((fieldType == 3 || fieldType == 8)) {
                        valOffset = readInt(inputStream,2,bigEndian);
                        inputStream.skip(2);
                    } else {
                        valOffset = readInt(inputStream,4,bigEndian);
                    }
                    if (tag == 256) {
                        width = valOffset;
                    } else if (tag == 257) {
                        height = valOffset;
                    }
                    if (width != -1 && height != -1) {
                        mimeType = "image/tiff";
                        break;
                    }
                }
            }
        }
        if (mimeType == null) {
            throw new IOException("Unsupported image type");
        }
    }

    private int readInt(InputStream is, int noOfBytes, boolean bigEndian) throws IOException {
        int ret = 0;
        int sv = bigEndian ? ((noOfBytes - 1) * 8) : 0;
        int cnt = bigEndian ? -8 : 8;
        for(int i=0;i<noOfBytes;i++) {
            ret |= is.read() << sv;
            sv += cnt;
        }
        return ret;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @Override
    public String toString() {
        return "MIME Type : " + mimeType + "\t Width : " + width + "\t Height : " + height; 
    }
}
