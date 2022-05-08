FROM openjdk:11
COPY target/credit-card.jar credit-card.jar
WORKDIR /tmp
EXPOSE 9000
ENTRYPOINT ["sh","-c","java -jar /credit-card.jar"]
MAINTAINER sashank1703@gmail.com