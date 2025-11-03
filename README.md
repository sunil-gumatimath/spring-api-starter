# Store API - Spring Boot Application

A comprehensive e-commerce store API built with Spring Boot, featuring user management, product catalog, and wishlist functionality.

## 🚀 Features

- **User Management**: Complete CRUD operations for users with profiles and addresses
- **Product Catalog**: Browse products with category filtering
- **Wishlist System**: Users can add products to their wishlist
- **RESTful APIs**: Well-structured REST endpoints
- **Database Integration**: MySQL with JPA/Hibernate
- **Database Migration**: Flyway for version control
- **Data Transfer Objects**: Clean separation with DTOs and MapStruct mappers

## 🛠️ Tech Stack

- **Framework**: Spring Boot 3.4.1
- **Language**: Java 23
- **Database**: MySQL
- **ORM**: Spring Data JPA / Hibernate
- **Migration**: Flyway
- **Mapping**: MapStruct
- **Build Tool**: Maven
- **Utilities**: Lombok

## 📋 Prerequisites

Before running this application, make sure you have:

- Java 23 or higher
- Maven 3.6+
- MySQL 8.0+
- Git

## 🔧 Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/spring-api-starter.git
   cd spring-api-starter
   ```

2. **Configure MySQL Database**
   - Create a MySQL database named `store_api`
   - Update database credentials in `pom.xml` (Flyway configuration) if needed:
     ```xml
     <url>jdbc:mysql://localhost:3306/store_api?createDatabaseIfNotExist=true</url>
     <user>root</user>
     <password>MyPassword!</password>
     ```

3. **Run Database Migration**
   ```bash
   mvn flyway:migrate
   ```

4. **Build the application**
   ```bash
   mvn clean compile
   ```

5. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`

## 📚 API Endpoints

### Users
- `GET /users` - Get all users (supports sorting by name/email)
- `GET /users/{id}` - Get user by ID
- `POST /users` - Create new user

### Products
- `GET /products` - Get all products
- `GET /products?categoryId={id}` - Get products by category

### General
- `GET /hello` - Simple hello world endpoint
- `GET /` - Home page

## 🗄️ Database Schema

The application uses the following main entities:

- **Users**: User accounts with authentication
- **Addresses**: User addresses (one-to-many with users)
- **Products**: Product catalog with categories
- **Categories**: Product categories
- **Profiles**: Extended user information
- **Wishlist**: User favorite products (many-to-many)

## 🏗️ Project Structure

```
src/main/java/com/codewithmosh/store/
├── controller/          # REST controllers
├── entities/           # JPA entities
├── dtos/              # Data Transfer Objects
├── mappers/           # MapStruct mappers
├── repositories/      # Spring Data repositories
└── StoreApplication.java
```
