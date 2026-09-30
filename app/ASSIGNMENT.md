# Task 1 — Understand and Build the Java Application

The application is already provided. The objective is to understand how a Java build differs from the Python projects.

## Requirements

Install Java 21 and Maven.

Run:

```bash
java -version
mvn -version
```

From `app/`:

```bash
mvn clean test
mvn package
```

Locate the generated JAR under `target/`.

Run it:

```bash
java -jar target/orders-api-1.0.0.jar
```

Test:

```bash
curl http://localhost:8080/api/orders
curl http://localhost:8080/api/info
curl http://localhost:8080/actuator/health
curl http://localhost:8080/actuator/health/liveness
curl http://localhost:8080/actuator/health/readiness
```

## Checkpoint

Be able to explain:

- What `mvn clean` does.
- Difference between `mvn test` and `mvn package`.
- What the `target/` directory contains.
- Why Java produces a JAR before the Docker build.
- How this build differs from `pip install` and `pytest`.
