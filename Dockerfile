FROM ubuntu:latest
RUN apt-get update && apt-get install -y docker.io
RUN useradd -m -u 1000 -g 1000 jenkins
USER jenkins
WORKDIR /home/jenkins
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
