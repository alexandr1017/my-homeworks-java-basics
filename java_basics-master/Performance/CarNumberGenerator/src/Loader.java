import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        String dstFolder = "res/numbers.txt";
        int[] regions = new int[10];
        for (int i = 1; i <= 10; i++) {
            regions[i - 1] = i;
        }

        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(cores);

        for (int i = 0; i < cores; i++) {
            int begin = i * regions.length / cores;
            int end = (i + 1) * regions.length / cores;
            if (i == cores - 1) {
                end = regions.length;
            }

            int[] part = Arrays.copyOfRange(regions, begin, end);
            pool.execute(new NumberGenerator(part, dstFolder, i));

        }
        pool.shutdown();
        pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);


        System.out.println("Время выполнения программы: " + (System.currentTimeMillis() - start) + " мс");

    }
}



