FROM openjdk:11
COPY target/customer-loan.jar customer-loan.jar
WORKDIR /tmp
EXPOSE 8090
ENTRYPOINT ["sh","-c","java -jar /customer-loan.jar"]
MAINTAINER sashank1703@gmail.com