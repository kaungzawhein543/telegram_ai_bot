# Use an OpenJDK base image
FROM openjdk:17-jdk-slim
#Set Working Directory
WORKDIR /app
# Copy built JAR into container
COPY target/Boyfriend_chatbot.jar app.jar
#Run the app
ENTRYPOINT ["java","-jar","app.jar"]