package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DvDurationTest {

    @Test
    public void testEquals() {
        DvDuration dvDurationOne = new DvDuration("P3Y6M4D");
        DvDuration dvDurationTwo = new DvDuration("P3Y6M4D");
        DvDuration dvDurationThree = new DvDuration("P3Y6M5D");
        DvDuration dvDurationFour = new DvDuration("P3Y6M");
        DvDuration dvDurationFive = new DvDuration("P3Y6M");
        assertAll(
                () -> assertEquals(dvDurationOne, dvDurationTwo),
                () -> assertNotEquals(dvDurationOne, dvDurationThree),
                () -> assertNotEquals(dvDurationOne, dvDurationFour),
                () -> assertEquals(dvDurationFour, dvDurationFive)
        );
    }

    @Test
    void getValue() {
    }

    @Test
    void getMagnitude() {
    }

    @Test
    void add() {
    }

    @Test
    void subtract() {
    }

    @Test
    void multiply() {
    }

    @Test
    void negative() {
    }

    @Test
    void lessThan() {
    }

    @Test
    void testEquals1() {
    }

    @Test
    void getYears() {
    }

    @Test
    void getMonths() {
    }

    @Test
    void getWeeks() {
    }

    @Test
    void getDays() {
    }

    @Test
    void getHours() {
    }

    @Test
    void getMinutes() {
    }

    @Test
    void getSeconds() {
    }

    @Test
    void getFractionalSeconds() {
    }
}