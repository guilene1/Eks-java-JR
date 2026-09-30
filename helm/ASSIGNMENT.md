# Task 16 — Package the Application with Helm

After the raw Kubernetes deployment works, replace the repeated manifests with a Helm chart.

Create:

```text
helm/orders-api/
├── Chart.yaml
├── values.yaml
└── templates/
    ├── deployment.yaml
    ├── service.yaml
    ├── ingress.yaml
    ├── configmap.yaml
    ├── hpa.yaml
    └── pdb.yaml
```

## Requirements

Values should control at least:

- replica count;
- image repository;
- image tag;
- resources;
- environment;
- service settings;
- ingress settings;
- autoscaling.

Validate:

```bash
helm lint helm/orders-api
helm template orders-api helm/orders-api
```

Deploy:

```bash
helm upgrade --install orders-api helm/orders-api \
  --namespace <namespace> \
  --create-namespace
```

## Checkpoint

Perform an upgrade and rollback.

Be able to explain:

```bash
helm list
helm history orders-api
helm rollback orders-api <revision>
```
