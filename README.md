# Electricity Monitoring

## Overview

Electricity Monitoring is a Java Spring Boot REST API application for storing, retrieving, and analyzing electricity consumption measurements.

The application uses PostgreSQL to store measurement data and provides HTTP endpoints to retrieve measurements, add new measurements, and identify the highest consumption value. It also demonstrates data validation, file handling, database connectivity, and automated testing.

## Technologies

* Java 21
* Spring Boot 3.5.6
* Maven
* PostgreSQL
* JDBC
* REST API
* JUnit 5
* Git and GitHub

## Features

* Retrieve all electricity consumption measurements
* Add new measurements through a REST API
* Retrieve the measurement with the highest consumption
* Store measurements in a PostgreSQL database
* Load measurement data from PostgreSQL
* Validate measurement values and timestamps
* Search measurements by timestamp
* Save and load measurement data using text files
* Run automated tests

## API Endpoints

| Method | Endpoint                    | Description                                           |
| ------ | --------------------------- | ----------------------------------------------------- |
| GET    | `/api/test`                 | Check whether the API is running                      |
| GET    | `/api/measurements`         | Retrieve all measurements                             |
| GET    | `/api/measurements/highest` | Retrieve the measurement with the highest consumption |
| POST   | `/api/measurements`         | Add a new measurement                                 |

### Example POST request

```json
{
  "consumption": 20.4,
  "timestamp": "2026-10-11T12:00:00"
}
```

## Database Configuration

The application connects to a PostgreSQL database named `electricity_monitoring`.

Set the PostgreSQL password using the `DB_PASSWORD` environment variable. Database passwords and other secrets should not be stored in source code.

## Running the Application

1. Install Java 21 and PostgreSQL.
2. Configure the PostgreSQL database and the required `measurements` table.
3. Set the `DB_PASSWORD` environment variable.
4. Open the project in Eclipse or another Java IDE.
5. Run `ElectricityMonitoringApplication.java`.

The API will be available at `http://localhost:8080`.

## Running Tests

Run the following Maven command:

```bash
mvn test
```

## Project Status

The application provides REST endpoints for creating, retrieving, and analyzing electricity consumption measurements, with PostgreSQL persistence.

## Planned Improvements

* JPA / Hibernate
* Improved exception handling
* Docker support
* API documentation
* Further automated tests and integration improvements

## Author

Portfolio project created to demonstrate Java backend development skills and continuous learning.
 
