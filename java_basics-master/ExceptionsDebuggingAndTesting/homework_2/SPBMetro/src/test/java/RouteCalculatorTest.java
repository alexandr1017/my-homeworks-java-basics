import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.*;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    Line line1;
    Line line2;
    Line line3;


    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();

        line1 = new Line(1, "Зеленая");
        line2 = new Line(2, "Салатовая");
        line3 = new Line(3, "Фиолетовая");

        route.add(new Station("Алма-атинская",line1));
        route.add(new Station("Красногвардейская",line1));
        route.add(new Station("Зябликово",line2));
        route.add(new Station("Шипиловская",line2));
        route.add(new Station("Борисово",line2));
        route.add(new Station("Ананасовая",line3));
        route.add(new Station("Некрасовка",line3));




        line1.addStation(new Station("Алма-атинская", line1));
        line1.addStation(new Station("Красногвардейская", line1));
        line1.addStation(new Station("Домодедовская", line1));
        line1.addStation(new Station("Орехово", line1));
        line1.addStation(new Station("Царицыно", line1));
        line1.addStation(new Station("Кантемировская", line1));

        line2.addStation(new Station("Зябликово", line2));
        line2.addStation(new Station("Шипиловская", line2));
        line2.addStation(new Station("Борисово", line2));
        line2.addStation(new Station("Марьино", line2));

        line3.addStation(new Station("Некрасовка",line3));
        line3.addStation(new Station("Ананасовая",line3));


        stationIndex = new StationIndex();

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        ArrayList<Station> connect1 = new ArrayList<>(List.of(
                new Station("Красногвардейская", line1),
                new Station("Зябликово", line2))
        );
        ArrayList<Station> connect2 = new ArrayList<>(List.of(
                new Station("Кантемировская", line1),
                new Station("Марьино", line2))
        );
        ArrayList<Station> connect3 = new ArrayList<>(List.of(
                new Station("Борисово", line2),
                new Station("Ананасовая", line3))
        );

        stationIndex.addConnection(connect1);
        stationIndex.addConnection(connect2);
        stationIndex.addConnection(connect3);

        routeCalculator = new RouteCalculator(stationIndex);


    }

    public void testGetRouteOnTheLineWithTwoConnections () {
        List<Station> expected = route;
        List<Station> actual  = routeCalculator.getShortestRoute(new Station("Алма-атинская", line1),new Station("Некрасовка",line3));
        assertEquals(expected, actual);
    }
    public void testGetRouteOnTheLineWithOneConnections () {
        List<Station> expected = new ArrayList<>(List.of(
                new Station("Алма-атинская",line1),
                new Station("Красногвардейская",line1),
                new Station("Зябликово",line2),
                new Station("Шипиловская",line2),
                new Station("Борисово",line2)
        ));
        List<Station> actual = routeCalculator.getShortestRoute(new Station("Алма-атинская", line1),new Station("Борисово",line2));
        assertEquals(expected, actual);
    }


    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 17;
        assertEquals(expected, actual);
    }
}
