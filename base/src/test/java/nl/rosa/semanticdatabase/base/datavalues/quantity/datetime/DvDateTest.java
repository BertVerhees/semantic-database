package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;




import nl.rosa.semanticdatabase.base.datavalues.quantity.DvQuantity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DvDateTest {

    @Test
    public void testEquals() {

        DvDate dvDateOne = new DvDate("2019-07-11");
        DvDate dvDateTwo = new DvDate("2019-07-11");
        DvDate dvDateThree = new DvDate("2019-07-12");
        DvDate dvDateFour = new DvDate("2019-07");
        DvDate dvDateFive = new DvDate("2019-07");
        DvDate dvDateSix = new DvDate("2019");
        DvDate dvDateSeven = new DvDate("2019");
        assertAll(
                () -> assertEquals(dvDateOne, dvDateTwo),
                () -> assertNotEquals(dvDateOne, dvDateThree),
                () -> assertNotEquals(dvDateOne, dvDateFour),
                () -> assertNotEquals(dvDateOne, dvDateFive),
                () -> assertEquals(dvDateFour, dvDateFive),
                () -> assertEquals(dvDateSix, dvDateSeven)
        );
    }

    @Test
    void add() {
        DvDate one = new DvDate("2019-07-11");
        DvDuration two = new DvDuration("P3Y6M4D");
        assertEquals(one.getMagnitude()+two.getMagnitude(), one.add(two).getMagnitude());
        assertEquals(two.getMagnitude()+one.getMagnitude(), two.add(one).getMagnitude());
    }

    @Test
    void subtract() {
    }

    @Test
    void diff() {
    }

    @Test
    void lessThan() {
    }

    @Test
    void getMagnitude() {
    }

    @Test
    void setMagnitude() {
    }

    @Test
    void isStrictlyComparableTo() {
    }

    @Test
    void testLessThan() {
    }

    @Test
    void testEquals1() {
    }

    @Test
    void compareTo() {
    }
}