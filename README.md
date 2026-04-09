Registration And Login System
Overview
A secure authentication system that was developed to manage user registration,credential validation and status reporting of login. The application adhere to rigid Object-Oriented. Security rubrics are determined by programming principles
Core Features
1. Registration Validation
   Username: Accepts the presence of underscore and a limit of 5 characters
   Password: Uses Regex to make it complex(Uppercase, Number,Special Character,8+ Length)
   Cell Phone: Assures South African international formatting(+27)
2. Authentication Logic
   Safe credential comparison to enable log-in
   Individualized greeting system based on registered user infomation
Technical Implementation
The system uses the java.util.regex to validate and the use of the java.util.Scanner. interactive console input
Unit Testing
The project contains a JUnit test suite ( LoginTest.java ) to ensure that all methods are tested.
deliver the right values of both the booleans and strings as set in the project requirements.
