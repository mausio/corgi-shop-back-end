Instructions for using the Back-end

Using it first time:
 Make sure the following bullet-points are installed and function:
  -  Docker
  -  Postman
  -  TablePlus

Starting the Back-End:
  - Type into the terminal "docker compose up" for starting docker
  - Start the application via the start-button
  - Make sure that the port for docker and the back-end are not used
  - When changes occurred to a file in the package "entity", change in applications.properties the value "spring.jpa.hibernate.ddl-auto=" from "update" to "create" ONCE,
    data in the Database will be deleted
  - When the application is started, and the Database is empty, use the endpoint "/saveCorgis" for saving corgis in the Database
  - Now Change the value "spring.jpa.hibernate.ddl-auto= in applications.properties back to "update"
  - Now you can use the endpoints

Using Postman:
  - Make sure that Postman is installed and function
  - Start Postman on the local machine (Desktop)
  - Open Postman on the Web, there you can test the endpoints with the following address:
    "http://localhost:8080/api/<INSERT ENDPOINT HERE>"
    example: "http://localhost:8080/api/corgis"

Using TablePlus:
  - Make sure that TablePlus is installed and function
  - Create a new Database (+Symbol) and pick PostgreSQL
  - Name the Database "Corgi-shop-app"
  - Username: corgiShopApp, Password: corgiShopApp, Database: corgiShopAppDB
  - Click "Save"


User-Credentials:
    - Username: niklas, Password: $2b$04$t2buI1Q2lpdNFCX3BuoKVetloTeQxJ.4UcGAMEOqftYYZmnz1aX62