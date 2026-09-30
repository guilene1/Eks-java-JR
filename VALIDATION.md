# Validation Checklist

## Java / Maven

- [ ] Java 21 is used.
- [ ] `mvn clean test` passes.
- [ ] `mvn package` creates a runnable JAR.
- [ ] The JAR runs locally.
- [ ] `/api/orders` responds.
- [ ] Actuator health endpoint reports healthy.

## Docker

- [ ] Dockerfile is present.
- [ ] Image builds successfully.
- [ ] Container runs as a non-root user.
- [ ] Application responds on port 8080.
- [ ] `.dockerignore` is present.
- [ ] Runtime image does not unnecessarily contain build tooling.

## Terraform / AWS

- [ ] Remote state is configured.
- [ ] VPC spans at least two AZs.
- [ ] EKS worker nodes are private.
- [ ] ECR exists.
- [ ] EKS cluster is reachable with `kubectl`.
- [ ] Managed nodes join the cluster.
- [ ] IAM permissions follow least privilege.
- [ ] No static AWS credentials are committed.
- [ ] GitHub OIDC trust is restricted appropriately.

## Kubernetes

- [ ] Dedicated namespace exists.
- [ ] Deployment has at least two replicas.
- [ ] Service selects the correct pods.
- [ ] CPU/memory requests are defined.
- [ ] CPU/memory limits are defined.
- [ ] Readiness probe works.
- [ ] Liveness probe works.
- [ ] HPA is configured.
- [ ] PDB is configured.
- [ ] Rolling deployment succeeds.

## Ingress

- [ ] AWS Load Balancer Controller is operational.
- [ ] Ingress provisions an ALB.
- [ ] Target group is healthy.
- [ ] Application is reachable through the ALB.
- [ ] HTTPS is configured when DNS/certificate are available.

## Helm

- [ ] Chart passes `helm lint`.
- [ ] `helm template` renders successfully.
- [ ] Application installs with `helm upgrade --install`.
- [ ] Image tag is configurable.
- [ ] Upgrade works.
- [ ] Rollback works.

## Storage

- [ ] PVC binds successfully.
- [ ] Workload mounts persistent storage.
- [ ] Data survives pod replacement.
- [ ] Storage choice can be justified.

## CI/CD

- [ ] Pull requests run Java tests.
- [ ] Maven package step runs.
- [ ] Security/dependency checks run.
- [ ] Docker image builds.
- [ ] Image scanning is present.
- [ ] AWS authentication uses OIDC.
- [ ] Image is pushed to ECR.
- [ ] Commit SHA or equivalent immutable tag is used.
- [ ] Helm deploys the exact image version.
- [ ] Pipeline waits for Kubernetes rollout.
- [ ] Failed rollout causes deployment job failure.

## Observability

- [ ] Prometheus is operational.
- [ ] Grafana is operational.
- [ ] Kubernetes workload metrics are visible.
- [ ] At least one useful dashboard exists.

## Final proof

Be able to demonstrate:

```text
git push
   ↓
Java tests
   ↓
Maven package
   ↓
Docker build
   ↓
Security scan
   ↓
ECR
   ↓
Helm
   ↓
EKS rolling deployment
   ↓
ALB
   ↓
Working application
```
