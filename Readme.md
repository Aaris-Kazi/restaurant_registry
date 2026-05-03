## Restaurant Registry

## Command to build with ENV
    export $(cat .env | xargs) && mvn clean install

## Command to run
    mvn spring-boot:run

## Deployment env
    export SPRING_PROFILES_ACTIVE=prod

## Docker Commands to build
    docker build -t aariskazi/restaurant-listing:v1.0.0 .

    docker run -d -p 8081:8080 -e SPRING_PROFILES_ACTIVE=prod --name restaurant-listing aariskazi/restaurant-listing:v1.0.0