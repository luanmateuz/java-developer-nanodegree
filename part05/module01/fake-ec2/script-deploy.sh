#!/bin/bash
sudo docker run -d --publish 80:8080 --name auth-course-app luanmateuz/auth-course-app
echo ":D"