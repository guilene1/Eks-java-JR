# Interview Preparation

## Java CI/CD

1. Walk through the CI pipeline for this Java application.
2. What happens during `mvn clean test`?
3. What happens during `mvn package`?
4. Why is a JAR created?
5. How is Java CI different from Python CI?
6. Why cache Maven dependencies?
7. Would you deploy `latest` to production? Why or why not?

## Docker

8. Explain the Dockerfile.
9. Why use a multi-stage build?
10. Why run containers as non-root?
11. How would you reduce Java container image size?
12. What is the difference between build-time and runtime dependencies?

## Kubernetes

13. Explain Deployment, ReplicaSet, Pod, and Service.
14. Readiness vs liveness?
15. What causes `CrashLoopBackOff`?
16. What causes `ImagePullBackOff`?
17. How do you troubleshoot a Pending pod?
18. What are requests and limits?
19. How does HPA work?
20. Why might HPA fail even when CPU is high?
21. What is a PodDisruptionBudget?
22. ConfigMap vs Secret?
23. How does a rolling update work?
24. How do you rollback a bad deployment?

## EKS / AWS

25. Why use EKS instead of running Kubernetes yourself?
26. Why place worker nodes in private subnets?
27. How does an ALB route traffic to Kubernetes?
28. What does AWS Load Balancer Controller do?
29. How should a pod obtain AWS permissions?
30. EBS vs EFS?
31. How would you troubleshoot an unhealthy ALB target?
32. What happens if an Availability Zone fails?

## Terraform

33. What did Terraform provision in this project?
34. What should Terraform manage versus Helm?
35. Why use remote state?
36. How would you protect Terraform state?
37. What would you do if Terraform planned to replace the EKS cluster unexpectedly?

## Helm

38. Why use Helm after learning raw manifests?
39. What belongs in `values.yaml`?
40. Explain `helm upgrade --install`.
41. How do you inspect release history?
42. How do you rollback?

## GitHub Actions / Security

43. Explain GitHub OIDC authentication to AWS.
44. Why is OIDC better than stored AWS access keys?
45. What should be restricted in the IAM trust policy?
46. What GitHub permissions are needed for OIDC?
47. Where should security scanning occur?
48. How would you prevent an unreviewed PR from deploying production?

## Troubleshooting stories

Prepare STAR-format answers for:

49. A failed Kubernetes deployment.
50. A CI/CD pipeline failure.
51. An IAM/OIDC problem.
52. An ALB/Ingress problem.
53. A persistent storage problem.
54. A scaling/capacity incident.
55. A Terraform change that required careful review.

For each answer emphasize evidence and troubleshooting sequence rather than saying only that a configuration was changed.
