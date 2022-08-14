# Esteban Marin
## API
- https://github.com/HackerNews/API
## Start the application
```shell
docker-compose up
```
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
