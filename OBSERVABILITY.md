# Task 18 — Observability

Install Prometheus and Grafana using Helm.

At minimum, observe:

- pod CPU;
- pod memory;
- replica count;
- pod restarts;
- deployment health;
- node capacity.

Configure Spring Boot metrics as needed for application-level visibility.

Create at least one useful dashboard.

## Alerting exercise

Define alert conditions for examples such as:

- high pod restart count;
- deployment unavailable replicas;
- sustained CPU pressure;
- failed application health.

## Checkpoint

Given a slow application, identify which metrics would help distinguish:

- application issue;
- CPU saturation;
- memory pressure;
- insufficient replicas;
- node capacity problem.
