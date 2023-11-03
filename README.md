# Spring Boot Blog Application

This is an ENTIRE application for Java Spring Boot using:
- Spring Data JPA
- H2 Database
- Thymeleaf
- Spring Security
- Model View Controller (MVC) architecture

**The original author walks through how to build this yourself on YouTube**: https://youtu.be/7iWlCl35p9o

## Development Instructions

- `git clone https://github.com/wazooinc/spring-boot-blog-application.git`
- `cd spring-boot-blog-application`
- open in favorite editor, or
- `mvnw spring-boot:run`
- open http://localhost:3000 and Blog away!

## Built-in Account and Constraints

- Login as a User with `user.user@domain.com` and password `password`
- Login as an Admin with `admin.admin@domain.com` and password `password`
- An **Anonymous** account can only `READ` Posts
- A **User** account can `CREATE, READ, UPDATE` Posts
- An **Admin** account can `CREATE, READ, UPDATE, DELETE` Posts

## LICENSE

MIT License