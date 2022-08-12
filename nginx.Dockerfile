FROM nginx:1.23

RUN apt-get update && apt-get upgrade -y
# RUN apt-get install vim -y
# RUN apt-get vim
COPY nginx.conf /etc/nginx/conf.d/default.conf
# COPY index.html /index.html
