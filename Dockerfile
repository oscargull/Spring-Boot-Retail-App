FROM eclipse-temurin:21-jdk-jammy

# create a dedicated user
RUN useradd -m admin
WORKDIR /home/admin

COPY ./target/amazin-0.0.1-SNAPSHOT.jar /home/admin/amazin.jar

ENTRYPOINT ["java", "-jar", "/home/admin/amazin.jar"]