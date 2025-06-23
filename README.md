# Courses Management System

This is a full-stack web application developed as part of the IIT Bombay ASC Internship Assignment.  
It allows managing academic courses, their prerequisites, and course delivery instances across semesters.

---

##  Tech Stack

| Layer     | Technology                |
|-----------|---------------------------|
| Backend   | Java, Spring Boot, MySQL  |
| Frontend  | Next.js (React), Tailwind CSS |
| API Calls | Axios                     |
| DevOps    | Docker, Docker Compose    |

---

##  Features

###  Backend (Spring Boot)
- REST APIs to create, list, and delete courses
- Supports prerequisites (Many-to-Many relationship)
- Validation to prevent deleting courses that are used as prerequisites
- API to create and fetch course delivery instances (year + semester)

###  Frontend (Next.js)
- View all courses and their prerequisites
- Create new courses and select prerequisites
- Add course instances (year, semester, course)
- View instances for a given semester

---

##  Docker Setup

This project is fully containerized using Docker. You can run both frontend and backend using Docker Compose.

---

###  DockerHub Images

- **Backend**: [meghanaa11/courses](https://hub.docker.com/r/meghanaa11/courses)
- **Frontend**: [meghanaa11/courses-frontend](https://hub.docker.com/r/meghanaa11/courses-frontend)

---
###  docker-compose.yml

```yaml
version: '3'
services:
  backend:
    image: meghanaa11/courses
    ports:
      - "8087:8080"

  frontend:
    image: meghanaa11/courses-frontend
    ports:
      - "3000:3000"
