#!/bin/bash
sudo mkdir -p /opt/auth-course-app/
cd /opt/auth-course-app/
sudo cp /vagrant/Dockerfile /opt/auth-course-app/
sudo docker cp 955c:/var/jenkins_home/workspace/auth-course-demo/part05/module01/projects/auth-course/target/auth-course-0.0.1-SNAPSHOT.jar /opt/auth-course-app/
sudo docker build -t luanmateuz/auth-course-app .
echo "=)"