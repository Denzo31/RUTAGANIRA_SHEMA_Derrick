FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy all source files maintaining package structure
COPY *.java ./traffic/

# Compile with package awareness
RUN javac traffic/*.java

# Run with full package qualification
CMD ["java", "traffic.Main"]