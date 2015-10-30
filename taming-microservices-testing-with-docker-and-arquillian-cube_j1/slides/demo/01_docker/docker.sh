docker build --tag javaone/webserver .

docker run -d -p 8082:8082 javaone/webserver
