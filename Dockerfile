FROM adoptopenjdk/openjdk11-openj9

EXPOSE 80

RUN apt update && apt install -y mongodb nginx net-tools vim nmap tmux screen
RUN mkdir /app

COPY start-jar.sh /app/
COPY nginx.conf /etc/nginx/sites-available/cooking
COPY target/cooking-exec.jar /app/

CMD ["/app/start-jar.sh"]
