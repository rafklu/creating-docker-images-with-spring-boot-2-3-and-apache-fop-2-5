# Creatin Docker Images with Spring Boot 2.3 and Apache FOP 2.5

## Usage
Build app, build container, run container then call app endpoint.

### Build app
Run: `mvn clean package`

### Build container
You can build container using Buildpacks or Layered Jars method.

#### Buildpacks
Build container: `./mvnw spring-boot:build-image`

#### Layered jars
Build container `docker build . --tag sample-spring-fop-app:0.0.1-SNAPSHOT`

### Run container
Run: `docker run -it -p 8080:8080 sample-spring-fop-app:0.0.1-SNAPSHOT`

### Call app endpoint
Open http://localhost:8080/download.pdf

## Helpers

### List Docker images
Run: `docker images`

### Inspect layers of docker image
Run: `dive sample-spring-fop-app:0.0.1-SNAPSHOT`

## Useful links
* https://springframework.guru/why-you-should-be-using-spring-boot-docker-layers/
* https://www.baeldung.com/dockerizing-spring-boot-application
* https://www.baeldung.com/spring-boot-docker-images
* https://spring.io/blog/2020/01/27/creating-docker-images-with-spring-boot-2-3-0-m1
* https://reflectoring.io/spring-boot-docker/
* https://github.com/wagoodman/dive
