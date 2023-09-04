package core;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

import lombok.ToString;

import java.util.Objects;


@Getter
@ToString
public class StationWithDepth {


    @JsonProperty("station_name")
    private String nameStation;
    private String depth;

    public boolean isTake = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationWithDepth that = (StationWithDepth) o;
        return Objects.equals(nameStation, that.nameStation) && Objects.equals(depth, that.depth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameStation, depth);
    }

    public void setNameStation(String nameStation) {
        this.nameStation = nameStation;
    }

    public boolean getIsTake() {
        return isTake;
    }

    public void setTake(boolean take) {
        isTake = take;
    }
}
