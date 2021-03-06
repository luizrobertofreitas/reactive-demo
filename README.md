# reactive-demo

This README would normally document whatever steps are necessary to get the
application up and running.

Things you may want to cover:

* Description
  It is a sample implemented with Spring Boot (Webflux, R2DBC, Actuator and Netty)

* Java Version: 11

* System dependencies
  - Spring [Webflux, R2DBC, R2DBC Postgres Driver, Data]

* Configuration
  - All needed configuration is in the application.yml file

* Database creation
  - Setup the postgres using the docker, as follows:
    ```
    docker run --name postgres -e POSTGRES_PASSWORD=123456 -p 5432:5432 -d postgres
    ```
  - Logs into the pod
    ```
    docker exec -it postgres bash
    ```
  - Postgresql cli. (If asked, the password is: 123456)
    ```
    psql -U postgres
    ```
  - Create the database:
    ```
    create database library;
    ```

* Database initialization
  I forgot to configure the flyway, so, enter into postgres cli as the previous section and:
  
  - Logs into the pod
    ```
    docker exec -it postgres bash
    ```
  - Postgresql cli. (If asked, the password is: 123456)
    ```
    psql -U postgres -d library
    ```
  - Copy and paste the script books.sql that is located inside the project:
    ```
    create table books (id bigserial, title varchar, author varchar, created_at timestamp, primary key(id));
    ```
* Run the application
  ```
  gradle bootRun
  ```

* How to run the test suite
  - Create a Book
  ```
  curl --location --request POST 'http://localhost:8080/books' \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "title": "Some Title",
      "author": "John Doe"
  }'
  ```
  
  - Get all Books
  ```
  curl --location --request GET 'http://localhost:8080/books'
  ```
  
  - Get book by Id
  ```
  curl --location --request GET 'http://localhost:8080/books/1'
  ```
  
  - Update book
  ```
  curl --location --request PUT 'http://localhost:8080/books' \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "id": 3,
      "title": "Production Ready Microservices",
      "author": "Susan J. Fowler"
  }'
  ```
  
  - Delete book
  ```
  curl --location --request DELETE 'http://localhost:8080/books/1'
  ```
