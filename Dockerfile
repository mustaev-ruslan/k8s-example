FROM alpine:3.12.2

WORKDIR /usr/src/app

RUN apk update
RUN apk add openjdk11 --repository=http://dl-cdn.alpinelinux.org/alpine/edge/community
RUN apk add maven=3.6.3-r0

COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .

RUN mvn install spring-boot:repackage

RUN cp target/*.jar k8s-example.jar

CMD ["java", "-jar", "/usr/src/app/k8s-example.jar"]

EXPOSE 8080