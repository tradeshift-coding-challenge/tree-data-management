
# Pre-requisite 
## MySQL docker container set up:
   docker run -d -p 3306:3306 --name tradeshift-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=tradeshift mysql:latest 
## Test Data Setup: 	 
   Execute db script Datasetup.sql	 
## Only after step A & B is complete  
   docker run -d -p 8000:8000 --name tree-data-mangement --link tradeshift-mysql:mysql -d tradeshiftcodingchallenge/tree-data-management

# Git Hub
  tradeshift-coding-challenge / Temp@112019 
# Docker Hub
  tradeshiftcodingchallenge / Temp@112019
