import com.fasterxml.jackson.databind.ObjectMapper;
import core.RootMetro;
import core.RootStationInfo;

import java.io.File;
import java.io.IOException;

public class DataCollector {
    private RootMetro metro;
    private RootStationInfo rootStationInfo;

    public DataCollector(RootMetro metro, RootStationInfo rootStationInfo) {
        this.metro = metro;
        this.rootStationInfo = rootStationInfo;
    }

    public void createMapMetroJsonFile(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(path), metro);
    }

    public void createStationInfoJsonFile(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(path), rootStationInfo);
    }

}
