import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRoutecCalculator extends TestCase {
    List<Station> route;
    Station a;
    Station b;
    RouteCalculator calc;

    @BeforeClass
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");

        route.add(new Station("Гагаринская", line1));
        route.add(new Station("Петровская", line1));
        route.add(new Station("Кировкская", line2));
        route.add(new Station("Юность", line2));
        route.add(new Station("Революция", line3));

    }

    @Test
    public void CalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expert = 12.0;
        assertEquals(expert, actual);
    }

    @Test
    public void getRouteWithTwoConnections(){


    }


    @Override
    protected void tearDown() throws Exception {

    }
}
