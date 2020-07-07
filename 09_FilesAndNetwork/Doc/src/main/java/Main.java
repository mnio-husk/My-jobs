import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://lenta.ru").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Element e : doc.select("img")) {
            String err = e.attr("src");
            String[] format = err.split("\\:");
            String a = "https";
            if (format[0].equals(a)) {
                String strImgURL = e.attr("src");
                downloadImage(strImgURL);
            }
        }
    }

    private static void downloadImage(String strImageURL) {

        String strImageName = strImageURL.substring(strImageURL.lastIndexOf("/") + 1);

        System.out.println("Saving: " + strImageName + ", from: " + strImageURL);
        try {
            FileUtils.copyURLToFile(
                    new URL(strImageURL),
                    new File("images/" + strImageName)
            );
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

//        try {
//
//            URL urlImage = new URL(strImageURL);
//            InputStream in = urlImage.openStream();
//
//            byte[] buffer = new byte[4096];
//            int n = -1;
//
//            OutputStream os = new FileOutputStream("images" + "/" + strImageName);
//
//            while ((n = in.read(buffer)) != -1) {
//                os.write(buffer, 0, n);
//            }
//
//            os.close();
//
//            System.out.println("Image saved");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
