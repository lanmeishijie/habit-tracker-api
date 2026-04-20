# Habit Tracker API

## Coursework Information
- Module: Web Services and Web Data
- Assessment: Coursework 1 Individual Web Services API Development Project
- Project Title: Habit Tracker API

## Project Overview
Habit Tracker API is a Spring Boot RESTful web service for managing personal habits. The system supports full CRUD operations for habits stored in an SQL database and returns JSON responses through HTTP endpoints.

In addition to the core CRUD functionality, the API includes validation, global exception handling, sample startup data, and a statistics endpoint for summarising habit completion progress. This project was developed as an individual coursework submission.

## Features
- Create, read, update, and delete habits
- SQL database integration using H2
- JSON request and response handling
- Proper HTTP status codes
- Request validation using Jakarta Validation
- Global exception handling with JSON error responses
- Swagger/OpenAPI documentation
- Sample data loaded on application startup
- Habit statistics endpoint

## Technology Stack
- Java 17
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- H2 Database
- Jakarta Validation
- Maven
- springdoc-openapi

## Project Structure
- `src/main/java/com/example/habittracker/controller` - REST API endpoints
- `src/main/java/com/example/habittracker/service` - business logic
- `src/main/java/com/example/habittracker/repository` - data access layer
- `src/main/java/com/example/habittracker/model` - JPA entity classes
- `src/main/java/com/example/habittracker/dto` - request DTOs
- `src/main/java/com/example/habittracker/exception` - exception classes and global error handling
- `src/main/java/com/example/habittracker/config` - OpenAPI configuration and sample data loader
- `src/main/resources` - application configuration

## Main Endpoints
- `POST /api/habits` - create a new habit
- `GET /api/habits` - get all habits
- `GET /api/habits/{id}` - get a habit by ID
- `PUT /api/habits/{id}` - update a habit
- `DELETE /api/habits/{id}` - delete a habit
- `GET /api/habits/stats` - get habit statistics

## Setup and Run Instructions

### Prerequisites
- Java 17
- Maven

### Run the project
On Windows:

```bash
mvnw.cmd spring-boot:run
```

Or, if Maven is installed globally:

```bash
mvn spring-boot:run
```

The application starts on:

`http://localhost:8080`

## Database Configuration
This project uses an H2 in-memory database for development.

- H2 Console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:habitdb`
- Username: `sa`
- Password: leave blank

Hibernate is configured to create tables automatically during development, and SQL statements are shown in the console output.

## API Documentation
Swagger UI is available at:

`http://localhost:8080/swagger-ui.html`

OpenAPI JSON is available at:

`http://localhost:8080/v3/api-docs`

The API documentation describes the available endpoints, request bodies, and response formats, helping meet the coursework API documentation requirement.

## Sample Data
The application loads three sample habits automatically when it starts if the database is empty. This makes the project easier to demonstrate and test during development and presentation.

## Error Handling
The API returns JSON error responses for:

- `404 Not Found` when a habit does not exist
- `400 Bad Request` for validation errors
- `500 Internal Server Error` for unexpected failures

## Testing
The application structure supports testing of the controller, service, and repository layers. API behaviour can also be checked manually using Swagger UI or Postman.

To run tests:

```bash
mvnw.cmd test
```

## Notes for Submission
This repository contains the runnable source code for the coursework project together with the supporting API documentation reference required by the assessment brief. The technical report should include the full GenAI declaration and supporting conversation evidence where applicable.

## Additional Submission Links
- API Documentation PDF: [API_Documentation.pdf](./docs/API_Documentation.pdf)
