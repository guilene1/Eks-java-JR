# Task 2 — Containerize the Java Application

Create `app/Dockerfile`.

Do not copy a finished Dockerfile from the project.

## Requirements

The image must:

- use a Java 21 runtime;
- run the packaged Spring Boot JAR;
- expose port 8080;
- avoid running the application as root;
- use a small runtime image where practical;
- support immutable application packaging.

Create `.dockerignore`.

## Build and test

First package the application:

```bash
mvn clean package
```

Then build the image.

Run the container and verify:

```bash
curl http://localhost:8080/actuator/health
curl http://localhost:8080/api/orders
```

## Stretch task

Create a multi-stage Dockerfile where Maven compiles the application inside the builder stage and only the JRE/JAR are present in the runtime stage.

Compare image sizes.

## Checkpoint

Explain why Java CI commonly contains a compilation/package step before container deployment.
