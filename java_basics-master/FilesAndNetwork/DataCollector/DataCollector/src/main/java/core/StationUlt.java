package core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StationUlt {


    private String name;
    private String line;
    @JsonIgnore
    private String lineNumber;
    private String date;
    private String depth;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean hasConnection;
    @JsonIgnore
    private String stationNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationUlt that = (StationUlt) o;
        return hasConnection == that.hasConnection && Objects.equals(name, that.name) && Objects.equals(lineNumber, that.lineNumber) && Objects.equals(date, that.date) && Objects.equals(depth, that.depth) && Objects.equals(stationNumber, that.stationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lineNumber, hasConnection, date, depth, stationNumber);
    }
}
