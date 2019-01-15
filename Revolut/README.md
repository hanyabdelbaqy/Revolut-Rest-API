# Money transfer Rest API
########################################
A Java RESTful API for money transfers between two accounts
########################################
Assumtions:
- Assume that all Accounts with the same currency
########################################
### Technologies
- Java JAX-RS API
- Apache HTTP Client
########################################
### Tools
- eclipse 
- Apache Tomcat 7
- Maven
########################################
### How to run
- At the first, you need to create run configure from eclipse:
- Steps:
1- from Run menu, select Run Configurations...
2- set Name: as you like(ex: Revolut)
3- set Goals: tomcat7:run
4- press Apply
5- press run
########################################
Application starts a Tomcat server on localhost port 8080
- http://localhost:8080/Revolut/rest/accounts
- http://localhost:8080/Revolut/rest/accounts/getAcctByNo
- http://localhost:8080/Revolut/rest/accounts/addAcct
- http://localhost:8080/Revolut/rest/accounts/transaction

### Available Services

| HTTP METHOD | PATH | USAGE |
| -----------| ------ | ------ |
| GET | /accounts| get All Exist Accounts | 
| POST | /getAcctByNo | get Account by its Number  | 
| POST | /addAcct | Add New Account if needed | 
| POST | /transaction | perform transaction between 2 user accounts | 
### Http Status
- 200 OK: The request has succeeded
- 400 Bad Request

### Sample JSON for Add Account and Transaction
##### get Account By No: 
{
"acctNo":"Acct01"
}
##### Add Account: 
{
"acctNo": "Acct06",
"acctName": "HMA Acct",
"balance": 1200
 }
##### Transaction:
{
"fromAcctNo":"Acct01",
"toAcctNo":"Acct02",
"amount":500
}
########################################

