# Getting Started

### How to build and run the application

* Create the DB by referring src/main/resources/application.properties where you can find the DB info
* Create the data tables by referring src/main/resources/db/DDL.sql
* Data initial. There are two ways to init the data:
  * Manually initial, before starting the application, running db/DML.sql 
  _OR_
  * Automatically initial, after starting the application
    * Access http://localhost:8964/sms/data/initial (It should be 'PUT', but I choose 'GET' for your convenience)
    *Warning:* **this way will remove all existing data**
* Access http://localhost:8964/sms, on the landing page
  * Click 'Get Started' to enter the Mini-SMS system
  * Click 'API' to nav to the API page
  


### Development logs
* 