Our microservice architecture has a service to create and manage products.
We now would like to add another microservice that offers search and filter capabilities for products.
To quickly provide a working endpoint to our frontend team, we agreed on the following details.

----------------------------------------------------------------------------
Read Data from a database, of your choice. Use Docker to set up the database
----------------------------------------------------------------------------

The service should connect to database store, where it can read products with the following structure:
{
"id": 1,
"name": "Product A",
"price": 12.99,
"brand": "Brand A",
"onSale": true
}

Pre-load database with at least 10 products.

------------------
Expected Response
------------------
Our Frontend Team expects a response matching the following requirements

All products are returned
Products are grouped by brand, sorted alphabetically
Property brand should be omitted on products
Products inside a brand should be sorted ascending by price
Property onSale should be converted to a property event of type String with the value "ON SALE"
{
"Brand A" : [{
"id": 1,
"name": "Product A",
"price": 12.99,
"event": "ON SALE"
},
{
"id": 2,
"name": "Product B",
"price": 7.99
}],
"Brand B" : [{
"id": 3,
"name": "Product C",
"price": 14.99
},
{
"id": 4,
"name": "Product D",
"price": 10.99
}]
}

------------------
Technical Requirement
------------------
We expect:

A Scala based solution, ideally Akka-http
That has a Docker container ready to run
with tests verifying the given requirements
and a versioned code base
Freedom of Tools and Technology

You need to implement these two tasks in two separate microservices.

Required artifacts:

Code with test cases.
Readme.md file for installation and running.
Dockerfile or/and Docker Compose
API Documentation. (Swagger would be nice to have).
A postman collection to test all implemented API Endpoints (Would be nice to have)
