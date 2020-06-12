# roomData
This project is a REST API, generated using spring initializr. The project is a maven project and is initialized with Java 8, and spring boot version 
used while creation of this project is: 2.3.1

## Building the project
After cloning the project files to your designated directory you can buld the project into jar file. To do the same, go to command line and
set the current directory to the directory where the project is located. Once done, run the command: `mvn install`. A new folder named 
`target` will be generated and inside the folder, a jar file for our project will be created.

## Project Specifications
The project contains an inbuilt h2 database. The `schema.sql` file will generate schema for rooms table and room images table. `data.sql`
will insert some dummy data inside rooms table. The following endpoints can be used:
* <your domain>/rooms             : Get request will fetch you list of room objects
* <your domain>/rooms             : Post request along with a new room object as a part of request body will add a new room to database.
* <your domain>/rooms/{id}        : Get request to get a room object based on its id
* <your domain>/roomImages        : Get request will fetch you list of room images present in database.
* <your domain>/roomImages/upload : Post request along with a multipart file as a part of request parameter `imageFile` will store image
into database.
* <your domain>/roomImages/{id}   : Get request will download the image on the basis of it's id.
