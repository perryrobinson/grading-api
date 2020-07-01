# grading-api
Simple Java and Spring Boot API/service that will collect and grade worksheets .

The specific API endpoints are up to you to design and implement as you see fit, as long as they are capable of collecting, grading, and reporting on student responses .

Requirements
    1. The API must accept an input temperature for each worksheet question
    2. The API must accept a target unit of measure for each worksheet question
    3. The API must accept a student's numeric response for each worksheet question
    4. The student's response must match an authoritative answer after both the student's response and authoritative answer are rounded to the ones place. The system indicates that the response is correct, incorrect, or invalid .
    
How to install
1) Clone the github repo locally .
2) Open the pom.xml using IntelliJ IDEA. All the needed dependencies are in the pom.xml .
3) Use Maven to clean, compile, and verify to install the dependencies .

How to run
1) Configure the port you want to run the API on by modifying the src\main\resources\application.properties. It is currently set to run on port 8081 .
2) Run src\main\java\com\mednet\mednetgradingapi\MednetGradingApiApplication.java with IntelliJ IDEA locally . 
3) Once the API is running, visit http://localhost:8081/swagger-ui.html to interact with API locally .
4) Click on "grading-controller" in Swagger UI. 
5) Under the POST request, click "try it out".
6) Fill in the json data with inputTemperature, inputUnits, studentResponse, and targetUnits .

Sample data:
1) correct studentResponse, returns "correct"

{
  "problemStatement": {
    "inputTemperature": "84.2",
    "inputUnits": "Fahrenheit"
  },
  "studentResponse": "543.5",
  "targetUnits": "Rankine"
}

2) correct studentResponse, returns "correct"

{
  "problemStatement": {
    "inputTemperature": "-45.14",
    "inputUnits": "Celsius"
  },
  "studentResponse": "227.51",
  "targetUnits": "Kelvin"
}

3) incorrect studentResponse, returns "incorrect"

{
  "problemStatement": {
    "inputTemperature": "317.33",
    "inputUnits": "Kelvin"
  },
  "studentResponse": "110.5",
  "targetUnits": "Fahrenheit"
}

4) invalid (is a string) studentResponse, returns "incorrect"

{
  "problemStatement": {
    "inputTemperature": "6.5",
    "inputUnits": "Fahrenheit"
  },
  "studentResponse": "cat",
  "targetUnits": "Rankine"
}
    
5) invalid inputTemperature, returns "invalid"

{
  "problemStatement": {
    "inputTemperature": "bird",
    "inputUnits": ""
  },
  "studentResponse": "45.32",
  "targetUnits": "Celsius"
}
