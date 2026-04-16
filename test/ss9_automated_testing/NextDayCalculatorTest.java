package ss9_automated_testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NextDayCalculatorTest {
    @Test
    void shouldReturnNextDay_whenNormalDay() {
        String result = NextDayCalculator.getNextDay(10, 2, 2023);
        assertEquals("11/2/2023", result);
    }
}