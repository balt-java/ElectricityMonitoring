# Electricity Monitoring

A Java-based electricity monitoring application developed as a portfolio project.

The application manages electricity consumption measurements and demonstrates database connectivity, data loading, file handling, and basic data processing.

## Technologies

* Java 21
* PostgreSQL
* JDBC
* Maven
* Git
* GitHub

## Features

* Store electricity consumption measurements
* Validate measurement data
* Load measurements from PostgreSQL
* Find the measurement with the highest consumption
* Search measurements by timestamp
* Save measurements to a text file
* Load measurements from a text file
* Display measurement data in the console

## Project Structure

* `Measurement` – represents an electricity consumption measurement
* `MeasurementService` – contains the main application logic
* `DatabaseService` – handles PostgreSQL database access
* `DatabaseTest` – database connectivity and data retrieval test
* `Main` – application entry point

## Database

The application uses PostgreSQL and connects to the `electricity_monitoring` database.

Database credentials are not stored in the source code. The PostgreSQL password is provided through the `DB_PASSWORD` environment variable.

## Maven

The project uses Maven for dependency management and build configuration.

The PostgreSQL JDBC driver is managed through `pom.xml`.

## Current Status

The application can load electricity consumption measurements from PostgreSQL and display them in the console.

This project is being developed as a portfolio project with the goal of gradually expanding it into a REST-based backend application.

## Planned Improvements

* Spring Boot REST API
* JPA / Hibernate
* REST endpoints for measurements
* Improved exception handling
* Unit tests with JUnit
* PostgreSQL integration improvements
* Docker support
* API documentation
* Improved project architecture

## Author

Portfolio project created to demonstrate Java backend development skills and continuous learning.
