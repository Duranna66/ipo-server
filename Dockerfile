FROM bellsoft/liberica-openjdk-alpine:17
WORKDIR /opt

COPY build/libs/*.jar ipo.jar

ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005
CMD ["java", "-jar", "ipo.jar"]