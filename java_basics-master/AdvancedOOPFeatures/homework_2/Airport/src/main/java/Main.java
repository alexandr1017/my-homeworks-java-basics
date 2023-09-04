import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        Date date = new Date();
        Date datePlusTwoHours = new Date(date.getTime() + 7_200_000);
        return airport.getTerminals().stream()
                .flatMap(t -> t.getFlights().stream())
                .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                .filter(f -> f.getDate().after(date))
                .filter(f -> f.getDate().before(datePlusTwoHours))
                .collect(Collectors.toList());
    }
}
