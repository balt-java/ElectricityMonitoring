# Electricity Monitoring

## Overview

Electricity Monitoring is a Java Spring Boot REST API application for storing, retrieving, and analyzing electricity consumption measurements.

The application uses PostgreSQL to store measurement data and provides HTTP endpoints to retrieve measurements and identify the highest consumption value.

## Technologies

* Java 21
* Spring Boot 3.5.6
* Maven
* PostgreSQL
* JDBC
* REST API
* JUnit 5

## Features

* Retrieve all electricity consumption measurements
* Retrieve the measurement with the highest consumption
* Load measurement data from a PostgreSQL database
* Validate measurement values and timestamps
* Test application functionality with automated tests

## API Endpoints

| Method | Endpoint                    | Description                                           |
| ------ | --------------------------- | ----------------------------------------------------- |
| GET    | `/api/test`                 | Check whether the API is running                      |
| GET    | `/api/measurements`         | Retrieve all measurements                             |
| GET    | `/api/measurements/highest` | Retrieve the measurement with the highest consumption |

## Database Configuration

The application connects to a local PostgreSQL database named `electricity_monitoring`.

Configure the database password using the `DB_PASSWORD` environment variable.

Do not store database passwords or other secrets in the source code.

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

The application currently provides basic REST endpoints for retrieving and analyzing electricity consumption measurements.
