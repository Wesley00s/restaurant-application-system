# Restaurant Management System

Welcome to the Restaurant Management System repository! This project is a Java application based on Spring Boot, using PostgreSQL as the database to create a REST API for restaurant management. The system includes essential classes to model the structure of a restaurant, such as Client, Eating Table, Employee, Ingredient, Item, and Request.

## Prerequisites

Make sure you have the following tools installed before running the system:

<p align="center">
   <a alt="Java">
      <img src="https://img.shields.io/badge/Java-v21-blue.svg" />
  </a>

  <a alt="Spring Boot">
      <img src="https://img.shields.io/badge/Spring%20Boot-v3.0.4-brightgreen.svg" />
  </a>
   <a alt="Maven">
      <img src="https://img.shields.io/badge/Maven-v3.9.6-blue.svg" />
  </a>
  <a alt="Postgres">
      <img src="https://img.shields.io/badge/Postgres-v16.2-blue.svg" />
  </a>
  <a alt="Flyway">
      <img src="https://img.shields.io/badge/Flyway-v9.5.1-red.svg">
  </a>
</p>

## Database Configuration

PostgreSQL is used as the database to store system data. Before running the application, create a database named `restaurant_application_system_db` and adjust the connection settings in the `application.yml` file.   
    
  ```yml
  spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/restaurant_application_system_db
       username: postgres
       password: 123456
