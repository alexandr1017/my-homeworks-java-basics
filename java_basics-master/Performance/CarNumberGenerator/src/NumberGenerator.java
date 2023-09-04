import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class NumberGenerator implements Runnable {
    private int[] regionArray;
    private PrintWriter writer;

    private static final char LETTERS[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

    public NumberGenerator(int[] regionArray, String dstFolder, int fileNumber) throws FileNotFoundException {
        this.regionArray = regionArray;
        writer = new PrintWriter(dstFolder.replace(".txt", fileNumber + ".txt"));
    }

    @Override
    public void run() {
        System.out.println("Запуск нового потока");

        for (int regionCode : regionArray) {
            StringBuilder sb = new StringBuilder();
            for (int number = 1; number < 1000; number++) {
                for (char firstLetter : LETTERS) {
                    for (char secondLetter : LETTERS) {
                        for (char thirdLetter : LETTERS) {
                            sb.append(firstLetter)
                                    .append(padNumber(number, 3))
                                    .append(secondLetter)
                                    .append(thirdLetter)
                                    .append(padNumber(regionCode, 2))
                                    .append("\n");
                        }
                    }
                }
            }
            writer.write(sb.toString());
        }


        writer.flush();
        writer.close();

    }

    private String padNumber(int number, int numberLength) {
        StringBuilder sb = new StringBuilder();
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        for (int i = 0; i < padSize; i++) {
            sb.append('0');
        }
        sb.append(numberStr);
        return sb.toString();
    }
}
