# Student-Management-System-Full-Stack-Project
The Student Management System (SMS) is a web application designed to manage student data efficiently. It allows administrators to perform CRUD operations (Create, Read, Update, Delete) on student records, including details such as first name, last name, email, phone number, and enrollment date. Built using Java, Spring Boot, PostgreSQL, JPA, and REST API for the backend, and HTML, CSS, JavaScript, TypeScript, and Angular for the frontend.
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
![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/3c48ac27d787dca36978215fa4144bc27302edd7/2025-04-20%20(6).png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/231b29b2fe26677e04d47054920bacace91e68ef/2025-04-20%20(7).png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/231b29b2fe26677e04d47054920bacace91e68ef/2025-04-20%20(8).png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/231b29b2fe26677e04d47054920bacace91e68ef/2025-04-20%20(9).png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/231b29b2fe26677e04d47054920bacace91e68ef/2025-04-20%20(10).png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/231b29b2fe26677e04d47054920bacace91e68ef/2025-04-20%20(11).png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/231b29b2fe26677e04d47054920bacace91e68ef/2025-04-20%20(12).png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/231b29b2fe26677e04d47054920bacace91e68ef/2025-04-20%20(13).png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/231b29b2fe26677e04d47054920bacace91e68ef/2025-04-20%20(14).png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/231b29b2fe26677e04d47054920bacace91e68ef/2025-04-20%20(15).png)



# FrontEnd Result (Angular19)

![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/82bc0083b6a9d8e80f98585a0faf267b377b81b2/Screenshot%202025-04-22%20183753.png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/82bc0083b6a9d8e80f98585a0faf267b377b81b2/Screenshot%202025-04-22%20183914.png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/cfafae1e847ae76ef3365611a4993816d1c1281d/Screenshot%202025-04-22%20183937.png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/cfafae1e847ae76ef3365611a4993816d1c1281d/Screenshot%202025-04-22%20183953.png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/cfafae1e847ae76ef3365611a4993816d1c1281d/Screenshot%202025-04-22%20184019.png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/cfafae1e847ae76ef3365611a4993816d1c1281d/Screenshot%202025-04-22%20184055.png)


![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/f4610333901c08e8ca84ab969299eee17a58ec85/Screenshot%202025-05-01%20111647.png)


# Database 
![image alt](https://github.com/PratikshaSolat3987/Student-Management-System-Full-Stack-Project/blob/52f03983bbc89e20a826895e8b903a57c930b6da/Screenshot%202025-05-01%20110117.png)













