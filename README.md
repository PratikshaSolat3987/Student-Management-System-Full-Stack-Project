# Student-Management-System-Full-Stack-Project
The Student Management System (SMS) is a web application designed to manage student data efficiently. It allows administrators to perform CRUD operations (Create, Read, Update, Delete) on student records, including details such as first name, last name, email, phone number, and enrollment date.
# Angular19 Project Set Up
### Prerequisites
  * Node.js (v20 or later)
  * Angular CLI: npm install -g @angular/cli@19
  * Spring Boot 3.4.4 backend running at http://localhost:8080/students
  * Maven (for backend CORS configuration, if needed)
### Setup Commands
```
# Create new Angular project
ng new student-management --style=css --routing=true --standalone=true
cd student-management

# Install Bootstrap 5.3.5
npm install bootstrap@5.3.5

# Generate components
ng generate component components/student-list
ng generate component components/student-form
ng generate component components/student-detail

# Generate service
ng generate service services/student

# Generate model
ng generate interface models/student
```

### Update `angular.json`
Add Bootstrap to `angular.json` under `projects.student-management.architect.build.options`:

```.json
"styles": [
  "node_modules/bootstrap/dist/css/bootstrap.min.css",
  "src/styles.css"
],
"scripts": [
  "node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"
]
```
## CORS Configuration (Spring Boot)
Ensure your Spring Boot backend allows requests from http://localhost:4200. Add this to your Spring Boot application:

```.java
package com.example.StudentManagementSystem.Full.Stack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}
```
# Angular Project Directory Structure
```
APP/
├── ngApp/
│   ├── .angular/            # Webpack & Babel configs
│   ├── .vscode/
│   ├── node_modules/        # Dependencies
│   ├── src/                 # Application source code
│   ├── angular.json         # Angular config
│   ├── package.json         # Project metadata & dependencies
│   ├── tsconfig.json        # TypeScript config
│   └── README.md
```


## Inside `src/app`

```
src/app/
├── app.component.css        # Styles
├── app.component.html       # Template
├── app.component.ts         # Component logic
├── app.component.spec.ts    # Unit tests
└── app.config.ts            # Configuration
```



# Postman Testing Results

