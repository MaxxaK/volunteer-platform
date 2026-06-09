# Week 1: 6/3/26 - 6/7/26

# Phase 0: Planning and Setup
- Created Github Repo, README.md, and .gitignore
- Organized project folders into backend, database, docs, and frontend
- Set up Spring Boot backend, downloading dependencies such as Spring Data JPA and Spring Security
- Set up React + Typescript frontend
- Set up PostgreSQL locally
- Connected and tested to make sure backend, frontend, and database were connected and working in sync

# Phase 1: Authentication
*Goal is to allow users to register an account with password hashing and storing information in a database*
- Created User.java using Spring Data JPA and Jakarta Persistence API.
    - A user has an ID, username, email, password, and the date the account was created
- Created Data Transfer Object (DTO) RegisterRequest.java with the same constructors, getters, and setters as user, which is necessary for Spring Data JPA
- Finally created a Repository interface that extends JPA's data handler to check if the username and email already exist in the database
- Thanks to the Spring Data JPA, Jakarta API, and Hibernate, simply running the program created a new database in PostgreSQL using the User.java class, titled Users
- Next step is to create a service class and implement registration logic
