#!/bin/bash

# TODO: find how to pass variable from Docker to this shell
while true; do asciidoctor -o - -T $BACKEND/slim/dzslides /documents/slides.adoc; sleep $REFRESH; done
