package core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class RootStationInfo {
    private List<StationUlt> stations;

    public RootStationInfo(List<StationUlt> lines) {
        this.stations = lines;
    }
}
