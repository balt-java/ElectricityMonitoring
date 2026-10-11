package hu.electricity.monitoring;
import java.util.List;
import java.time.format.DateTimeFormatter;
public class DatabaseTest {

    public static void main(String[] args) {

        DatabaseService databaseService = new DatabaseService();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        try {
            List<Measurement> measurements =
                    databaseService.getAllMeasurements();

            System.out.println("Sikeres adatlekeres!");

            for (Measurement measurement : measurements) {

                System.out.println(
                        "Fogyasztas: "
                        + measurement.getConsumption()
                        + " kWh"
                );

                System.out.println(
                        "Idopont: "
                        + measurement.getTimestamp().format(formatter)
                );

                System.out.println("---");
            }

        } catch (Exception e) {
            System.out.println("Hiba tortent az adatlekeres soran!");
            e.printStackTrace();
        }
    }
}