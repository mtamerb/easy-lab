# Project Installation and Running

- I deployed to Heroku, it can be accessed.
Project live : https://tamerb-lab.herokuapp.com

## Requirements:
Tech:
- Maven v.3.8.6
- Java 8
- Mysql v.8.30

For Database:
- Create "labdb" schema in MySQL
- Change default value with your mysql username and password in the application properties file
    - path : easy-lab/src/main/resources/application.properties
    - default : username = root password = mysql

## Installation
1-Clone this repo 
```sh
git clone https://github.com/mtamerb/easy-lab.git
```
2-Then navigate to the path where the easylab project is located in the Terminal
```sh
cd easy-lab
```
3-Create Jar file for the project
```sh
mvn package
```
4-Then go easy-lab target folder
```sh
cd target
```
## Running
5-Run Jar project file
```sh
java -jar easylab-0.0.1-SNAPSHOT.jar
```

### Go to localhost:8080 in the browser.





