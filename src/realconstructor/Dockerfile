FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy all source files maintaining package structure
COPY *.java ./realconstructor/

# Compile with package awareness
RUN javac realconstructor/*.java

# Run with full package qualification
CMD ["java", "realconstructor.Main"]