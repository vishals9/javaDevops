# JavaDevops

A Spring Boot application demonstrating DevOps practices with CI/CD pipeline integration.

## Tech Stack

- **Java 21**
- **Spring Boot 4.0.3**
- **Maven** (with Maven Wrapper)
- **Lombok** for boilerplate reduction
- **Jenkins** for CI/CD pipeline

## Project Structure

```
src/
├── main/
│   ├── java/org/example/javadevops/
│   │   ├── JavaDevopsApplication.java      # Main entry point
│   │   ├── controller/
│   │   │   └── JavaDevopsController.java   # REST controller
│   │   └── response/
│   │       └── HealthResponse.java         # Response DTO
│   └── resources/
│       └── application.yaml                # Application configuration
└── test/
    └── java/org/example/javadevops/
        ├── JavaDevopsApplicationTests.java
        └── controller/
            └── JavaDevopsControllerTest.java
```

## API Endpoints

### Health Details

```
GET /health/details
```

Returns application health information.

**Response:**
```json
{
  "applicationName": "javaDevops",
  "currentTimeStamp": 1740067200000,
  "buildVersion": "1.0.0",
  "message": "Java DevOps Example"
}
```

| Field | Description |
|-------|-------------|
| `applicationName` | Application name from `spring.application.name` |
| `currentTimeStamp` | Current server timestamp in milliseconds |
| `buildVersion` | Build version from `BUILD_VERSION` environment variable |
| `message` | Custom message from application properties |

## Configuration

### Application Properties

Configure in `src/main/resources/application.yaml`:

```yaml
spring:
  application:
    name: javaDevops
message: "Java DevOps Example"
```

### Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| `BUILD_VERSION` | Application build version | `1.0.0` |
