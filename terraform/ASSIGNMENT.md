# Terraform Assignment — Build the EKS Platform

Write the Terraform implementation in this directory.

A completed Terraform solution is intentionally not provided.

## Task 3 — Terraform foundation

Create:

```text
terraform/
├── versions.tf
├── providers.tf
├── variables.tf
├── terraform.tfvars
├── outputs.tf
├── networking.tf
├── ecr.tf
├── eks.tf
├── iam.tf
└── oidc.tf
```

Use remote state rather than committing local state.

## Task 4 — Networking

Provision:

- VPC across at least two Availability Zones;
- public subnets for internet-facing load balancers;
- private subnets for EKS worker nodes;
- Internet Gateway;
- NAT connectivity for private workloads;
- route tables and associations;
- required subnet tags for EKS/load-balancer discovery.

Suggested CIDR:

```text
VPC             10.40.0.0/16
Public AZ-A     10.40.1.0/24
Public AZ-B     10.40.2.0/24
Private AZ-A    10.40.11.0/24
Private AZ-B    10.40.12.0/24
```

### Checkpoint

Show which route allows private nodes to reach external services without making those nodes publicly reachable.

## Task 5 — ECR

Create an ECR repository for `orders-api`.

Requirements:

- image scanning;
- encryption;
- lifecycle policy;
- immutable release strategy.

### Checkpoint

Authenticate Docker to ECR and push a test image.

## Task 6 — EKS

Provision an EKS cluster and managed node group.

Requirements:

- supported Kubernetes version;
- nodes in private subnets;
- multiple AZs;
- appropriate IAM roles;
- control-plane logging where appropriate;
- sensible node instance type and scaling limits;
- encrypted Kubernetes secrets where appropriate.

Output:

- cluster name;
- cluster endpoint;
- ECR repository URL.

Configure local access with the AWS CLI after deployment.

### Checkpoint

```bash
kubectl get nodes
kubectl get pods -A
```

Both commands must succeed.

## Task 7 — Workload AWS permissions

Configure the mechanism needed for Kubernetes workloads/controllers to receive AWS permissions without static AWS access keys.

Use the current AWS-supported EKS workload identity approach appropriate to the component.

### Checkpoint

Explain why AWS credentials should not be stored in Kubernetes Secrets or GitHub repository secrets.

## Task 8 — GitHub OIDC

Create the AWS IAM configuration required for GitHub Actions to authenticate to AWS using OIDC.

Restrict the trust relationship to the intended repository and branch/environment.

Grant only the permissions required for:

- ECR push;
- retrieving EKS cluster information;
- the chosen deployment method.

Do not create long-lived AWS access keys for GitHub Actions.

### Checkpoint

Explain `aud`, `sub`, and why the trust policy matters.
