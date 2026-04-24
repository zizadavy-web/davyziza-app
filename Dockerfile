# 1. Use a base Java image
FROM eclipse-temurin:25-jdk-jammy

# 2. Set working directory inside container
WORKDIR /app

# 3. Copy your jar file into container
COPY Ass1exo.jar app.jar

# 4. Command to run your app
ENTRYPOINT ["java", "-jar", "app.jar"]