## Steps

### Create Docker Machine (Optional)

``docker-machine create --driver virtualbox --virtualbox-memory 4096 devnation-2015;``

To point your Docker client at it, run this in your shell

``eval "$(docker-machine env devnation-2015)"``

### Start using docker-compose

* ``docker-compose -f _docker/slides.yml build``
* ``docker-compose -f _docker/slides.yml up``
* ``open http://{docker-machine-ip}:8080/``

### Or simply use plain Docker

```
docker run -it -v $(pwd)/slides:/documents/ docker_asciidoctor

asciidoctor -T /documents/asciidoctor-backends/slim/dzslides slides.adoc
```
