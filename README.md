# Esteban Marin
## API
- https://github.com/HackerNews/API
## Start the application
```shell
docker-compose up
```
### CORS, reverse-proxy, Ngnix
- https://www.section.io/engineering-education/how-to-use-cors-in-nodejs-with-express/
- https://blogs.perficient.com/2021/02/10/nginx-proxy-for-cors/
###
```shell
docker build -t nginx-local:latest - < nginx.Dockerfile 
docker run --name test-nginx -d -p 80:80 nginx-local:latest                                                        
```
### Releases 
#### frontv1
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
```
http://localhost:82/images/cat.jpg
```
