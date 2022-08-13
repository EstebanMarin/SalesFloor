FROM nginx:1.23

RUN apt-get update && apt-get upgrade -y
RUN mkdir -p /data/www/ && mkdir -p /data/images/
# RUN apt-get install vim -y
# RUN apt-get vim
# COPY nginx.conf /etc/nginx/conf.d/default.conf
# COPY nginx.conf /etc/nginx/nginx.conf

# COPY index.html /index.html
