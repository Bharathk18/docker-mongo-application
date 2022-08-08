FROM openjdk:8
EXPOSE 8080
ADD target/docker-mangodb-application.jar docker-mangodb-application.jar
ENTRYPOINT ["java","-jar","/docker-mangodb-application.jar"]