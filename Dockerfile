FROM java:8-jre
MAINTAINER Andriej Melnik <adriejsoft@gmail.com>

ADD ./target/smlr.jar /app/
CMD ["java", "-jar", "/app/smlt.jar"]
EXPOSE 8080
