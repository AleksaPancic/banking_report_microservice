FROM openjdk:17
COPY build/libs/*.jar report-microservice.jar
LABEL name="report-microservice", authors="Aleksa Pancic", version="1.0"
EXPOSE 5006 5100 5500
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5006"
ENTRYPOINT ["java","-jar","report-microservice.jar"]