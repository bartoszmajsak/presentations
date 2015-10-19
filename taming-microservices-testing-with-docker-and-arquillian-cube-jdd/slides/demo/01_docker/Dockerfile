FROM phusion/baseimage

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY index.html /usr/src/app/

EXPOSE 8081
CMD while true; do { echo -e 'HTTP/1.1 200 OK\r\n'; cat index.html; } | nc -vv -l 0.0.0.0 8081; done 
 
