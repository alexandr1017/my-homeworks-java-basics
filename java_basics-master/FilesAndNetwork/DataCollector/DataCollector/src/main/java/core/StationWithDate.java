package core;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;


@Getter
@ToString
public class StationWithDate {


    private String nameStation;
    private String date;


    private boolean isTake = false;

    public StationWithDate(String nameStation, String date) {
        this.nameStation = nameStation;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationWithDate that = (StationWithDate) o;
        return Objects.equals(nameStation, that.nameStation) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameStation, date);
    }


    public boolean getIsTake() {
        return isTake;
    }

    public void setTake(boolean take) {
        isTake = take;
    }
}
