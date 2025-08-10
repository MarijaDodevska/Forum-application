# DevOps

This is simple CRUD application for the purpose of the course **Continouos Integration and Delivery** at Faculty of Computer Science and Engineering. 

## 1. Hosting a public git repository
Using the following commands, a new git repository is initialized where all the files from the application are added in the first commit “First commit".

![Image Alt Text](https://github.com/MarijaDodevska/Forum-application/blob/main/screenshots/firstcommit.png)
![Image Alt Text](https://github.com/MarijaDodevska/Forum-application/blob/main/screenshots/git%20push.png)

## 2. Dockerizing the application
Dockerfile that defines how the application is built:
![Image Alt Text](https://github.com/MarijaDodevska/Forum-application/blob/main/screenshots/Dockerfile.png)

Base Image: Select a base Docker image on which to build the application.
Copy Code: Copy the application source code into the container.
Install Dependencies: Run commands to install required libraries or dependencies.
Set Configurations: Configure ports and change application parameters.

Command to build the image:
![Image Alt Text](https://github.com/MarijaDodevska/Forum-application/blob/main/screenshots/Docker%20image.png)

Docker run:
![Image Alt Text](https://github.com/MarijaDodevska/Forum-application/blob/main/screenshots/docker%20run.png)

![Image Alt Text](https://github.com/MarijaDodevska/Forum-application/blob/main/screenshots/docker%20images.png)
![Image Alt Text](https://github.com/MarijaDodevska/Forum-application/blob/main/screenshots/docker%20ps.png)

## 3. Orchestration with Docker Compose
A docker-compose.yml is created where the tasks to be executed are defined, including the application.
![Image Alt Text](https://github.com/MarijaDodevska/Forum-application/blob/main/screenshots/docker-compose.yml.png)

Build and Run the application with Docker Compose:
![Image Alt Text](https://github.com/MarijaDodevska/Forum-application/blob/main/screenshots/docker%20compose.png)

## 4. CI pipeline with GithubActions:
Setting Secret Variables:

![Image Alt Text](https://github.com/MarijaDodevska/Forum-application/blob/main/screenshots/secret%20variables.png)

This pipeline will build a Docker image, run tests, and upload the Docker image to DockerHub when the code is pushed to the repository.

![Image Alt Text](https://github.com/MarijaDodevska/Forum-application/blob/main/screenshots/pipeline.png)

Result of pipeline execution:

![Image Alt Text](https://github.com/MarijaDodevska/Forum-application/blob/main/screenshots/results.png)
