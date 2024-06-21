# LB - NGINX - MS
## Description
Microservices infrastructure enabling the testing of a load balancer's functionality. This infrastructure consists of:
- A backend microservice built with Spring Boot
- A MySQL microservice ensuring data persistence
- An Nginx microservice serving as the load balancer
- A Prometheus microservice for collecting metrics from the various microservices

This project also includes a Python script for plotting mathematical functions representing HTTP requests processed by each microservice.
## Getting started
### Prerequisites
List all dependencies and their version needed by the project as :
- java V22.0.1+
- python V3.11.3+
- pip V23.2.1+
- Docker V26+
## Deployment
### IT
1. Edit /nginx/nginx.conf file to specify load balancing strategies ([LB Policies](https://www.f5.com/company/blog/nginx/choosing-nginx-plus-load-balancing-techniques))
2. This project is fully dockerized. To start it, simply run the following command:
```bash
docker-compose up -d
```
This will expose the following ports:
- **localhost:80**: Task API (see endpoints below)
- **localhost:9090** Prometheus
### Maths
1. Move to the "maths" folder
```bash
cd maths
```
2. Create python virtual environment
```bash
python -m venv env
```
3. Use python virutal environment
```bash
source env/bin/activate
```
4. Install dependencies
``` bash
pip install -r requirements.txt  
```
5. Launch script
```bash
python main.py
```
## API Endpoints
### 1. Get all tasks
- **Endpoint**: `/api/tasks`
- **Method**: GET
- **Description**: Get all created tasks
### 2. Get one task
- **Endpoint**: `/api/tasks/{id}`
- **Method**: GET
- **Description**: Get task by id
### 3. Create task
- **Endpoint**: `/api/tasks`
- **Method**: POST
- **Description**: Create task
- **Request Fields**:
  - `description`: Task description.
### 4. Update task
- **Endpoint**: `/api/tasks/{id}`
- **Method**: PUT
- **Description**: Update task by id
- **Request Fields**:
  - `description`: Task description.
  - `completed`: Defines whether the task is completed.
### 5. Toggle task
- **Endpoint**: `/api/tasks/{id}/toggle`
- **Method**: PATCH
- **Description**: Toggle completed field by id
### 6. Delete task
- **Endpoint**: `/api/tasks/{id}`
- **Method**: DELETE
- **Description**: Delete task by id

## Directory structure
```console
Tasks
├── maths               # Contains a python script to draw functions
├── nginx               # Contains nginx configration for docker
└── src                 # Contains tasks API source code
    ├── main            
    │    ├── java
    │    └── resources
    └── test            # Contains tasks API unit tests 
```
## Collaborate
### Commit Message Guidelines
To maintain clarity and consistency in our repository's history, we adhere to the following commit guidelines:
- **Descriptive Messages**: Ensure each commit message clearly describes the changes made.
- **Conventional Commits**: Follow the [Conventional Commits](https://www.conventionalcommits.org/) format, using types like `feat`, `fix`, `refactor`, `style`, `docs`, `test`, `chore`, etc.
### Branching Strategy
We use [Git Flow](https://nvie.com/posts/a-successful-git-branching-model/) as our branching strategy. Please create feature, hotfix, or release branches as appropriate and merge them back into the main branches as per Git Flow guidelines.
### Pull Requests
Open a pull request with a clear title and description for your changes. Link any relevant issues in the pull request description.
## License
This project is open source and available under the [MIT License].
