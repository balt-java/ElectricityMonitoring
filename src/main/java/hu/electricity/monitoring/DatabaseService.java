package hu.electricity.monitoring;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

    private final String url =
            "jdbc:postgresql://localhost:5432/electricity_monitoring";

    private final String user = "postgres";

    private final String password =
    		System.getenv("DB_PASSWORD");
    
    public Connection getConnection() throws SQLException {
    	       
        return DriverManager.getConnection(
                url,
                user,
                password
        );
    }

    public List<Measurement> getAllMeasurements() throws SQLException {

        List<Measurement> measurements = new ArrayList<>();

        String sql = "SELECT consumption, timestamp FROM measurements";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                double consumption =
                        resultSet.getDouble("consumption");

                LocalDateTime timestamp =
                        resultSet.getTimestamp("timestamp")
                                .toLocalDateTime();

                Measurement measurement =
                        new Measurement(consumption, timestamp);

                measurements.add(measurement);
            }
        }

        return measurements;
    }
}