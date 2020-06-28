This is a spring boot executable jar running on default port 8080

The code has been written in Java 8 and the build is Maven 3.6.3

After cloning repo, run mvn clean install which will create a spring boot jar executable
 >mvn clean install
 >java -jar target\evolve-0.0.1-SNAPSHOT.jar

For convenience, I have provided swagger ui -> http://localhost:8080/swagger-ui.html
I also have a test classes for BreakfastServiceTest, DinnerServiceTest and LunchServiceTest

For testing via browser use comma delimited values --> 
http://localhost:8080/api/getMenuItems?menu=Lunch
http://localhost:8080/api/getMenuItems?menu=Breakfast 1,2,3


