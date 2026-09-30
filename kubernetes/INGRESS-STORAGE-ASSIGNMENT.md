# Tasks 14–15 — Ingress and Persistent Storage

## Task 14 — AWS Load Balancer Controller

Install the AWS Load Balancer Controller using Helm.

Configure its AWS permissions using the workload identity mechanism selected in the Terraform task.

Create an Ingress that exposes the application through an Application Load Balancer.

Requirements:

- internet-facing ALB;
- correct target type;
- health check;
- application routing;
- HTTPS when a domain/certificate is available.

Stretch:

- Route 53 DNS record;
- ACM certificate;
- HTTP to HTTPS redirect.

### Checkpoint

Inspect:

```bash
kubectl get ingress -n <namespace>
kubectl describe ingress <name> -n <namespace>
```

Confirm the ALB target group becomes healthy.

## Task 15 — Persistent storage

Create a small second workload or application path that demonstrates Kubernetes persistent storage.

Choose EBS CSI when single-AZ block storage behavior is appropriate, or EFS CSI when shared multi-pod/multi-AZ storage is required.

Create the necessary:

- CSI integration;
- StorageClass if needed;
- PersistentVolumeClaim;
- pod/deployment volume mount.

### Validation

Write a file to the mounted path.

Delete/restart the pod.

Confirm the file remains.

### Checkpoint

Explain the difference between EBS and EFS and when each is appropriate in EKS.
