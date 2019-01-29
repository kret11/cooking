#!/bin/bash



service mongodb start

ln -s /etc/nginx/sites-available/cooking /etc/nginx/sites-enabled/

rm /etc/nginx/sites-enabled/default

service nginx start

java -jar /app/cooking-exec.jar