#! /bin/bash

service mongodb start
service nginx start
java -jar /app/cooking-exec.jar
