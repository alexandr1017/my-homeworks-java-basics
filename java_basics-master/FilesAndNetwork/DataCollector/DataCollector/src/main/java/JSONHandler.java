import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.StationWithDepth;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class JSONHandler {


    private List<StationWithDepth> stationWithDepthList;


    public List<StationWithDepth> jsonParserLink(String link) {

        try {
            String jsonFile = Files.readString(Paths.get(link));
            ObjectMapper objectMapper = new ObjectMapper();
            stationWithDepthList = objectMapper.readValue(jsonFile, new TypeReference<List<StationWithDepth>>() {
            });
            return stationWithDepthList;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public List<StationWithDepth> jsonParserLink(List<String> finderLinksJsonFiles) {
        List<List<StationWithDepth>> listsStationWithDepth = new ArrayList<>();
        for (String s : finderLinksJsonFiles) {
            listsStationWithDepth.add(jsonParserLink(s));
        }
        stationWithDepthList = listsStationWithDepth
                .stream()
                .flatMap(Collection::stream)
                .toList();

        return stationWithDepthList
                .stream()
                .peek(stationWithDepth -> stationWithDepth.setNameStation(stationWithDepth.getNameStation().replace("ё", "е")))
                .sorted(Comparator.comparing(StationWithDepth::getNameStation).thenComparing(StationWithDepth::getDepth))
                .toList();
    }

    public List<StationWithDepth> getStationWithDepthList() {
        return stationWithDepthList;
    }

    public void printStationsWithDepth() {
        stationWithDepthList.forEach(System.out::println);
    }


}
