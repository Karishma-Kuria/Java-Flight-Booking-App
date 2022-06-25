### Problem Statement:

#### You will build a flight booking application using at least three design patterns. The application should maintain an internal, static database (inventory of flight details) (this may be developed using Hash Map’s and/or other built-in Java Data structures). 
This means once we re-run the program, the changes to the data would not persist. We will provide the data that have to be maintained.

### Commands to run Project:
1.	Clone the code from https://github.com/gopinathsjsu/individual-project-Karishma-Kuria/edit/main/README.
2.	Once the code is cloned in your local system, Open the command prompt and navigate to the directory where the pom file is located.
3.	Run the below commands in the given sequence:
4.	mvn compile
5.	mvn clean install
6.	Execute the below maven command with arguments which are the paths to the below files:
mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args="<arg1> <arg2 > <arg3> <arg4>"

    1.	arg1 – path to the input file (Sample.csv)
    2.	arg2 – path to flight details to populate DB (flights.csv)
    3. arg3 – path to Output.csv (Output file)
    4. arg4 – path to Output.txt (Error file)

 ### Design Pattern Used:
  
 1. Singleton: Since it’s a creational design pattern which makes sure that only one instance of the class is used which has global access. In our case, there is only 1 database which holds the flight details and is static so singleton pattern fits perfectly here. In the entire process wherever we need the database instance getInstance() will be called which will have a global access and can be reused.
![image](https://user-images.githubusercontent.com/91119374/167080931-ef79cbc1-0839-48e2-8ec3-e95e916b2801.png)

 
 2. Chain of Responsibility: This design pattern is a behavioral design pattern which  
uses multiple handlers to process the request. The request is transferred between the handlers in the chain based on the implementations inside the handlers.
I have used this design pattern to do the following:
•	Validate if the requested flight exists.
•	Validate if requested seat exists.
•	Validate if the card number is valid based on the rules provided in the problem statement.
The following files are used as part of the implementation:
 ![image](https://user-images.githubusercontent.com/91119374/167080999-54602635-76b8-42b3-a6ff-6f8e6587382a.png)

  3. Factory Pattern: This is a creational design pattern which is used to create objects in superclass providing subclasses the ability to alter the type of object to be created.
Since in this case there are 2 types of files are created as the output which is the output csv containing the confirmation details once the booking is done and the other is the output.txt which contains the errors encountered when making an invalid request. So, I have implemented factory pattern using OutputFile interface which contains methods to write to a file and save the file at a given location. This interface is implemented by CheckOutFile and ErrorFile. 
![image](https://user-images.githubusercontent.com/91119374/167081038-c4edcd07-0a6e-4a20-8783-3090dac38ecf.png)

Class diagram
![image](https://user-images.githubusercontent.com/91119374/167081195-1a6e9fde-afa7-4b82-9462-ad2104007e63.png)


 


  
