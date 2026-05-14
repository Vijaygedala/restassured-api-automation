# REST ASSURED - API automation framework
A reusable API automation framework built using Java, Rest Assured, TestNG, AssertJ, Extent Reports, Log4j2, and Docker.

This framework is designed to automate REST API testing with reusable utilities, centralized reporting, logging, and support for Docker execution.

# Project Features
* Reusable Request Builder
* CRUD Utility Methods
* POJO Serialization and Deserialization
* Dynamic Test Data Generation using Faker
* Extent HTML Reports
* Log4j2 Logging
* Thread Safe Reporting
* Custom Framework Annotations
* Parallel Execution Support
* Docker Support

```markdown
| Technology     | Purpose               |
| -------------- | --------------------- |
| Java           | Programming Language  |
| Rest Assured   | API Automation        |
| TestNG         | Test Execution        |
| AssertJ        | Assertions            |
| Extent Reports | Reporting             |
| Log4j2         | Logging               |
| Lombok         | Boilerplate Reduction |
| Faker          | Random Test Data      |
| Docker         | Containerization      |
```

# Framework Architecture

```
src
 ├── main
 │    └── java
 │          ├── annotations
 │          ├── constants
 │          ├── enums
 │          ├── listener
 │          ├── logger
 │          ├── pojo
 │          ├── reports
 │          ├── requestbuilder
 │          └── utils
 │
 ├── test
 │    ├── java
 │    │     └── tests
 │    │
 │    └── resources
 │          ├── config.properties
 │          └── jsons
 │
 ├── db.json
 ├── testng.xml
 └── pom.xml

```

# Initial Setup to run this framework using TestNG XML or Docker Image
Skip this setup if you want to run the framework against your own API by changing the base URL in config.properties.

**1.Download and install Node.js from:**

[Download Node.js](https://nodejs.org/)

Verify installation:

node -v

npm -v

**2.Install JSON Server using below command**

npm install -g json-server

**3.Setup Local Mock API Server**

Download the db.json file from the project.

Open Command Prompt in db.json Location

json-server --watch db.json

JSON server will start on: http://localhost:3000/employees 

Open the URL in browser to verify the data.

**4.The framework performs:**

GET,POST,PUT,DELETE operations on this API.

---
# Run Framework in Local System Using IDE
Clone or Download Project

Right click on: testng.xml 

Then select:Run As → TestNG Suite

After execution, reports will be available in: extent-test-output/index.html

Open index.html in browser to view the report.

---
# Run Framework Using Docker Image

**1.[Install Docker Desktop](https://www.docker.com/products/docker-desktop/)**

Verify installation: docker --version

**2.Pull Docker Image**

```bash
docker pull gedalavijay2001/apitestimage:latest
```

**3.Run Docker Container**

```bash
docker run --rm -v C:\docker-reports:/app/extent-test-output gedalavijay2001/apitestimage:latest
```
After execution, reports will be available in: C:\docker-reports

Open index.html in browser to view the report.

# Docker Command Explanation
```markdown
| Command            | Purpose                               |
| ------------------ | ------------------------------------- |
| docker run         | Runs container                        |
| --rm               | Removes container after execution     |
| -v                 | Maps local folder to container folder |
| extent-test-output | Stores reports                        |
| apitestimage       | Docker image name                     |

```
----
# Build Docker Image
```bash
docker build -t <imagename>:<tag> .
```
# Create docker image on top of a container (Base image)
```bash
docker commit <<containerid>>
docker tag <<container/image id>> <<newImageName>>
docker build -t <<newImageName>>
```

# Push image to docker hub
```bash
docker login
docker push <<imagename>>
```


# Author
**Vijay Gedala**

---

