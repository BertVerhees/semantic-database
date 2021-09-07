package nl.rosa.semanticdatabase.utils.datetime;

import nl.rosa.semanticdatabase.utils.datetime.threeten.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

import static java.time.temporal.ChronoUnit.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class.
 */

/**
 * Default created on 30-12-2020
 */

class CombinedPeriodDurationTest {

    private static final Period P1Y2M3D = Period.of(1, 2, 3);
    private static final Duration DUR_5 = Duration.ofSeconds(5);
    private static final Duration DUR_6 = Duration.ofSeconds(6);

    //-----------------------------------------------------------------------
    @Test
    public void test_isSerializable() {
        assertTrue(Serializable.class.isAssignableFrom(CombinedPeriodDuration.class));
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_serialization() throws Exception {
        CombinedPeriodDuration test = CombinedPeriodDuration.of(P1Y2M3D, DUR_5);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(test);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
            assertEquals(test, ois.readObject());
        }
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_ZERO() {
        assertEquals(CombinedPeriodDuration.ZERO, CombinedPeriodDuration.of(Period.ZERO, Duration.ZERO));
        assertEquals(CombinedPeriodDuration.ZERO, CombinedPeriodDuration.of(Period.ZERO));
        assertEquals(CombinedPeriodDuration.ZERO, CombinedPeriodDuration.of(Duration.ZERO));
        assertEquals(Period.ZERO, CombinedPeriodDuration.ZERO.getPeriod());
        assertEquals(Duration.ZERO, CombinedPeriodDuration.ZERO.getDuration());
        assertEquals(true, CombinedPeriodDuration.ZERO.isZero());
        assertEquals(Arrays.asList(YEARS, MONTHS, DAYS, SECONDS, NANOS), CombinedPeriodDuration.ZERO.getUnits());
        assertEquals(0, CombinedPeriodDuration.ZERO.get(YEARS));
        assertEquals(0, CombinedPeriodDuration.ZERO.get(MONTHS));
        assertEquals(0, CombinedPeriodDuration.ZERO.get(DAYS));
        assertEquals(0, CombinedPeriodDuration.ZERO.get(SECONDS));
        assertEquals(0, CombinedPeriodDuration.ZERO.get(NANOS));
    }

    public void test_ZERO_getEra() {
        Assertions.assertThrows(DateTimeException.class, () -> {
            CombinedPeriodDuration.ZERO.get(ERAS);
        });
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_of_both() {
        CombinedPeriodDuration test = CombinedPeriodDuration.of(P1Y2M3D, Duration.ofSeconds(4));
        assertEquals(P1Y2M3D, test.getPeriod());
        assertEquals(Duration.ofSeconds(4), test.getDuration());
        assertEquals(false, test.isZero());
        assertEquals(1, test.get(YEARS));
        assertEquals(2, test.get(MONTHS));
        assertEquals(3, test.get(DAYS));
        assertEquals(4, test.get(SECONDS));
        assertEquals(0, test.get(NANOS));
    }

    @Test
    public void test_of_period() {
        CombinedPeriodDuration test = CombinedPeriodDuration.of(P1Y2M3D);
        assertEquals(P1Y2M3D, test.getPeriod());
        assertEquals(Duration.ZERO, test.getDuration());
        assertEquals(false, test.isZero());
        assertEquals(1, test.get(YEARS));
        assertEquals(2, test.get(MONTHS));
        assertEquals(3, test.get(DAYS));
        assertEquals(0, test.get(SECONDS));
        assertEquals(0, test.get(NANOS));
    }

    @Test
    public void test_of_duration() {
        CombinedPeriodDuration test = CombinedPeriodDuration.of(Duration.ofSeconds(4));
        assertEquals(Period.ZERO, test.getPeriod());
        assertEquals(Duration.ofSeconds(4), test.getDuration());
        assertEquals(false, test.isZero());
        assertEquals(0, test.get(YEARS));
        assertEquals(0, test.get(MONTHS));
        assertEquals(0, test.get(DAYS));
        assertEquals(4, test.get(SECONDS));
        assertEquals(0, test.get(NANOS));
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_between_dates() {
        CombinedPeriodDuration test = CombinedPeriodDuration.between(LocalDate.of(2012, 6, 20), LocalDate.of(2012, 8, 25));
        assertEquals(Period.between(LocalDate.of(2012, 6, 20), LocalDate.of(2012, 8, 25)), test.getPeriod());
        assertEquals(Duration.ZERO, test.getDuration());
    }

    @Test
    public void test_between_times() {
        CombinedPeriodDuration test = CombinedPeriodDuration.between(
                LocalTime.of(11, 20),
                LocalTime.of(12, 25));
        assertEquals(Period.ZERO, test.getPeriod());
        assertEquals(Duration.between(
                LocalTime.of(11, 20),
                LocalTime.of(12, 25)), test.getDuration());
    }

    @Test
    public void test_between_mixed1() {
        CombinedPeriodDuration test = CombinedPeriodDuration.between(
                LocalDate.of(2012, 6, 20),
                LocalTime.of(11, 25));
        assertEquals(Period.ZERO, test.getPeriod());
        assertEquals(Duration.ofHours(11).plusMinutes(25), test.getDuration());
    }

    @Test
    public void test_between_mixed2() {
        CombinedPeriodDuration test = CombinedPeriodDuration.between(LocalDate.of(2012, 6, 20), LocalDateTime.of(2012, 7, 22, 11, 25));
        assertEquals(Period.of(0, 1, 2), test.getPeriod());
        assertEquals(Duration.ofHours(11).plusMinutes(25), test.getDuration());
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_from() {
        assertEquals(CombinedPeriodDuration.from(CombinedPeriodDuration.of(P1Y2M3D)), CombinedPeriodDuration.from(CombinedPeriodDuration.of(P1Y2M3D)));
        assertEquals(CombinedPeriodDuration.of(Period.ofYears(2)), CombinedPeriodDuration.from(Period.ofYears(2)));
        assertEquals(CombinedPeriodDuration.of(Duration.ofSeconds(2)), CombinedPeriodDuration.from(Duration.ofSeconds(2)));
        assertEquals(CombinedPeriodDuration.of(Period.ofYears(2)), CombinedPeriodDuration.from(Years.of(2)));
        assertEquals(CombinedPeriodDuration.of(Period.ofMonths(2)), CombinedPeriodDuration.from(Months.of(2)));
        assertEquals(CombinedPeriodDuration.of(Period.ofWeeks(2)), CombinedPeriodDuration.from(Weeks.of(2)));
        assertEquals(CombinedPeriodDuration.of(Period.ofDays(2)), CombinedPeriodDuration.from(Days.of(2)));
        assertEquals(CombinedPeriodDuration.of(Duration.ofHours(2)), CombinedPeriodDuration.from(Hours.of(2)));
    }

    //-----------------------------------------------------------------------
    private class DataValid{
        String str;
        Period period;
        Duration duration;

        public DataValid(String str, Period period, Duration duration) {
            this.str = str;
            this.period = period;
            this.duration = duration;
        }
    }
    private DataValid[] dataValid = {
                new DataValid("P1Y2M3W4DT5H6M7S", Period.of(1, 2, 3 * 7 + 4), Duration.ofHours(5).plusMinutes(6).plusSeconds(7)),
                new DataValid("P3Y", Period.ofYears(3), Duration.ZERO),
                new DataValid("P3M", Period.ofMonths(3), Duration.ZERO),
                new DataValid("P3W", Period.ofWeeks(3), Duration.ZERO),
                new DataValid("P3D", Period.ofDays(3), Duration.ZERO),

                new DataValid("PT0S", Period.of(0, 0, 0), Duration.ofSeconds(0)),
                new DataValid("PT1S", Period.of(0, 0, 0), Duration.ofSeconds(1)),
                new DataValid("PT2S", Period.of(0, 0, 0), Duration.ofSeconds(2)),
                new DataValid("PT123456789S", Period.of(0, 0, 0), Duration.ofSeconds(123456789)),
                new DataValid("PT+0S", Period.of(0, 0, 0), Duration.ofSeconds(0)),
                new DataValid("PT+2S", Period.of(0, 0, 0), Duration.ofSeconds(2)),
                new DataValid("PT-0S", Period.of(0, 0, 0), Duration.ofSeconds(0)),
                new DataValid("PT-2S", Period.of(0, 0, 0), Duration.ofSeconds(-2)),

                new DataValid("P+0M", Period.of(0, 0, 0), Duration.ZERO),
                new DataValid("P+2M", Period.of(0, 2, 0), Duration.ZERO),
                new DataValid("P-0M", Period.of(0, 0, 0), Duration.ZERO),
                new DataValid("P-2M", Period.of(0, -2, 0), Duration.ZERO)
        };

    @Test
    public void test_parse_CharSequence_valid() {
        Arrays.stream(dataValid).forEach((dV) ->
                assertEquals(CombinedPeriodDuration.of(dV.period, dV.duration), CombinedPeriodDuration.parse(dV.str))
        );
    }
    
    @Test
    public void test_parse_CharSequence_valid_initialPlus() {
        Arrays.stream(dataValid).forEach((dV) ->
            assertEquals(CombinedPeriodDuration.of(dV.period, dV.duration), CombinedPeriodDuration.parse("+" + dV.str))
        );
    }

    @Test
   public void test_parse_CharSequence_valid_initialMinus() {
        Arrays.stream(dataValid).forEach((dV) ->
            assertEquals(CombinedPeriodDuration.of(dV.period, dV.duration).negated(), CombinedPeriodDuration.parse("-" + dV.str))
        );
    }

    @Test
    public void test_parse_CharSequence_invalid() {
        final String[] testData = {
                "P3Q",
                "P1M2Y",
                "3",
                "-3",
                "3H",
                "-3H",
                "P3",
                "P-3",
                "PH",
                "T",
                "T3H"
        };
        Arrays.stream(testData).forEach(str ->
            Assertions.assertThrows(DateTimeParseException.class,
                     () -> CombinedPeriodDuration.parse(str)
            )
        );
    }

    @Test
    public void test_parse_CharSequence_null() {
        Assertions.assertThrows(NullPointerException.class,
                () -> CombinedPeriodDuration.parse((CharSequence) null)
        );
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_plus_TemporalAmount_PeriodDuration() {
        CombinedPeriodDuration test = CombinedPeriodDuration.of(P1Y2M3D, DUR_5);
        assertEquals(CombinedPeriodDuration.of(
                Period.of(4, 4, 4), DUR_5),
                test.plus(Period.of(3, 2, 1)));
        assertEquals(CombinedPeriodDuration.of(
                P1Y2M3D, Duration.ofSeconds(9)),
                test.plus(Duration.ofSeconds(4)));
    }

    @Test
    public void test_plus_TemporalAmount_overflowTooBig() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> CombinedPeriodDuration.of(
                        Period.of(Integer.MAX_VALUE - 1, 0, 0))
                        .plus(CombinedPeriodDuration.of(Period.ofYears(2)))
        );
    }

    @Test
    public void test_plus_TemporalAmount_overflowTooSmall() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> CombinedPeriodDuration.of(
                        Period.of(Integer.MIN_VALUE + 1, 0, 0))
                        .plus(CombinedPeriodDuration.of(Period.ofYears(-2)))
        );
    }

    @Test
    public void test_plus_TemporalAmount_null() {
        Assertions.assertThrows(NullPointerException.class,
                () -> P1Y2M3D.plus(null)
        );
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_minus_TemporalAmount_PeriodDuration() {
        //1Y 2M 3D T 5 sec - 1Y 1M 1D = 0Y 1M 2D T 5sec
        CombinedPeriodDuration test = CombinedPeriodDuration.of(P1Y2M3D, DUR_5);
        assertEquals(CombinedPeriodDuration.of(
                Period.of(0, 1, 2), DUR_5),
                test.minus(Period.of(1, 1, 1)));
        //1Y 2M 3D T 5 sec - 1Y 2M 3D T 1sec = 4sec
        assertEquals(CombinedPeriodDuration.of(
                P1Y2M3D, Duration.ofSeconds(1)),
                test.minus(Duration.ofSeconds(4)));
    }

    @Test
    public void test_minus_TemporalAmount_overflowTooBig() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> CombinedPeriodDuration.of(
                        Period.of(Integer.MAX_VALUE - 1, 0, 0))
                        .minus(CombinedPeriodDuration.of(Period.ofYears(-2)))
        );
    }

    @Test
    public void test_minus_TemporalAmount_overflowTooSmall() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> CombinedPeriodDuration.of(
                        Period.of(Integer.MIN_VALUE + 1, 0, 0))
                        .minus(CombinedPeriodDuration.of(Period.ofYears(2)))
        );
    }

    @Test
    public void test_minus_TemporalAmount_null() {
        Assertions.assertThrows(NullPointerException.class,
                () -> P1Y2M3D.minus(null)
        );
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_multipliedBy() {
        CombinedPeriodDuration test = CombinedPeriodDuration.of(P1Y2M3D, DUR_5);
        assertEquals(CombinedPeriodDuration.ZERO, test.multipliedBy(0));
        assertEquals(test, test.multipliedBy(1));
        assertEquals(CombinedPeriodDuration.of(
                Period.of(5,  10, 15), Duration.ofSeconds(25)),
                test.multipliedBy(5));
        assertEquals(CombinedPeriodDuration.of(
                Period.of(-3,  -6, -9), Duration.ofSeconds(-15)),
                test.multipliedBy(-3));
    }

    @Test
    public void test_multipliedBy_overflowTooBig() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> CombinedPeriodDuration.of(
                        Period.ofYears(Integer.MAX_VALUE / 2 + 1))
                        .multipliedBy(2)
        );
    }

    @Test
    public void test_multipliedBy_overflowTooSmall() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> CombinedPeriodDuration.of(
                        Period.ofYears(Integer.MIN_VALUE / 2 - 1))
                        .multipliedBy(2)
        );
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_negated() {
        assertEquals(CombinedPeriodDuration.of(
                P1Y2M3D.negated(), DUR_5.negated()),
                CombinedPeriodDuration.of(P1Y2M3D, DUR_5).negated());
    }

    @Test
    public void test_negated_overflow() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> CombinedPeriodDuration.of(
                        Duration.ofSeconds(Long.MIN_VALUE)).negated()
        );
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_normalizedYears() {
        assertEquals(CombinedPeriodDuration.of
                        (P1Y2M3D.normalized(), DUR_5),
                CombinedPeriodDuration.of(P1Y2M3D, DUR_5).normalizedYears());
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_normalizedStandardDays() {
        assertEquals(
                CombinedPeriodDuration.of(P1Y2M3D, Duration.ofHours(5)),
                CombinedPeriodDuration.of(P1Y2M3D, Duration.ofHours(5)).normalizedStandardDays());
        assertEquals(
                CombinedPeriodDuration.of(P1Y2M3D.plusDays(1), Duration.ofHours(1)),
                CombinedPeriodDuration.of(P1Y2M3D, Duration.ofHours(25)).normalizedStandardDays());
        assertEquals(
                CombinedPeriodDuration.of(P1Y2M3D.plusDays(-3), Duration.ofHours(-1)),
                CombinedPeriodDuration.of(P1Y2M3D, Duration.ofHours(-73)).normalizedStandardDays());
    }

    @Test
    public void test_normalizedStandardDaysn_overflow() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> CombinedPeriodDuration.of(Duration.ofSeconds(Long.MIN_VALUE)).normalizedStandardDays()
        );
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_addTo() {
        //2012-06-20T11:30:00 + 1Y-2M-3D T 5S = 2011-08-23:11:30:05
        LocalDateTime base = LocalDateTime.of(2012, 6, 20, 11, 30, 0);
        assertEquals(
                LocalDateTime.of(2013, 8, 23, 11, 30, 5),
                CombinedPeriodDuration.of(P1Y2M3D, DUR_5).addTo(base));
        //2012-06-20T11:30:00 - 1Y-2M-3D T 1D5S = 2011-04-16:11:29:55
        assertEquals(
                LocalDateTime.of(2013, 8, 24, 11, 30, 5),
                CombinedPeriodDuration.of(P1Y2M3D, Duration.ofSeconds(86405L)).addTo(base));
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_subtractFrom() {
        //2012-06-20T11:30:00 - 1Y-2M-3D T 5S = 2011-04-17:11:29:55
        LocalDateTime base = LocalDateTime.of(2012, 6, 20, 11, 30, 0);
        assertEquals(
                LocalDateTime.of(2011, 4, 17, 11, 29, 55),
                CombinedPeriodDuration.of(P1Y2M3D, DUR_5).subtractFrom(base));
        //2012-06-20T11:30:00 - 1Y-2M-3D T 1D5S = 2011-04-16:11:29:55
        assertEquals(
                LocalDateTime.of(2011, 4, 16, 11, 29, 55),
                CombinedPeriodDuration.of(P1Y2M3D, Duration.ofSeconds(86405L)).subtractFrom(base));
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_equals() {
        CombinedPeriodDuration test5 = CombinedPeriodDuration.of(P1Y2M3D, DUR_5);
        CombinedPeriodDuration test6 = CombinedPeriodDuration.of(P1Y2M3D, DUR_6);
        assertEquals(true, test5.equals(test5));
        assertEquals(false, test5.equals(test6));
        assertEquals(false, test6.equals(test5));
    }

    @Test
    public void test_equals_null() {
        CombinedPeriodDuration test = CombinedPeriodDuration.of(P1Y2M3D, DUR_5);
        assertEquals(false, test.equals(null));
    }

    @Test
    public void test_equals_otherClass() {
        CombinedPeriodDuration test = CombinedPeriodDuration.of(P1Y2M3D, DUR_5);
        assertEquals(false, test.equals(""));
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_hashCode() {
        CombinedPeriodDuration test5 = CombinedPeriodDuration.of(P1Y2M3D, DUR_5);
        CombinedPeriodDuration test6 = CombinedPeriodDuration.of(P1Y2M3D, DUR_6);
        assertEquals(true, test5.hashCode() == test5.hashCode());
        assertEquals(false, test5.hashCode() == test6.hashCode());
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_toString() {
        assertEquals("P1Y2M3DT5S", CombinedPeriodDuration.of(P1Y2M3D, DUR_5).toString());
        assertEquals("P1Y2M3D", CombinedPeriodDuration.of(P1Y2M3D, Duration.ZERO).toString());
        assertEquals("PT5S", CombinedPeriodDuration.of(Period.ZERO, DUR_5).toString());
    }

    @Test
    void normalizedYears() {
    }

    @Test
    void normalizedStandardDays() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void compareTo() {
        CombinedPeriodDuration c1 = CombinedPeriodDuration.of(
                Period.of(1, 2, 3), Duration.ofSeconds(5));
        CombinedPeriodDuration c2 = CombinedPeriodDuration.of(
                Period.of(1, 2, 3), Duration.ofSeconds(6));
        assertEquals(-1,c1.compareTo(c2));
        c2 = CombinedPeriodDuration.of(
                Period.of(1, 2, 3), Duration.ofSeconds(7));
        assertEquals(-1,c1.compareTo(c2));
        c2 = CombinedPeriodDuration.of(
                Period.of(1, 2, 3), Duration.ofSeconds(4));
        assertEquals(1,c1.compareTo(c2));
        c2 = CombinedPeriodDuration.of(
                Period.of(1, 2, 3), Duration.ofSeconds(3));
        assertEquals(1,c1.compareTo(c2));
        c2 = CombinedPeriodDuration.of(
                Period.of(1, 2, 3), Duration.ofSeconds(5));
        assertEquals(0,c1.compareTo(c2));
        c2 = CombinedPeriodDuration.of(
                Period.of(1, 1, 3), Duration.ofSeconds(5));
        assertEquals(1,c1.compareTo(c2));
        c2 = CombinedPeriodDuration.of(
                Period.of(1, 1, 33), Duration.ofSeconds(5));
        assertEquals(0,c1.compareTo(c2));
    }
}