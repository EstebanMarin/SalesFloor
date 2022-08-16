# Esteban Marin
## API
- https://github.com/HackerNews/API
## Start the application
```shell
docker-compose up
```
# 💕 Micro-frontends && Micro-services 💕
I believe in an iterative approach to software: Quality fast software is based on feedback and experimentation. 
For that, we need the right tools to compartmentalize, and route our services as we see fit, with enough room to grow. Main reason we use Nginx and Docker for our dev process. 
### CORS, reverse-proxy, Ngnix, Docker, docker-compose
To work efficiently, and manage complexity I push to have a dev environment that:
- encourages decoupling
- Share a common network
- easy to start
- based in Nginx, docker, docker-compose. 
- https://docs.nginx.com/nginx/admin-guide/web-server/reverse-proxy/
### Build nginx container. 
```shell
docker build -t nginx-local:latest - < nginx.Dockerfile 
docker run --name test-nginx -d -p 80:80 nginx-local:latest                                                        
```
# Releases 
### backv0.1 Stable
```
http://localhost:3000/
make sure to check the `back_v0.1/SalesFloor.postman_collection.json/` file
```
#### frontv1.0
Front end build with `next.js` the new and certainly not last JS framework that promises to solve all the internet problems, for the n-th time. Still cool tough. 
```
http://localhost:2000/
```
#### 0.2
Big milestone, services talking to each other within the Docker-compose network, bind mounts and all of that good stuff
```
http://localhost:82/www/
```
#### 0.1
More static content
```
http://localhost:82
```
#### 0.0
Haha yes this was literally my first version, serving static content
```
http://localhost:82/images/cat.jpg
```
# Esteban Marin
## API
- https://github.com/HackerNews/API
## Start the application
```shell
docker-compose up
```
# Micro-frontends, micro-services
I believe in an iterative approach to software: Software should be based on feedback and experimentation. 
For that we need the right tools to compartementilize 
### CORS, reverse-proxy, Ngnix, Docker, docker-compose
In order to work efficiently, manage complexity I push to have a dev environment that:
- encourages decoupling
- share common network
- easy to start
- based in Nginx, docker, docker-compose. 
- https://docs.nginx.com/nginx/admin-guide/web-server/reverse-proxy/
###
```shell
docker build -t nginx-local:latest - < nginx.Dockerfile 
docker run --name test-nginx -d -p 80:80 nginx-local:latest                                                        
```
### Releases 
### backv0.1 Stable
```
http://localhost:3000/
make sure to check the `back_v0.1/SalesFloor.postman_collection.json/` file
```
#### frontv1.0
```
http://localhost:2000/
```
#### 0.2
Big milestone, services talking to eachother
```
http://localhost:82/www/
```
#### 0.1
```
http://localhost:82
```
#### 0.0
Haha yes this was literaly my first version
```
http://localhost:82/images/cat.jpg
```
