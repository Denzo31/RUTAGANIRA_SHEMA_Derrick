FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy all source files maintaining package structure
COPY *.java ./lemigohotel/

# Compile with package awareness
RUN javac lemigohotel/*.java

# Run with full package qualification
CMD ["java", "lemigohotel.Main"]