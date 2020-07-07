import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    static final int newWidth = 300;
    static final int newHeight = 300;

    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\Михаил\\Desktop\\scr";
        String dstFolder = "C:\\Users\\Михаил\\Desktop\\dst";

        File srcDir = new File(srcFolder);

        File[] files = srcDir.listFiles();

        int middle =files.length / 2;

        File[] files1 = new File[middle];
        System.arraycopy(files,0,files1,0,files1.length);
//        CompressImages compressImagesFolder1 = new CompressImages(files1,newWidth,dstFolder);
//        compressImagesFolder1.run();
        Buffer bufferF1 = new Buffer(files1,dstFolder,newWidth,newHeight);
        bufferF1.run();

        File[] files2 = new File[files.length - middle];
        System.arraycopy(files,middle,files2,0,files2.length);
//        CompressImages compressImagesFolder2 = new CompressImages(files2,newWidth,dstFolder);
//        compressImagesFolder2.run();
        Buffer bufferF2 = new Buffer(files2,dstFolder,newWidth,newHeight);
        bufferF2.run();






    }

    }

