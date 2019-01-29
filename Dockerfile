FROM adoptopenjdk/openjdk11-openj9

EXPOSE 80

RUN apt update && apt install -y mongodb nginx 
RUN mkdir /app

COPY start.sh /app/
COPY target/cooking-exec.jar /app/

CMD ["/app/start.sh"]
