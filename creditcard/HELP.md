# Getting Started

### Details of the Application

As per the requirement,
1. A Spring Boot Application is created to perform some operations on Credit card information. The application contains 2 endpoints
    1. A POST endpoint to save the credit card information. (Please refer CreditCardApi.java for more details)
    2. A GET endpoint which returns all the credit cards in the system. (Please refer CreditCardApi.java for more details)
2.Derby database is used as an in-memory DB to store the information. (Please check pom.xml file for dependency details)
3. Unit testcases are written and full coverage is met. (Please check test package)
4. Luhn 10 check is used to validate the credit card number. (Please check CreditCardValidator.java)
5. Invalid requests and Duplicate requests are handled (Please check CreditCardControllerAdvice.java)


### How to run the Application
1. File CreditcardApplication.java is the starting point of the application. Right click and run the application.
2.Please use the below curls to insert data:
   curl --location --request POST 'http://localhost:8080/cards' \
   --header 'Content-Type: application/json' \
   --data-raw '{
   "name":"kdnjkgnjfkjnds",
   "number":"3243453365475652642",
   "limit":100034000
   }'
   
3. Please use the below curl to get the data:
   curl --location --request GET 'http://localhost:8080/cards' \
   --header 'Content-Type: application/json'
   