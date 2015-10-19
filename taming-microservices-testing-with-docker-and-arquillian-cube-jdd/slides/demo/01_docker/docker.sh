docker build --tag jdd/webserver .

docker run -d -p 8081:8081 jdd/webserver
