FROM openjdk:17-ea-17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /ebank/registry.jar
WORKDIR /ebank
CMD [ "java","-jar","registry.jar" ]