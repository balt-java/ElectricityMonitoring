package hu.electricity.monitoring;

import java.time.LocalDateTime;

public class Measurement {

    private double consumption;
    private LocalDateTime timestamp;

    public Measurement(double consumption, LocalDateTime timestamp) {

        if (consumption < 0) {
            throw new IllegalArgumentException("A fogyasztas nem lehet negativ!");
        }

        if (timestamp == null) {
            throw new IllegalArgumentException("Az idopont nem lehet null!");
        }

        this.consumption = consumption;
        this.timestamp = timestamp;
    }

    public double getConsumption() {
        return consumption;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}