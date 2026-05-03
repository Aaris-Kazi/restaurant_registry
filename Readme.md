## Restaurant Registry

## Command to build with ENV
    export $(cat .env | xargs) && mvn clean install

## Command to run
    mvn spring-boot:run

## Deployment env
    export SPRING_PROFILES_ACTIVE=prod
    export MACHINE_IP=$(hostname -I | awk '{print $1}')

## Docker Commands to build
    docker build -t aariskazi/restaurant-listing:v1.0.0 .

    docker run -d \
  --env-file .env \
  -e MACHINE_IP=$MACHINE_IP \
  -p 8081:8080 \
  --name app \
  your-image