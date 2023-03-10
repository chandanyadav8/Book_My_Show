
# Book My Show 

## Implementation
- Application is developed in Spring Boot with Java  on Spring Tool Suite IDE. Database used is MySQL.

- You can book movie tickets using the application.

- Mandatory entities to book a ticket are - user, movie, theater with seats, shows of configured movies in configured theater with seats.

- Logging is done on console as well as file. Log file can be accessed at /var/log/bookmyshow.log.

- Exception Handling is done.

## SCHEMA
![schema](https://github.com/chandanyadav8/Book_My_Show/blob/main/ScreenShots/schema.png?raw=true)

## Api's

![api](https://github.com/chandanyadav8/Book_My_Show/blob/main/ScreenShots/api's.png?raw=true)

## Assumptions
### For the simplicity of system, I have made following assumptions while implementing the solution -

- Single User Model - One user will use at once. No locking implemented for seat selection.
- Single Screen Theaters - No multiple screen handling for a theater has been done. However an option is given for future scope.
- No Payment flow used.

## Setup the Application
- Create a database bookmyshow using the sql file bookmyshow.sql provided in src/main/resources.

- Open src/main/resources/application.properties and change spring.datasource.username and spring.datasource.password properties as per your MySQL installation.

- Type mvn spring-boot:run from the root directory of the project to run the application.

## Verifying the results from DB
### Login to your MySQL and go to bookmyshow DB

- SELECT * FROM bookmyshow.users; to see all registered users.

- SELECT * FROM bookmyshow.movies; to see all movies.

- SELECT * FROM bookmyshow.theaters; to see all theaters.

- SELECT * FROM bookmyshow.theater_seats; to see all theater's seats.

- SELECT * FROM bookmyshow.shows; to see all shows for movies in theaters.

- SELECT * FROM bookmyshow.show_seats; to see all show's seats by type.

- SELECT * FROM bookmyshow.tickets; to see all booked tickets.



## Support

For support, email cy75945@gmail.com or join my youtube channel chandan clapingo https://www.youtube.com/@Learn_With_Chandan.

