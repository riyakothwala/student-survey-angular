# 642 HW4 Andrea Howes & Riya Modi (student-survey-angular-restful)

# Front-end
Run `ng serve` to run angular app locally
The app survey will appear at: http://localhost:4200/survey

# Back-end
## Database Setup
First, install SQL Developer GUI using this link: https://www.oracle.com/tools/downloads/sqldev-downloads.html
Then, connect to GMU VPN and use the instructions located here: https://labs.vse.gmu.edu/index.php/Services/Oracle
to find your gmu oracle password and connect to your GMU oracle database.

Once connected, create a table named "*students*" in sqldeveloper.
DDL for the students table is:
```
CREATE TABLE STUDENTS(
	StudentId varchar(12),
	UserName varchar(255),
	Address varchar(255),
	City varchar(25),
	States varchar(25),
	Zip varchar(25),
	Telephone varchar(25),
	Email varchar(25),
	Url varchar(25),
	Campuslikes varchar(100),
	Interested varchar(25),
	Notes varchar(25),
	GradMonth varchar(25),
	GradYear varchar(25),
	Recommend varchar(25),
	Data varchar(100),
	SurveyDate varchar(25),
	PRIMARY KEY (StudentId)
);
```

Second, update */student-survey-angular/backend/survey-service/src/main/resources/db-config.properties* file with your GMU Oracle credentials to connect to the database.
Also make sure you are connected to the GMU VPN.

## Build
1. Redirect to */student-survey-angular/backend/survey-service* directory.
2. Build survey-service using `mvn clean build` command and deploy war file over the Tomcat server. If you are using any IDE, just run *survey-service* on the server directly.
The default Tomcat web-address would be http://localhost:8080/

## Test
### Add Student. (POST)
In order to add student details in the database table, pass student data (JSON format as below) in the request header using **POST** method.
URL: http://localhost:8080/survey-service/webresources/students
```
{
    "address": "hhvhvhu",
    "campuslikes": "fairfax",
    "city": "vienna",
    "email": "sdfjdsnf",
    "interested": "sdf",
    "states": "va",
    "studentId": "abcdef",
    "telephone": "21312312",
    "url": "www.goo.com",
    "userName": "rmodi",
    "zip": "22180"
}
```

### Get all student IDs. (GET)
In order to get all student IDs, use http://localhost:8080/survey-service/webresources/students.
That will return list of Ids in the json format as the response.
For example,
```
[
    "12334",
    "423123",
    "32434324",
    "3423434",
    "abcdef"
]
```	

### Get Student by ID. (GET)
In order to fetch a student by ID, use http://localhost:8080/survey-service/webresources/students/{studentId}
For example, http://localhost:8080/survey-service/webresources/students/abcdef
That will return student bean in the json format as the response (shown below).
```
{
    "address": "hhvhvhu",
    "campuslikes": "fairfax",
    "city": "vienna",
    "email": "sdfjdsnf",
    "interested": "sdf",
    "states": "va",
    "studentId": "abcdef",
    "telephone": "21312312",
    "url": "www.goo.com",
    "userName": "rmodi",
    "zip": "22180"
}
```
