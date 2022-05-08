FROM openjdk:11
COPY target/user-account.jar user-account.jar
WORKDIR /tmp
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar /user-account.jar"]
MAINTAINER sashank1703@gmail.com