
import core.RootMetro;
import core.RootStationInfo;

import java.io.File;
import java.io.IOException;


public class Main {
    public static final String ZIP_FILE_PATH = "src/main/resources/stations-data.zip";

    public static void main(String[] args) throws IOException {

        HtmlParser htmlParser = new HtmlParser();
        htmlParser.parseToListStationFromHTML();
        htmlParser.parseToListLinesFromHTML();

//        try {
//            Zipper.unzip(ZIP_FILE_PATH, "data/");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

        FinderJsonAndCsv finderJsonAndCsv = new FinderJsonAndCsv();
        finderJsonAndCsv.searchFiles(new File("data/"));
        System.out.println("Найдены следующие файлы с расширениями json и csv:");
        finderJsonAndCsv.printJsonFiles();
        finderJsonAndCsv.printCsvFiles();


        JSONHandler jsonHandler = new JSONHandler();
        jsonHandler.jsonParserLink(finderJsonAndCsv.getListOfJsonFiles());


        CSVParser csvParser = new CSVParser();
        csvParser.csvParserLink(finderJsonAndCsv.getListOfCsvFiles());

        BuilderStationUlt builderStationUlt = new BuilderStationUlt(htmlParser, jsonHandler, csvParser);
        builderStationUlt.buildStationUltCollection();

        RootMetro metro = new RootMetro(htmlParser.getMapLines(),htmlParser.getLinesList());
        RootStationInfo rootStationInfo = new RootStationInfo(builderStationUlt.getStationUltList());

        DataCollector dataCollector = new DataCollector(metro, rootStationInfo);
        dataCollector.createMapMetroJsonFile("map.json");
        dataCollector.createStationInfoJsonFile("stationInfo.json");
    }
}



