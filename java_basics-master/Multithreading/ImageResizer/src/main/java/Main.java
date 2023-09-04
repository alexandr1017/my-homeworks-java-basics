
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\alexa\\OneDrive\\Рабочий стол\\src";
        String dstFolder = "C:\\Users\\alexa\\OneDrive\\Рабочий стол\\dst";
        int newWidth = 4000;

        File srcDir = new File(srcFolder);

        long begin = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(cores);

        for (int i = 0; i < cores; i++) {
            int start = i * files.length / cores;
            int end = (i + 1) * files.length / cores;
            if (i == cores - 1) {
                end = files.length;
            }

            File[] part = Arrays.copyOfRange(files, start, end);
            pool.execute(new ImageResizer(part,newWidth,dstFolder,begin));
        }
        pool.shutdown();
    }
}
