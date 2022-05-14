```bash 
$ ./google-cloud-sdk/install.sh
```
or
```bash 
$ brew cask install google-cloud-sdk
```

### To connect to the cluster from gcloud terminal
```bash 
$ gcloud auth login
$ gcloud container clusters get-credentials spms-cluster --zone us-central1-c --project spring-microservices-350123
```
### To configure a project from gcloud terminal
```bash 
$ gcloud config set project <PROJECT_ID>
```
### To get all the nodes of a cluster
```bash 
$ kubectl get nodes
```
### To get all the pods of a node
```bash 
$ kubectl get pods
```
### To get all the deployments
```bash 
$ kubectl get deployments
```
### To get all the services
```bash 
$ kubectl get services
```
### To get all the replica set of all the pods in a k8s cluster
```bash 
$ kubectl get replicaset
```
### To get all the components of a k8s cluster 
```bash 
$ kubectl get all
```
### To get all the config maps of a k8s cluster
```bash 
$ kubectl get configmap
```
### To apply a config maps to a k8s cluster
```bash 
$ kubectl apply -f <configmap_file.yml>
outout: configmap/spring-microservice-configmap created
```
### To delete a config maps from a k8s cluster
```bash 
$ kubectl delete configmap <configmap_name>
```
