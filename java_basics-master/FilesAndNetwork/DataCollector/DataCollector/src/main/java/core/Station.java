package core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Station {
    private String nameStation;
    private String lineNumber;
    private boolean hasConnection;
    private String stationNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return hasConnection == station.hasConnection && Objects.equals(nameStation, station.nameStation) && Objects.equals(lineNumber, station.lineNumber) && Objects.equals(stationNumber, station.stationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameStation, lineNumber, hasConnection, stationNumber);
    }
}
