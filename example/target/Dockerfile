FROM java:8
MAINTAINER patrick.walsh@revature.com
VOLUME /tmp
ADD example-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9999
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]