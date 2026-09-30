# Troubleshooting Scenarios

Do not jump directly to rebuilding the infrastructure.

For every scenario document:

1. symptom;
2. first observation;
3. commands used;
4. evidence collected;
5. root cause;
6. fix;
7. validation;
8. prevention.

## Scenario 1 — CrashLoopBackOff

A new release repeatedly restarts.

Investigate application logs, container command, configuration, probes, exit codes, and resource constraints.

## Scenario 2 — ImagePullBackOff

Pods cannot pull the image from ECR.

Investigate image URI/tag, ECR existence, node/workload permissions, network access, and registry authentication behavior.

## Scenario 3 — Deployment is running but Service has no endpoints

Pods show `Running`, but the Service does not route traffic.

Use Kubernetes inspection commands to determine why.

## Scenario 4 — Readiness fails but liveness passes

The process remains alive but never receives traffic.

Explain why Kubernetes can intentionally keep a running pod out of Service endpoints.

## Scenario 5 — Liveness probe causes a restart loop

The application works when tested manually but Kubernetes continually restarts it.

Investigate path, port, initial delay/startup behavior, timeout, and failure threshold.

## Scenario 6 — Pods remain Pending

A new deployment never schedules.

Investigate events, requests/limits, node capacity, taints/tolerations, affinity, PVC binding, and AZ constraints.

## Scenario 7 — HPA does not scale

CPU load increases but replicas remain unchanged.

Investigate metrics availability and resource requests.

## Scenario 8 — ALB is not created

Ingress exists but no external address appears.

Investigate the controller, IAM permissions, subnet discovery/tags, annotations, events, and logs.

## Scenario 9 — ALB returns 503

The load balancer exists but the application is unavailable.

Trace traffic layer by layer:

```text
ALB -> target group -> Ingress -> Service -> endpoints -> Pods
```

## Scenario 10 — GitHub OIDC AssumeRole failure

CI reaches AWS authentication and fails.

Investigate repository identity, branch/environment, audience, subject condition, provider, role ARN, and workflow permissions.

## Scenario 11 — Maven works locally but fails in GitHub Actions

Investigate Java version, Maven version/wrapper, dependency resolution, test assumptions, filesystem paths, environment variables, and caching.

## Scenario 12 — New deployment is broken

The previous Helm release worked.

Demonstrate how to inspect rollout state and Helm history, then recover safely.

## Scenario 13 — Persistent data disappears

A pod is replaced and expected data is gone.

Determine whether data was written to the container filesystem or persistent storage.

## Scenario 14 — PVC remains Pending

Investigate StorageClass, CSI driver, access mode, topology/AZ constraints, and provisioning events.

## Scenario 15 — Pod receives AccessDenied from AWS

The application/controller needs an AWS API but is denied.

Trace the Kubernetes service account/workload identity to the AWS IAM role and policy.

## Scenario 16 — Terraform wants to replace critical EKS infrastructure

A routine change produces an unexpectedly destructive plan.

Stop before applying. Identify the changed attribute and explain a safe migration/review strategy.

## Scenario 17 — Cluster cost is unexpectedly high

Review worker capacity, NAT, ALB count, storage, idle environments, logging, and observability components. Identify optimization opportunities without weakening required availability.
