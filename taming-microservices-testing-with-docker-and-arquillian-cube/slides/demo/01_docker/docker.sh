docker build .

docker tag -f 5ceea6fe371f devnation2015/bash_webserver

docker run -d -p 8081:8081 devnation2015/bash_webserver
