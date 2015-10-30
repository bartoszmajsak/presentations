#!/bin/bash

rsync -avz /documents/assets /output/
#in order to include assets, asciidoctor needs to be execute with dzslides folder at ./dzslides
cd /output
asciidoctor -b dzslides -o /output/slides-standalone.html -T /asciidoctor-backends/slim/dzslides -a data-uri /documents/slides.adoc
