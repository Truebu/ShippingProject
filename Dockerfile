FROM openjdk:17.0.2

EXPOSE 8080

COPY target/ShippingProject-0.0.1-SNAPSHOT.jar .

CMD java -jar ShippingProject-0.0.1-SNAPSHOT.jar