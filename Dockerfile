FROM openjdk:8
ADD target/tree-data-management.jar tree-data-management.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "tree-data-management.jar"]