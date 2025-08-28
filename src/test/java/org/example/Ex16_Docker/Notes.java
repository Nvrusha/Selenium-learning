package org.example.Ex16_Docker;

public class Notes {

    /*
     ======================
      DOCKER NOTES FOR TESTING
     ======================

     # 1. What is Docker?
     - Docker is a containerization platform.
     - It allows us to package applications with dependencies into containers.
     - Containers = lightweight virtual machines that run the same way across environments.

     # 2. Why Docker in Automation Testing?
     - To run Selenium Grid in containers (Hub + Nodes).
     - Easy cross-browser testing (Chrome, Firefox, Edge, etc. in isolated containers).
     - Removes "it works on my machine" problem → consistency.
     - Saves setup time → no need to install browsers/driver manually on each machine.
     - Parallel execution support.

     # 3. Docker vs VM
     - VM → Heavy, includes full OS per VM.
     - Docker → Lightweight, shares host OS kernel, much faster.

     # 4. Key Components
     - Image → Blueprint for container (e.g., selenium/standalone-chrome).
     - Container → Running instance of an image.
     - Docker Hub → Public repo to pull images (like GitHub for code).
     - Dockerfile → Instructions to build custom image.
     - Docker Compose → YAML file to define/run multi-container apps.

     # 5. Common Commands
     - docker --version              → Check Docker version.
     - docker pull <image>           → Download an image.
     - docker images                 → List images.
     - docker run <image>            → Run container from image.
     - docker ps -a                  → List containers.
     - docker stop <container_id>    → Stop container.
     - docker rm <container_id>      → Remove container.
     - docker rmi <image_id>         → Remove image.
     - docker-compose up -d          → Run containers in background (from docker-compose.yml).
     - docker-compose down           → Stop & remove containers.

     # 6. Selenium with Docker
     - Use official Selenium images (https://hub.docker.com/u/selenium).
       Example: selenium/hub, selenium/node-chrome, selenium/node-firefox.
     - Or use selenium/standalone-chrome (Hub + Node in one container).
     - Selenium Grid with Docker allows parallel execution across browsers easily.

     # 7. Docker in CI/CD
     - Jenkins/GitHub Actions can spin up Selenium Grid containers on demand.
     - Ensures clean environment for every test run.

     # 8. Docker Desktop on Windows 11
     - Needs WSL2 backend (Windows Subsystem for Linux).
     - Two download options:
         a) Docker Desktop for Windows (x86_64) → For Intel/AMD CPUs.
         b) Docker Desktop for Windows (ARM64)  → For ARM-based CPUs.

     # 9. ARM
     - ARM is a processor architecture (used in Apple M1/M2, some laptops).
     - If you have Intel/AMD → Download x86_64 version of Docker Desktop.
     - If you have ARM chip → Download ARM version.

     ======================
    */

}
