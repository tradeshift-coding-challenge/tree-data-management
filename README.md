
# Pre-requisite 
## MySQL docker container set up:
   docker run -d -p 3306:3306 --name tradeshift-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=tradeshift mysql:latest 
## Test Data Setup: 	 
   Execute db script Datasetup.sql	 
## Only after step A & B is complete  
   docker run -d -p 8000:8000 --name tree-data-mangement --link tradeshift-mysql:mysql -d tradeshiftcodingchallenge/tree-data-management
## Swagger
   http://54.67.48.226:8000/swagger-ui.html#

## Closure table Concept
   To store hierarchic structures in a relational database.  
   Used two tables. 
   The first table will store basic information, while the second stores the connections between entities (ancestor-descendant relations).


