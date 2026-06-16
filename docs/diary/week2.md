# Week 2: 6/8/26 - 6/14/26

# Phase 1: Authentication Continued
6/11/26
- Begun UserService.java class on
- Learned that a service class bridges the controller layer and data access layer
- HTTP Req --> Controller --> Service --> Repository --> Database
- Completed Persistence layer of phase 1:
    - created UserService and createUser() method
    - Added to TestController to test if new user would be inserted in Users table and connect to frontend
    - Everything worked
- Began register method to validate username, email, and password, and create password hash using Spring Security's BCryptPasswordEncoder (BCrypt password hashing method)

