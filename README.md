# EventTrackerProject

## Overview
This project will be completed over three weekends, and thus progress will be updated per week.

1/7/2021:
Need help keeping track of the NBA? Look no further! NBA Tracker is full-stack website that allows you to keep track of the NBA including its players, teams, and coaches (further data types to be added in the future). This website allows for full CRUD operations (create, read, update and delete) of the team data type (further expansion of CRUD on other data types is planned)

To accomplish this, a full-stack program was created. At the bottom of the stack, a mySQL data base was created to store all of the data types. The next part of the stack created was a JPA (Java Persistence API), Gradle project. This part of the stack allowed for communication between the database and the object-oriented domain. In this portion of the program Entity classes were made and had their relationships mapped. To confirm the entities fidelity to the database, JUnit jupiter tests were used. To access these entities and perform business logic/basic object manipulation, we created a RESTful-like project. Through using JPARepositories, Service interfaces, and controllers the program can efficiently find objects (basic and custom searches), create new objects, update, and delete. This part of the stack also allows for unique logic to the program.

Future directions include adding more data types to the data base, add more logic to retrieve unique data sets to display (ex: finding players by team, finding coaches by keyword, etc.), and implementing the front-end.


1/16/2021:
This portion of the project was primarily focused on front-end functionality. Added features to the website include dynamically displaying all of the teams, add new teams to the league, and show the conference split. If the user clicks on a team in the table, they are given a form to update the team as well as the option to delete the team.  All of these features were accomplished using JavaScript and AJAX, allowing for the data to be displayed dynamically.

Future directions include making the display teams function more robust and complete (Displaying All players for a team, displaying the image, instead of its link, etc.) and Changing the format/styling of the website to be more pleasing to the eyes.


#### How to Return

### REST API
Go to http://3.13.17.130:8080/NBATracker/api/teams


### HTML/JavaScript Front End
Go to http://3.13.17.130:8080/NBATracker/index.html


### Angular Front End

## REST API Reference
| Return Type | HTTP Method | URI               | Request Body  | Purpose             |
|-------------|-------------|-------------------|---------------|---------------------|
| List <Team> | GET         | api/teams         |               | List all teams      |
| Team        | GET         | api/teams/{id}    |               | Retrieve Team by id |
| Team        | POST        | api/teams         | Team JSON     | Create new team     |
| Team        | PUT         | api/teams{id}     | Team JSON     | Update team         |
| Team        | DELETE      | api/teams/{id}    |               | Delete team         |

## Technologies Used
* Hibernate
* Spring Tool Suite 4
* Spring Boot
* MySQLWorkbench
* Postman
* JUnit jupiter
* MAMP
* RESTful Services
* Java Persistence API
* JavaScript
* AJAX
* Git
* Github
* Google

## Lessons Learned
1/7/2021:
The start of this project was very helpful to my understanding of building a full-stack program from scratch. This includes building a database and building/configuring the back-end. I also learned how to test my entities via JUnit and Postman to confirm the correct data is being presented/processed. A new tool utilized was RESTful services which greatly reduced the complexity of processing the data from the JPA. I look forward to expanding the websites logic as well as building the front-end.


1/16/2021:
This project was an excellent way to solidify my understanding of JavaScript and how to make a website dynamic. This was achieved by using AJAX, which was a new technique to me. Learning how to use AJAX was initially challenging, however this utilizing it in this project made it much more clear. I am eager to learn about frameworks like Angular to simplify and make the process more efficient.
