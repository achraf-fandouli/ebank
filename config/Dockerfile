FROM openjdk:17-ea-17-oracle
ARG JAR_FILE=target/ebank-config.jar
COPY ${JAR_FILE} /ebank/ebankconfig.jar
WORKDIR /ebank
CMD [ "java","-jar","ebankconfig.jar" ]