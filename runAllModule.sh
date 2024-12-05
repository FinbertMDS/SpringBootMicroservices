mvn -f discoveryserver spring-boot:run
mvn -f api-gateway spring-boot:run
mvn -f configserver spring-boot:run
mvn -f management-service spring-boot:run
mvn -f advertisement-service spring-boot:run
mvn -f user-service spring-boot:run
mvn -f report-service spring-boot:run