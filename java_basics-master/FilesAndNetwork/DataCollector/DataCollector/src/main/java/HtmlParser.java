import core.Line;
import core.Station;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.*;


public class HtmlParser {
    private final static String URL_METRO = "https://skillbox-java.github.io/";
    private Document document;
    private List<Line> linesList;

    private final Map<String, List<String>> mapLines;

    private final List<Station> stationList;


    public HtmlParser() throws IOException {
        document = Jsoup.connect(URL_METRO).get();
        mapLines = new LinkedHashMap<>();
        stationList = new ArrayList<>();
        linesList = new ArrayList<>();
    }


    public List<Line> parseToListLinesFromHTML() {
        for (Element element : getLineElementsFromHTML(document)) {
            String lineName = element.text();
            String lineNumber = element.attr("data-line");
            Line line = new Line(lineNumber, lineName);
            linesList.add(line);
        }
        return linesList;
    }

    public List<Station> parseToListStationFromHTML() {
        for (Element element : getStationElementsFromHTML(document)) {
            boolean hasConnection = false;
            String stationName = element.selectFirst(".name").text().replace("ё", "е");
            if (element.select("[title*=станцию]").size() > 0) {
                hasConnection = true;
            }
            String stationNumber = element.selectFirst(".num").text().replace(".", "");
            String lineNumber = element.parent().attr("data-line");
            Station station = new Station(stationName, lineNumber, hasConnection, stationNumber);
            stationList.add(station);
        }
        return stationList;
    }

    public void printLines() {
        linesList.forEach(line -> System.out.println(line + "\n"));
    }

    public void printStations() {
        stationList.forEach(station -> System.out.println(station + "\n"));
    }


    private Elements getLineElementsFromHTML(Document document) {
        if (document == null) {
            return new Elements();
        }
        return document.select(".js-metro-line");
    }

    private Elements getStationElementsFromHTML(Document document) {
        if (document == null) {
            return new Elements();
        }
        return document.select(".single-station");
    }

    private void builder() {
        for (int i = 0; i < linesList.size(); i++) {
            ArrayList<String> stationArrayList = new ArrayList<>();
            for (int j = 0; j < stationList.size(); j++) {
                if (linesList.get(i).getLine().equals(stationList.get(j).getLineNumber())) {
                    stationArrayList.add(stationList.get(j).getNameStation());
                }
                mapLines.put(linesList.get(i).getLine(), stationArrayList);
            }
        }
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public Map<String, List<String>> getMapLines() {
        builder();
        return mapLines;
    }

    public List<Line> getLinesList() {
        return linesList;
    }

}
