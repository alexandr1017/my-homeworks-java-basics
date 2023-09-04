import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FinderJsonAndCsv {

    private final List<String> listOfJsonFiles;
    private final List<String> listOfCsvFiles;

    public FinderJsonAndCsv() {
        listOfJsonFiles = new ArrayList<>();
        listOfCsvFiles = new ArrayList<>();
    }

    public void searchFiles(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (extension.equals("json")) {
                    listOfJsonFiles.add(file.getAbsolutePath());
                }
                if (extension.equals("csv")) {
                    listOfCsvFiles.add((file.getAbsolutePath()));
                }
            } else if (file.isDirectory()) {
                searchFiles(file);
            }
        }
    }

    public List<String> getListOfJsonFiles() {
        return listOfJsonFiles;
    }

    public List<String> getListOfCsvFiles() {
        return listOfCsvFiles;
    }


    public void printJsonFiles() {
        getListOfJsonFiles().forEach(System.out::println);
    }

    public void printCsvFiles() {
        getListOfCsvFiles().forEach(System.out::println);
    }


}
