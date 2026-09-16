# BookMyShow

A Spring Boot application modeled on a movie ticket booking platform inspired by BookMyShow. The project demonstrates core backend concepts such as user management, show management, seat booking, and ticket creation.

## Tech Stack

- Java 17
- Spring Boot 4.1.1
- Spring Data JPA
- MySQL
- Maven
- Spring Security
- Lombok

## Project Overview

This application supports:

- User registration and lookup
- Show creation and retrieval
- Seat availability checks
- Booking flow for tickets
- Seat status handling (empty, blocked, booked)
- Exception handling for invalid users, shows, and invalid seat counts

## Project Structure

```text
BookMyShow/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/scaleracademy/BookMyShow/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-dev.properties
│   └── test/
│       └── java/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── HELP.md
└── README.md
```

## Prerequisites

Before running the project, make sure you have:

- Java 17 or higher installed
- Maven installed
- MySQL running locally
- A database named `bookmyshow` available

## Database Configuration

The app is configured to use MySQL in the default profile:

- URL: `jdbc:mysql://localhost:3306/bookmyshow?createDatabaseIfNotExist=true`
- Username: ``
- Password: ``

These values are currently defined in:

- `src/main/resources/application.properties`
- `src/main/resources/application-dev.properties`

## Run the Application

From the project root, run:

```bash
./mvnw spring-boot:run
```

On Windows, you can also use:

```bash
mvnw.cmd spring-boot:run
```

## Build the Project

```bash
./mvnw clean package
```

## Notes

- The app uses the `dev` profile by default.
- `spring.jpa.hibernate.ddl-auto=update` will create or update the database schema automatically.
- The project includes a custom exception layer to handle invalid or blocked seat operations.

## Useful Links

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MySQL Connector/J](https://dev.mysql.com/doc/connector-j/en/)
