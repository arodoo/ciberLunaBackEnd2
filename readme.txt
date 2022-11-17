This is a "backend" application in spring boot, which gets the information from CiberLuna's 
database. It is made of 6 sub-folders: "rest", where is the main method, "controller", which 
containts the CRUD methods, "dao", an interface to get the methods using  dao, "entities" who
are database's tables and "exception", who handles personalized exceptions.
The connection is made on application.properties in "src/main/resources"