# Project 4 — Java Application on Amazon EKS

## Goal

Build and operate a production-shaped Kubernetes platform on AWS for a Java application.

This project intentionally does **not** provide the Terraform, Dockerfile, Kubernetes manifests, Helm chart, or GitHub Actions workflow. Those are the core hands-on tasks.

The Java application is provided so the focus stays on DevOps, CI/CD, AWS, Kubernetes, Terraform, Helm, troubleshooting, and interview readiness.

## Technology

- Java 21
- Spring Boot
- Maven
- Docker
- Amazon ECR
- Amazon EKS
- Kubernetes
- Helm
- AWS Load Balancer Controller
- Amazon EBS CSI or EFS CSI
- Horizontal Pod Autoscaler
- Prometheus + Grafana
- Terraform
- GitHub Actions
- GitHub OIDC

## Target Architecture

```text
Developer
   |
   | git push / pull request
   v
GitHub
   |
   v
GitHub Actions
   |
   +--> setup Java 21
   +--> mvn clean test
   +--> mvn package
   +--> dependency/security checks
   +--> docker build
   +--> image scan
   |
   | OIDC
   v
AWS IAM
   |
   +------------------> Amazon ECR
                           |
                           v
                     Amazon EKS
                           |
                +----------+----------+
                |                     |
           Deployment               HPA
                |
              Pods
                |
             Service
                |
         ALB Ingress / TLS
                |
             Route 53
                |
               User

Terraform provisions the AWS platform.
Helm packages and deploys the Kubernetes application.
Prometheus and Grafana provide observability.
```

## Repository

```text
project-4-eks-java-job-readiness/
├── app/                    # provided Java application
├── terraform/              # write the AWS/EKS Terraform here
├── kubernetes/             # write raw Kubernetes resources here
├── helm/                   # build the Helm chart here
├── .github/workflows/      # build CI/CD here
├── troubleshooting/
├── interview-prep/
├── architecture/
├── VALIDATION.md
└── README.md
```

## Project progression

1. Run and test the Java application.
2. Understand Maven build lifecycle.
3. Containerize the JAR.
4. Provision ECR and EKS with Terraform.
5. Configure Kubernetes access.
6. Deploy with raw Kubernetes manifests.
7. Add probes, resources, autoscaling, and disruption protection.
8. Expose the workload through AWS Load Balancer Controller.
9. Package the deployment with Helm.
10. Add persistent storage.
11. Add Prometheus and Grafana.
12. Build CI with GitHub Actions.
13. Authenticate GitHub to AWS with OIDC.
14. Push immutable images to ECR.
15. Deploy to EKS with Helm.
16. Validate and troubleshoot the complete platform.

See the assignment files in each directory.
