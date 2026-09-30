# Task 17 — GitHub Actions CI/CD

Write the workflows in this directory.

Do not store AWS access keys in GitHub.

## Pull Request CI

Create a workflow that runs on pull requests.

Required stages:

```text
Checkout
  ↓
Setup Java 21
  ↓
Cache Maven dependencies
  ↓
mvn clean test
  ↓
mvn package
  ↓
Dependency/security checks
  ↓
Docker build validation
  ↓
Image scan
```

The pipeline must fail when required tests or security gates fail.

## Main Branch Build/Push

For accepted changes:

```text
Checkout
  ↓
Setup Java 21
  ↓
mvn clean test
  ↓
mvn package
  ↓
Authenticate to AWS using OIDC
  ↓
Login to ECR
  ↓
Docker build
  ↓
Tag with immutable identifier
  ↓
Push to ECR
```

Do not rely only on `latest`.

Use a traceable image tag such as the Git commit SHA.

## Deployment

Deploy the exact image produced by CI to EKS using Helm.

The deployment must:

- authenticate without long-lived AWS keys;
- update kubeconfig or use another secure EKS deployment method;
- deploy the immutable image tag;
- wait for rollout;
- fail when rollout fails;
- preserve enough information to identify the deployed commit.

Suggested validation commands:

```bash
kubectl rollout status deployment/orders-api -n <namespace>
helm history orders-api -n <namespace>
```

## Checkpoint

Be able to explain why the Java pipeline uses:

```bash
mvn clean test
mvn package
```

while a Python pipeline might use:

```bash
pip install -r requirements.txt
pytest
```

The CI/CD principles are the same even though the build commands differ.
