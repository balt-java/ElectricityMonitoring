import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class MeasurementServiceTest {

    @Test
    void shouldFindHighestConsumption() {

        MeasurementService service = new MeasurementService();

        service.addMeasurement(
                new Measurement(
                        10.5,
                        LocalDateTime.of(2026, 9, 28, 15, 30)
                )
        );

        service.addMeasurement(
                new Measurement(
                        25.7,
                        LocalDateTime.of(2026, 9, 28, 16, 0)
                )
        );

        service.addMeasurement(
                new Measurement(
                        18.2,
                        LocalDateTime.of(2026, 9, 28, 16, 30)
                )
        );

        Measurement highest =
                service.getHighestConsumption();

        assertEquals(25.7, highest.getConsumption());
    }
    @Test    
    void shouldReturnNullWhenThereAreNoMeasurements() {
        	MeasurementService service = new MeasurementService();
        	
        	Measurement highest = service.getHighestConsumption();
        assertEquals (null, highest);
        }
    @Test
    void shouldFindMeasurementByTimestamp() {

        MeasurementService service = new MeasurementService();

        LocalDateTime timestamp =
                LocalDateTime.of(2026, 9, 28, 16, 0);

        Measurement measurement =
                new Measurement(25.7, timestamp);

        service.addMeasurement(measurement);

        Measurement result =
                service.findByTimestamp("2026-09-28T16:00");

        assertEquals(25.7, result.getConsumption());
    }
    @Test
    void shouldReturnNullWhenTimestampIsNotFound() {

        MeasurementService service = new MeasurementService();

        service.addMeasurement(
                new Measurement(
                        25.7,
                        LocalDateTime.of(2026, 9, 28, 16, 0)
                )
        );

        Measurement result =
                service.findByTimestamp("2026-09-28T17:00");

        assertEquals(null, result);
    }
        }

