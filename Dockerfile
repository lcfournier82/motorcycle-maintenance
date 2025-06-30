FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
# Create new jenkins user
RUN adduser --gecos "" --disabled-password --quiet jenkins
RUN echo "jenkins:jenkins" | chpasswd