FROM java:8

COPY *.jar /app.jar

EXPOSE 8088

ENTRYPOINT ["java","-jar","/app.jar"]