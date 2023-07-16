# Instagram-API
This project is an Instagram clone API built using Spring Boot and Java. It provides endpoints to handle user authentication, user profile management, and creating and retrieving posts.

## API Endpoints
## User Authentication
### POST /api/user/signin
Signs in an existing user. Expects a JSON object with the following properties:
- **email:** The user's email address
- **password:** The user's password
Returns an authentication token on success.

### POST /api/user/signup
Creates a new user account. Expects a JSON object with the following properties:
- **firstName:** The user's first name
- **lastName:** The user's last name
- **email:** The user's email address
- **password:** The user's password
- **phoneNumber:** The user's phone number
- **age:** The user's age
Returns an authentication token on success.

### PUT /api/user/update/{id}
Updates an existing user's profile. Expects a JSON object with the following properties:
- **firstName:** The user's new first name
- **lastName:** The user's new last name
- **email:** The user's new email address
- **phoneNumber:** The user's new phone number
- **age:** The user's new age

## Posts
### POST /api/posts/
Creates a new post. Expects a JSON object with the following properties:
- **postData:** The content of the post
- **user:** An object representing the user who created the post, with the following properties:
- **id:** The ID of the user

## GET /api/posts/{id}
Retrieves a specific post by ID. Returns a JSON object with the following properties:
- **id:** The ID of the post
- **createdDate:** The date the post was created
- **updatedDate:** The date the post was last updated
- **postData:** The content of the post
- **user:** An object representing the user who created the post, with the following properties:
- **id:** The ID of the user
- **firstName:** The user's first name
- **lastName:** The user's last name
- **age:** The user's age

## Built With
- Spring Boot
- Java
- Maven
- MySql
- Lombok

## Project Summary:
This is a simple Instagram API project with basic CRUD operations for users and posts. It uses MySQL for the database and is implemented using Spring Boot.
