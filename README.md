# MyDiary Project

## Overview

The **MyDiary** project is a web application that consists of two main components:

1. **MyDiary REST API**: This component handles API requests, connects to a MySQL database, and provides the backend services. It runs on a server at port `8080`.
   
2. **MyDiary REST Client**: This component handles the frontend logic, interacting with the REST API. The frontend runs on a separate server at port `8181`.

Both components run in parallel on different servers, with the REST API built using **Spring Boot** and the frontend built with **Java** and **JSP**. 

## Project Structure

### 1. MyDiary REST API

- **Technology**: Spring Boot, JPA, MySQL
- **Responsibilities**:
    - Handle API requests
    - Interact with the MySQL database for CRUD operations
    - Run on port `8080`

### 2. MyDiary REST Client

- **Technology**: JSP, HTML, JavaScript
- **Responsibilities**:
    - Frontend UI
    - Send API requests to the MyDiary REST API
    - Run on port `8181`

## Development Setup

This project is split across two development environments:

1. **Spring Tool Suite (IDE)**: Used to develop the **MyDiary REST API**.
2. **Eclipse IDE**: Used to develop the **MyDiary REST Client**.

Each environment has a dedicated server running on different ports:
- MyDiary REST API: Runs on port `8080`
- MyDiary REST Client: Runs on port `8181`

### Steps to Run the Project:

#### MyDiary REST API:
1. Navigate to the `MyDiary-REST-API` folder in Spring Tool Suite.
2. Run the application.
3. The application will start on port `8080` and interact with the MySQL database.

#### MyDiary REST Client:
1. Navigate to the `MyDiary-REST-Client` folder in Eclipse IDE.
2. Run the application.
3. The application will start on port `8181` and send API requests to `http://localhost:8080/`.

### Prerequisites
- Java 17+
- Spring Boot
- MySQL
- Maven

### How to Run:
1. **Clone the repository**:
    ```bash
    git clone https://github.com/SVKREP/MyDiary-RESTClient-and-RESTAPI.git
    ```

2. **Setup MySQL**:
   - Create a MySQL database and configure the connection in the `application.properties` file of the REST API.

3. **Build and Run**:
   - For REST API: `mvn spring-boot:run`
   - For REST Client: Deploy the project in Eclipse or use `mvn jetty:run` if configured.

## API Endpoints

### Entries Endpoints

Here are the main API endpoints in the MyDiary REST API for entries:

- `GET /entries`: Fetch all entries
- `POST /entries`: Add a new entry
- `PUT /entries/{id}`: Update an existing entry
- `DELETE /entries/{id}`: Delete an entry

### Users Endpoints

These are the user-related API endpoints in the MyDiary REST API:

- `GET /users`: Fetch all users
- `GET /users/{id}`: Fetch a user by ID
- `POST /users`: Register a new user
- `PUT /users/{id}`: Update an existing user
- `DELETE /users/{id}`: Delete a user by ID

## Project Design

This project uses the following design principles:

- **Separation of Concerns**: The MyDiary REST API handles the business logic and database interactions, while the REST Client manages user interactions.
- **Parallel Server Setup**: The REST API and REST Client run on separate servers and ports (`8080` and `8181`), ensuring modularity and flexibility in development and deployment.

## License

This project is licensed under the MIT License.
