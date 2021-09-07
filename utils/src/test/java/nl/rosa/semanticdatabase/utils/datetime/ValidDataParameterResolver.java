package nl.rosa.semanticdatabase.utils.datetime;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.time.Duration;
import java.time.Period;

/**
 * Default created on 31-12-2020
 */

public class ValidDataParameterResolver  implements ParameterResolver {

    public static Object[][] ValidData = {
        {"P1Y2M3W4DT5H6M7S", Period.of(1, 2, 3 * 7 + 4), Duration.ofHours(5).plusMinutes(6).plusSeconds(7)},
        {"P3Y", Period.ofYears(3), Duration.ZERO},
        {"P3M", Period.ofMonths(3), Duration.ZERO},
        {"P3W", Period.ofWeeks(3), Duration.ZERO},
        {"P3D", Period.ofDays(3), Duration.ZERO},

        {"PT0S", Period.of(0, 0, 0), Duration.ofSeconds(0)},
        {"PT1S", Period.of(0, 0, 0), Duration.ofSeconds(1)},
        {"PT2S", Period.of(0, 0, 0), Duration.ofSeconds(2)},
        {"PT123456789S", Period.of(0, 0, 0), Duration.ofSeconds(123456789)},
        {"PT+0S", Period.of(0, 0, 0), Duration.ofSeconds(0)},
        {"PT+2S", Period.of(0, 0, 0), Duration.ofSeconds(2)},
        {"PT-0S", Period.of(0, 0, 0), Duration.ofSeconds(0)},
        {"PT-2S", Period.of(0, 0, 0), Duration.ofSeconds(-2)},

        {"P+0M", Period.of(0, 0, 0), Duration.ZERO},
        {"P+2M", Period.of(0, 2, 0), Duration.ZERO},
        {"P-0M", Period.of(0, 0, 0), Duration.ZERO},
        {"P-2M", Period.of(0, -2, 0), Duration.ZERO}
    };
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return false;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return null;
    }
}
