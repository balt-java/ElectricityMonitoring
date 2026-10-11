package hu.electricity.monitoring;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        MeasurementService service = new MeasurementService();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {

            service.loadFromDatabase();

            System.out.println("A meresek betoltese sikerult!");

        } catch (SQLException e) {

            System.out.println("Hiba tortent az adatbazisbol valo betoltes soran!");
            e.printStackTrace();
        }

        for (Measurement measurement : service.getMeasurements()) {

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

        if (!service.getMeasurements().isEmpty()) {

            Measurement highest =
                    service.getHighestConsumption();

            System.out.println("Legnagyobb fogyasztas:");

            System.out.println(
                    highest.getConsumption()
                    + " kWh"
            );

            System.out.println(
                    highest.getTimestamp().format(formatter)
            );
        }
    }
}