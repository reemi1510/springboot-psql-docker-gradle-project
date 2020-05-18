FROM openjdk:8
VOLUME /tmp
EXPOSE 8080
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD build/libs/project.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]