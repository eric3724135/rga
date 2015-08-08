RGA Customer Module
===================
##Api Example  
I was deployed to my nas  
http://pen.diskstation.me:7070/rga-customer/{action}  

1.Get Credential   
http://pen.diskstation.me:7070/rga-customer/login  
POST action which set Header with  Content-Type "application/json" and the admin content  
{ "id": "99", "name": "admin", "email": "admin@google.com", "password": "admin" }  
return  
{ "state": "200", "info": "success login", "email": "admin@google.com" }  
  
2.Listing all customers  
http://pen.diskstation.me:7070/rga-customer/customer/list  
GET action you can get All customer  
return  
[ { "id": "1", "name": "Customer2", "email": "Customer8@google.com", "password": "Customer8" }, { "id": "2", "name": "Customer2", "email": "Customer2@google.com", "password": "Customer2" },...]  
  
3.Creating a single customer  
http://pen.diskstation.me:7070/rga-customer/customer/  
POST action which set Header with  Content-Type "application/json" and the new customer content  
{ "id": "8", "name": "Customer8", "email": "Customer8@google.com", "password": "Customer8" }  
return  
{ "id": "8", "name": "Customer8", "email": "Customer8@google.com", "password": "Customer8" }  
  
4.Updating a single customer  
http://pen.diskstation.me:7070/rga-customer/customer/{cusId}  
http://pen.diskstation.me:7070/rga-customer/customer/1  
PUT action which set Header with  Content-Type "application/json" and the update customer content  
{ "id": "1", "name": "Customer2", "email": "Customer2@google.com", "password": "Customer2" }  
return no content  
  
5.Reading a single customer  
http://pen.diskstation.me:7070/rga-customer/customer/{cusId}  
http://pen.diskstation.me:7070/rga-customer/customer/1  
GEt action for get customer by id  
return   
{ "id": "1", "name": "Customer2", "email": "Customer2@google.com", "password": "Customer2" }  
  
6.Deleting a single customer  
http://pen.diskstation.me:7070/rga-customer/customer/{cusId}  
http://pen.diskstation.me:7070/rga-customer/customer/1  
DELETE action for delete customer by id  
return no content  
  
7.Destroying a credential (system user logout)  
http://pen.diskstation.me:7070/rga-customer/logout  
GET action to logout  
return  
{ "state": "200", "info": "success logout", "email": null }  
  
##Scenario
An insurance company needs a system to manage their customer data.  A software engineering team is working on the story below.

*As a system user, I want to add new customer data into the system. After added, I can view a certain customer, and a customer list. Of course, I am also able to modify the data as well as remove it from the system.* 


##Instructions
You are required to provide the functions of:

1. Creating a single customer
2. Updating a single customer
3. Deleting a single customer
4. Reading a single customer
5. Listing all customers
6. Getting a credential (system user login; Assume that the system user is existing.)
7. Destroying a credential (system user logout)

Except for point 6, those end-points should be secured, which need a credential to access.

Please implement it in Java. Any frameworks are accepted.

##Acceptance criteria
1. RESTful APIs
2. JSON request and response
3. Evidence of a BDD/TDD approach
4. Clean, maintainable code adhering to SOLID principles

##What we look for
We are especially interested in how you structure your code. It should be fully testable and easy to be understood, extended and modified by others, and comply with the best object-oriented practices.

**Please push your source code to GitHub, Bitbucket or other source control platforms, and deploy it to a web server such as AWS or others.**

Good luck!
