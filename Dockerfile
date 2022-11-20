FROM openjdk:11
ARG JAR_FILE=build/libs/TINGESO_EVAL2_TDISSE-3-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} TINGESO_EVAL2_TDISSE-3-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/TINGESO_EVAL2_TDISSE-3-0.0.1-SNAPSHOT.jar"]