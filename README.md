Features
The StudentDAO System handles CRUD (Create, Read, Update, Delete) operations for managing student information. It uses the following attributes to represent the Student entity:

ID: A unique identifier for each student.
First Name (fname): The student's first name.
Last Name (lname): The student's last name.
Email: The student's email address.
Mobile: The student's mobile number.
Project Components
The project includes the following components:

Student Class

This is a plain Java class (POJO) representing the student entity with the attributes:
id
fname
lname
email
mobile
It includes getter and setter methods to encapsulate the fields and ensure data integrity.
StudentDAO Interface

Defines the contract for CRUD operations, including:
insert(Student student): Adds a new student record to the database.
fetchAll(): Retrieves all student records.
fetchById(int id): Fetches a specific student's details by their ID.
update(Student student): Updates an existing student's information.
deleteById(int id): Deletes a student record based on the ID.
StudentDAOImpl Class

Implements the StudentDAO interface.
Contains actual database connectivity and SQL queries for performing operations.
Uses JDBC to connect to a relational database and handle transactions securely.
Database Connection Utility

A helper class to establish and manage database connections.
Encapsulates connection details, including the database URL, username, and password.
Main Class (for Testing)

A simple CLI or console-based interface to test the DAO methods.
Users can perform actions such as adding, retrieving, updating, or deleting student records.
How It Works
1)Insert a Student
Users can create a new student entry by providing the necessary details (ID, first name, last name, email, and mobile). The system validates the input and inserts the data into the database.

2)Retrieve All Students
Displays a list of all students currently stored in the database, including their ID, name, email, and mobile number.

3)Fetch a Specific Student
Retrieves details of a student using their unique ID.

4)Update Student Information
Allows modifications to an existing student's details. Users specify the student ID and provide the updated data.

5)Delete a Student
Deletes a student record based on their ID.

Benefits of Using DAO Pattern
Separation of Concerns: Keeps the database operations isolated from the application logic.
Maintainability: Makes it easier to update or replace database logic without affecting other parts of the system.
Reusability: DAO methods can be reused across multiple applications or modules.
Scalability: The pattern supports future enhancements, such as integrating new databas technologies or adding more entities.

Technology Stack
Programming Language: Java
Database: MySQL (or any relational database of your choice)
Database Connectivity: JDBC
Build Tool: Maven (optional for dependency management)

How to Run
Clone the repository.
Set up the database using the provided SQL script.
Configure the database connection in the DBConnection class.
Run the Main class to interact with the system.
