# Architecture Review

The finished platform should resemble:

```text
                         Internet
                            |
                         Route 53
                            |
                         HTTPS/TLS
                            |
                     Application LB
                            |
                         Ingress
                            |
                         Service
                            |
             +--------------+--------------+
             |              |              |
           Pod A          Pod B         Pod N
             \              |              /
              +-------------+-------------+
                            |
                           HPA

                 Amazon EKS private nodes
             +-------------------------------+
             |          Private AZ-A         |
             |          Private AZ-B         |
             +-------------------------------+

GitHub Actions --OIDC--> AWS IAM
       |
       +--> ECR
       |
       +--> Helm --> EKS

Terraform
   |
   +--> VPC
   +--> IAM
   +--> ECR
   +--> EKS

Observability:
Prometheus --> Grafana
```

## Architecture review questions

1. Why are worker nodes private?
2. Why is the ALB public while nodes remain private?
3. Why use multiple Availability Zones?
4. Why does EKS need IAM integration?
5. Why should CI push immutable image tags?
6. What belongs in Terraform versus Helm?
7. What belongs in a Kubernetes ConfigMap versus Secret?
8. Why is an HPA not a substitute for a Cluster Autoscaler?
