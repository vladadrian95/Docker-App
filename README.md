# Docker-App

To run:
1. mvn clean install
2. docker build --tag=rest-app --rm=true .
3. docker run -d -p 8080:8080 rest-app
