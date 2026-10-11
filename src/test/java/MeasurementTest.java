import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import hu.electricity.monitoring.Measurement;

public class MeasurementTest {

    @Test
    void shouldCreateMeasurementWithValidData() {

        LocalDateTime timestamp =
                LocalDateTime.of(2026, 9, 28, 15, 30);

        Measurement measurement =
                new Measurement(12.5, timestamp);

        assertEquals(12.5, measurement.getConsumption());
        assertEquals(timestamp, measurement.getTimestamp());
    }

    @Test
    void shouldRejectNegativeConsumption() {

        LocalDateTime timestamp =
                LocalDateTime.of(2026, 9, 28, 15, 30);

        assertThrows(
                IllegalArgumentException.class,
                () -> new Measurement(-5.0, timestamp)
        );
    }

    @Test
    void shouldRejectNullTimestamp() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Measurement(12.5, null)
        );
    }
}