# Kubernetes Assignment

Before using Helm, deploy the application using raw Kubernetes resources so each object is understood.

## Task 9 — Namespace and configuration

Create a dedicated namespace.

Create configuration for values such as:

```text
APP_ENV=dev
```

Use the correct Kubernetes object for non-sensitive configuration.

## Task 10 — Deployment

Create a Deployment for `orders-api`.

Requirements:

- at least two replicas;
- ECR image;
- container port 8080;
- CPU and memory requests;
- CPU and memory limits;
- rolling-update strategy;
- readiness probe;
- liveness probe.

Spring Boot exposes probe endpoints under `/actuator/health`.

### Checkpoint

```bash
kubectl get deployment -n <namespace>
kubectl get pods -n <namespace>
kubectl describe pod <pod> -n <namespace>
```

Explain the difference between readiness and liveness.

## Task 11 — Service

Create a Service that exposes the Deployment internally.

Do not use `LoadBalancer` simply to bypass the Ingress exercise.

### Checkpoint

Verify the Service endpoints match the application pods.

## Task 12 — HPA

Configure Horizontal Pod Autoscaling.

Choose a CPU target and reasonable minimum/maximum replicas.

Install/configure Metrics Server if needed.

### Checkpoint

```bash
kubectl get hpa -n <namespace>
kubectl top pods -n <namespace>
```

Generate load and observe scaling behavior.

## Task 13 — Pod disruption protection

Create a PodDisruptionBudget appropriate for a multi-replica application.

Explain the difference between voluntary disruption and application failure.
