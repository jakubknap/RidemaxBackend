# Ridemax Shop
> This is a fullstack online store project. The application includes the basic functions of an online store, as well as those that are a bit more advanced.  There is integration with a payment gateway in this application, sending emails and much more.

The application in a nutshell has such functionalities:

On the administrative side:
- Add, edit and delete products.
- Add, edit and delete categories
- Order management, including exporting orders to CSV file and viewing sales statistics in the form of a chart
- Moderation of user reviews (approval, deletion)

From the user side:
- Viewing products
- Searching for products by category
- Creating orders (adding products to cart, deleting, ordering)
- Adding product reviews 
- Viewing the list of your orders
- Email notifications

In a nutshell, this is the outline of the application. There is also a mechanism for registration, login and password reminders.

## Table of Contents
* [Technologies Used](#technologies-used)
* [Screenshots](#screenshots)
* [Setup](#setup)
* [API](#api)
* [Contact](#contact)

## Technologies Used
- Java 17
- Spring Boot 3
- Spring Security 6
- JWT Token Authentication
- Spring Data JPA
- JSR-303 and Spring Validation
- OpenAPI and Swagger UI Documentation
- Docker

## Screenshots

## Setup
0. **Before starting:** You must have docker installed and running

1. Clone the repository:
```bash
git clone https://github.com/jakubknap/RidemaxBackend.git
```

2. Go to the project directory and start the containers with the command:
```bash
docker compose up -d
```

2. Run the application
```bash
mvn spring-boot:run
```

## API
- You can check the functionality of the backend itself using swagger: http://localhost:8080/swagger-ui.html  Important! Remember about authentication
- The client application runs on localhost:8080.  The administrative application is available at localhost:8080/admin
- Default login to admin website: login: admin, password: test

## Contact
Created by [Jakub Knap](https://www.linkedin.com/in/jakub-knap/) - feel free to contact me!

