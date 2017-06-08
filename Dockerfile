FROM frolvlad/alpine-oraclejdk8:slim
ADD target/sumCalculator-0.0.1-SNAPSHOT-exec.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]