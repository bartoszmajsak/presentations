#!/bin/bash

for (( ; ; ))
do
  rsync -avz /documents/assets /output/
  asciidoctor --trace -o /output/slides.html -a link-assets -T /asciidoctor-backends/slim/dzslides /documents/slides.adoc
  sleep 2
done
