import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Buffer extends Thread {
    private File[] files;
    private String dstFolder;
    private int width;
    private int height;

    public Buffer(File[] files, String dstFolder, int width, int height) {
        this.files = files;
        this.dstFolder = dstFolder;
        this.width = width;
        this.height = height;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            for (File file : files) {
                BufferedImage img = ImageIO.read(file);
                BufferedImage scaledImg = Scalr.resize(img, Scalr.Mode.AUTOMATIC, width, height);
                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(scaledImg, "jpg", newFile);
            }
        } catch (Exception ex) {
            System.err.println("error");
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}
