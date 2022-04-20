# BoardingPassProject

backend:
make sure to have this in your application.properties file in the resources folder after installing MySQL installer on your machine...

spring.datasource.url=jdbc:mysql://localhost:3306/boardingpass_schema
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name =com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true

replace "boardingpass_schema" with the name of a MySQL schema on your machine and put in your username and password. You may have to drop all tables in your schema first if it is not working.

Files in the Dao package interact with the MySQL database.
Files in the Controller package interact with the frontend.
Files in the Service package interact between files in Dao and Controller packages but we will probably not need this since we have small project.

Run main() in BoardingpassApplication class to start the app