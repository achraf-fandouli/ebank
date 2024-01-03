FROM openjdk:17-ea-17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /ebank/ebankClient.jar
WORKDIR /ebank
CMD [ "java","-jar","ebankClient.jar" ]