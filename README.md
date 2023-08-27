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
* Day 1: 2 hours
  * Studying requirements and analysis
  * Technology selection
  * Model design
  * DB initial

* Day 2: 2 hours
  * API design
  * Dev env setup
  * API development

* Day 3: 3 hours
  * Persistence layer design, development, testing, fixing bugs
  
* Day 4: 4 hours
  * API testing, fixing bugs
  * UI template selection
  * List page, detail page UI and UX design, development, fixing bugs
  
* Day 5: 4 hours
  * List page, detail page UI and UX design, development, fixing bugs
  * Function testing, fixing bugs

* Day 6: 5 hours
  * Function testing, fixing bugs
  * Data validation
  * Function testing, fixing bugs
  
* Day 7: 5 hours
  * Data validation, fixing bugs
  * Data initial
  * Publish to cloud server (AWS)
  * Documentation