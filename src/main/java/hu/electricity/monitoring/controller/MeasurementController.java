
package hu.electricity.monitoring.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.electricity.monitoring.Measurement;
import hu.electricity.monitoring.MeasurementService;

@RestController
public class MeasurementController {
private final MeasurementService measurementService;

public MeasurementController(MeasurementService measurementService) {
	 this.measurementService = measurementService;
}
	
    @GetMapping("/api/test")
    public String test() {
        return "Electricity Monitoring API is running!";
    }

    @GetMapping("/api/measurements")
    public List<Measurement> getAllMeasurements() throws SQLException {

        measurementService.loadFromDatabase();

        return measurementService.getMeasurements();
        }
    @GetMapping("/api/measurements/highest")
    public Measurement getHighestConsumption() throws SQLException {

        measurementService.loadFromDatabase();

        return measurementService.getHighestConsumption();
    }
    @PostMapping("api/measurements")
    public Measurement addMeasurement(@RequestBody Measurement measurement) {
    	measurementService.addMeasurement(measurement);
    	return measurement;
    }
}