FROM java:8
MAINTAINER patrick.walsh@revature.com
VOLUME /tmp
ADD patient-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 59876
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]