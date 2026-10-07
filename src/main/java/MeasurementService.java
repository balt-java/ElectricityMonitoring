import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MeasurementService {

    private List<Measurement> measurements = new ArrayList<>();

    public void addMeasurement(Measurement measurement) {
        measurements.add(measurement);
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public Measurement getHighestConsumption() {

    	if (measurements.isEmpty()) {
    		return null;
    	}
        Measurement highest = measurements.get(0);

        for (Measurement measurement : measurements) {

            if (measurement.getConsumption() > highest.getConsumption()) {
                highest = measurement;
            }
        }

        return highest;
    }

    public void saveToFile() throws IOException {

        List<String> lines = new ArrayList<>();

        for (Measurement measurement : measurements) {

            String line = measurement.getConsumption()
                    + ";" + measurement.getTimestamp().toString().replace("T", " ");

            lines.add(line);
        }

        Files.write(Path.of("measurements.txt"), lines);
    }

    public void loadFromFile() throws IOException {

        Path path = Path.of("measurements.txt");

        if (!Files.exists(path)) {
            return;
        }

        List<String> lines = Files.readAllLines(path);

        for (String line : lines) {

            String[] parts = line.split(";", 2);

            double consumption = Double.parseDouble(parts[0]);
            LocalDateTime timestamp =
                    LocalDateTime.parse(parts[1].replace(" ", "T"));

            measurements.add(
                    new Measurement(consumption, timestamp)
            );
        }
    }

    public void loadFromDatabase() throws SQLException {

        DatabaseService databaseService = new DatabaseService();

        measurements.clear();

        measurements.addAll(
                databaseService.getAllMeasurements()
        );
    }

    public Measurement findByTimestamp(String timestamp) {

        for (Measurement measurement : measurements) {

            if (measurement.getTimestamp().toString().equals(timestamp)) {
                return measurement;
            }
        }

        return null;
    }

    public void printAllMeasurements() {

        for (Measurement measurement : measurements) {

            System.out.println(
                    "Fogyasztas: "
                    + measurement.getConsumption()
                    + " kWh"
            );

            System.out.println(
                    "Idopont: "
                    + measurement.getTimestamp()
            );

            System.out.println("---");
        }
    }
}