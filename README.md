# BaseBarberSystem 

BaseBarberSystem is a backend application for managing bookings in a barber shop.

The system provides a REST API for managing customers, available time slots, services and bookings.

This project was built as a portfolio/CV project to practice backend development with Java, Spring Boot, JPA and MySQL.

## Features

* Create, read, update and delete users
* Create and manage available time slots
* Create and manage barber services
* Create, update and delete bookings
* Connect bookings to users and time slots
* Connect bookings to services
* Prevent double bookings for the same time slot
* Validate incoming data
* Handle errors with appropriate HTTP status codes
* Swagger/OpenAPI documentation
* Automated tests with JUnit

## Technologies

* Java 25
* Spring Boot 3
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* JUnit 5
* Swagger / OpenAPI
* Postman
* IntelliJ IDEA

## Project Structure

The project follows a simple layered structure:

* model – Entity classes representing database tables
* repository – Database access using Spring Data JPA
* controller – REST API endpoints
* dto – Data Transfer Objects used for API requests
* exception – Custom exceptions and global error handling
* test – Automated tests

## Database

The application uses MySQL as its database.

Main entities:

* User
* TimeSlot
* Booking
* Service
* BookingService

A booking is connected to a user and a time slot. A booking can also be connected to one or more services through the BookingService entity.

## API Endpoints

### Users

| Method | Endpoint  | Description      |
| ------ | --------- | ---------------- |
| GET    | /users    | Get all users    |
| GET    | /users/{id} | Get a user by ID |
| POST   | /users    | Create a user    |
| PUT    | /users/{id} | Update a user    |
| DELETE | /users/{id} | Delete a user    |

### Time Slots

| Method | Endpoint      | Description           |
| ------ | ------------- | --------------------- |
| GET    | /timeslots    | Get all time slots    |
| GET    | /timeslots/{id} | Get a time slot by ID |
| POST   | /timeslots    | Create a time slot    |
| DELETE | /timeslots/{id} | Delete a time slot    |

### Services

| Method | Endpoint     | Description         |
| ------ | ------------ | ------------------- |
| GET    | /services    | Get all services    |
| GET    | /services/{id} | Get a service by ID |
| POST   | /services    | Create a service    |
| DELETE | /services/{id} | Delete a service    |

### Bookings

| Method | Endpoint     | Description         |
| ------ | ------------ | ------------------- |
| GET    | /bookings    | Get all bookings    |
| GET    | /bookings/{id} | Get a booking by ID |
| POST   | /bookings    | Create a booking    |
| PUT    | /bookings/{id} | Update a booking    |
| DELETE | /bookings/{id} | Delete a booking    |

### Booking Services

| Method | Endpoint             | Description                           |
| ------ | -------------------- | ------------------------------------- |
| GET    | /booking-services    | Get all booking-service relationships |
| GET    | /booking-services/{id} | Get a booking-service relationship    |
| POST   | /booking-services    | Connect a service to a booking        |
| DELETE | /booking-services/{id} | Delete a booking-service relationship |

## Validation

The API validates incoming data before saving it to the database.

Examples include:

* Users cannot have empty names, phone numbers or roles
* Services must have a positive duration
* Services must have a valid name and positive price
* Time slots must contain a date and time

Invalid requests return an appropriate 400 Bad Request response.

## Error Handling

The application uses custom exceptions and a global exception handler.

For example:

* 404 Not Found when a requested resource does not exist
* 400 Bad Request when a request is invalid
* 400 Bad Request when a time slot is already booked

## Double Booking Prevention

The system prevents multiple bookings from using the same time slot.

When creating a booking, the application checks whether the selected time slot is already booked.

The same check is performed when moving an existing booking to another time slot.

## Swagger / OpenAPI

Swagger is used to document and test the REST API.

After starting the application, Swagger UI is available at:

http://localhost:8080/swagger-ui.html

## Testing

The project contains automated tests using JUnit 5.

The tests cover functionality such as:

* User creation and validation
* Validation of invalid user data
* Detection of already booked time slots

Tests can be run from IntelliJ IDEA or with Maven.

## Running the Project

### Requirements

* Java 25 or compatible Java version
* MySQL
* Maven

### Setup

1. Clone the repository.
2. Create a MySQL database.
3. Configure the database connection in application.properties.
4. Start the Spring Boot application.
5. Use Swagger or Postman to interact with the API.

### API

Once the application is running:

http://localhost:8080

Swagger:

http://localhost:8080/swagger-ui.html

## Project Status

The backend currently provides the core CRUD functionality, validation, error handling, booking conflict prevention, API documentation and automated tests.

The project is primarily intended as a learning and portfolio project.



## Use of AI

AI was used as a learning and development tool throughout the project.

I used AI to help me understand concepts, troubleshoot errors, discuss possible solutions and improve my understanding of Java, Spring Boot, REST APIs, validation and testing.

I wrote, reviewed and tested the implementation myself and used AI explanations to better understand why the code works and how the different parts of the application are connected.
