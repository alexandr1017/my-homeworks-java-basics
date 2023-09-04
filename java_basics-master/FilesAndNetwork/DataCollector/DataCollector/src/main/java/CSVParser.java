
import core.StationWithDate;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class CSVParser {


    private List<StationWithDate> stationWithDatesList = new ArrayList<>();


    public List<StationWithDate> csvParserLink(String link) {

        try {
            List<String> lines = Files.readAllLines(Paths.get(link));
            for (int i = 1; i < lines.size(); i++) {
                String[] fragments = lines.get(i).split(",");
                if (fragments.length != 2) {
                    System.out.println("Wrong line:" + lines.get(i));
                    continue;
                }
                stationWithDatesList.add(new StationWithDate(fragments[0].replace("ё", "е"), fragments[1]));
            }
            return stationWithDatesList;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<StationWithDate> csvParserLink(List<String> finderLinksCsvFiles) {
        List<List<StationWithDate>> listsStationWithDate = new ArrayList<>();
        for (String s : finderLinksCsvFiles) {
            List<StationWithDate> listOfLink = csvParserLink(s);
            listsStationWithDate.add(listOfLink);
        }
        listsStationWithDate.remove(1);
        stationWithDatesList = listsStationWithDate.get(0);
        stationWithDatesList.sort(Comparator.comparing(StationWithDate::getNameStation));
        return stationWithDatesList;


    }

    public List<StationWithDate> getStationWithDatesList() {
        return stationWithDatesList;
    }

    public void printStationsWithDate() {
        stationWithDatesList.forEach(System.out::println);
    }


}
