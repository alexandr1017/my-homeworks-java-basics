import core.StationUlt;
import core.StationWithDate;
import core.StationWithDepth;

import java.util.ArrayList;
import java.util.List;

public class BuilderStationUlt {
    private List<StationUlt> stationUltList = new ArrayList<>();
    private HtmlParser htmlParser;
    private JSONHandler jsonHandler;
    private CSVParser csvParser;

    public BuilderStationUlt(HtmlParser htmlParser, JSONHandler jsonHandler, CSVParser csvParser) {
        this.htmlParser = htmlParser;
        this.jsonHandler = jsonHandler;
        this.csvParser = csvParser;
    }


    public List<StationUlt> buildStationUltCollection() {
        beginBuilder();
        builder();
        optimize();
        return new ArrayList<>(getStationUltList());
    }


    private void beginBuilder() {
        for (int i = 0; i < htmlParser.getStationList().size(); i++) {
            String nameStation = htmlParser.getStationList().get(i).getNameStation();
            String lineNumber = htmlParser.getStationList().get(i).getLineNumber();
            boolean hasConnection = htmlParser.getStationList().get(i).isHasConnection();
            String date = null;
            String depth = null;
            String stationNumber = htmlParser.getStationList().get(i).getStationNumber();
            String lineName = null;
            for (int j = 0; j < htmlParser.getLinesList().size(); j++) {
                if (htmlParser.getStationList().get(i).getLineNumber().equals(htmlParser.getLinesList().get(j).getLine())) {
                    lineName = htmlParser.getLinesList().get(j).getName();
                }
            }
            stationUltList.add(new StationUlt(nameStation, lineName, lineNumber, date, depth, hasConnection, stationNumber));

        }
    }


    private void builder() {
        for (int i = 0; i < stationUltList.size(); i++) {
            StationUlt stationUlt = stationUltList.get(i);
            for (int j = 0; j < jsonHandler.getStationWithDepthList().size(); j++) {
                StationWithDepth stationWithDepth = jsonHandler.getStationWithDepthList().get(j);
                if (stationUlt.getName().equalsIgnoreCase(stationWithDepth.getNameStation()) && stationWithDepth.getDepth() != null && !stationWithDepth.getIsTake()) {
                    stationUlt.setDepth(stationWithDepth.getDepth());
                    jsonHandler.getStationWithDepthList().get(j).setTake(true);
                    break;
                }
            }
        }

        for (int i = 0; i < stationUltList.size(); i++) {
            StationUlt stationUlt = stationUltList.get(i);
            for (int k = 0; k < csvParser.getStationWithDatesList().size(); k++) {
                StationWithDate stationWithDate = csvParser.getStationWithDatesList().get(k);
                if (stationUlt.getName().equalsIgnoreCase(stationWithDate.getNameStation()) && stationWithDate.getDate() != null && !stationWithDate.getIsTake()) {
                    stationUlt.setDate(stationWithDate.getDate());
                    csvParser.getStationWithDatesList().get(k).setTake(true);
                    break;
                }
            }
        }
    }

    private void optimize() {
        for (StationUlt stationUlt : stationUltList) {
            if (stationUlt.getLineNumber().equals("14")) {
                stationUlt.setDepth("0");
                stationUlt.setDate("10.09.2016");
            }
            if (stationUlt.getLineNumber().equals("D2") || stationUlt.getLineNumber().equals("D1")) {
                stationUlt.setDepth(null);
                stationUlt.setDate(null);
            }
            if (stationUlt.getName().equals("Арбатская")) {
                if (stationUlt.getLineNumber().equals("3")) {
                    stationUlt.setDepth("-41");
                    stationUlt.setDate("05.04.1953");
                } else {
                    stationUlt.setDepth("-8");
                    stationUlt.setDate("15.05.1935");
                }
            }
            if (stationUlt.getName().equals("Смоленская")) {
                if (stationUlt.getLineNumber().equals("3")) {
                    stationUlt.setDepth("-50");
                    stationUlt.setDate("05.04.1953");
                } else {
                    stationUlt.setDepth("-8");
                    stationUlt.setDate("15.05.1935");
                }
            }
        }
    }


    public List<StationUlt> getStationUltList() {
        return stationUltList;
    }
}


