# Esteban Marin
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