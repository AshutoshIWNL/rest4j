# REST4J

REST4J is a comprehensive tool designed to demonstrate best practices in creating RESTful APIs using Spring Boot. This project includes a fully functional REST server with detailed documentation and examples. REST4J serves as a reference for developers to understand REST principles and implement efficient, scalable, and maintainable web services.

## Features

- **RESTful API Implementation:** A fully functional REST server implementing best practices.
- **Detailed Documentation:** API documentation generated using OpenAPI.
- **Exception Handling:** Centralized exception handling with meaningful error responses.
- **Validation:** Input validation with detailed error messages.
- **Logging:** Request and response logging for debugging and monitoring.

## Prerequisites

- JDK 17 or higher

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/yourusername/rest4j.git
cd rest4j
```
### Build the Project

```bash
mvn clean install
```

###  Run the Application
You can run the application using Maven:

```bash
mvn spring-boot:run
```
Or you can run the packaged JAR file:

```bash
java -jar target/rest4j-0.1.0.jar
```

The server will start on http://localhost:8080.

## API Documentation
The API documentation is generated using OpenAPI and is available at:
- openapi.json

You can also view the interactive Swagger UI at:
- http://localhost:8080/swagger-ui/index.html