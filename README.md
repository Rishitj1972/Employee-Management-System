# Employee Management REST API

A RESTful Employee Management API built using Java, Spring Boot, Spring Data JPA, and PostgreSQL. The application supports employee CRUD operations, input validation, centralized exception handling, pagination, and department-based search.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA and Hibernate
- PostgreSQL
- Maven
- Jakarta Bean Validation
- Postman

## Features

- Create an employee
- Retrieve all employees with pagination
- Retrieve an employee by ID
- Update employee details
- Delete an employee
- Validate employee input
- Handle exceptions centrally
- Search employees by department
- Use DTOs to separate API requests and responses

## Project Architecture

```text
src/main/java/com/codenzic/employeemanagement/
├── controller/
│   └── EmployeeController.java
├── dto/
│   ├── EmployeeRequest.java
│   └── EmployeeResponse.java
├── entity/
│   └── Employee.java
├── exception/
│   ├── EmployeeNotFoundException.java
│   └── GlobalExceptionHandler.java
├── repository/
│   └── EmployeeRepository.java
├── service/
│   └── EmployeeService.java
└── EmployeeManagementApplication.java
```

## Prerequisites

- JDK compatible with the project configuration
- PostgreSQL
- Maven, or the included Maven Wrapper
- Postman or another HTTP client

## Database Setup

Create a PostgreSQL database:

```sql
CREATE DATABASE employee_db;
```

Configure your PostgreSQL connection using local application properties. For example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/employee_db
spring.datasource.username=YOUR_DATABASE_USERNAME
spring.datasource.password=YOUR_DATABASE_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

Keep database credentials out of version control. Use your local configuration or environment variables, and never commit real passwords.

## Running the Application

Clone the repository:

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
cd employee-management
```

Configure the database credentials, then run:

```bash
mvn spring-boot:run
```

The application runs at:

`http://localhost:8080`

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/employees` | Create an employee |
| GET | `/api/employees` | Retrieve employees with pagination |
| GET | `/api/employees/{id}` | Retrieve an employee by ID |
| PUT | `/api/employees/{id}` | Update an employee |
| DELETE | `/api/employees/{id}` | Delete an employee |
| GET | `/api/employees/search?department=MCA` | Search by department |

### Pagination Example

```http
GET /api/employees?page=0&size=5
```

Page numbering starts at zero.

### Create Employee Example

```http
POST /api/employees
Content-Type: application/json
```

Request body:

```json
{
  "firstName": "Rishi",
  "lastName": "TJ",
  "email": "rishi@example.com",
  "department": "IT"
}
```

## Testing

Test the endpoints using Postman. 

## Author

Rishi TJ
