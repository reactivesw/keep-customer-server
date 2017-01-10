# customer_server

## 1. Introduction
this project use following technology:
* gradle 3.1 
* spring boot 
* spring data jpa
* postgresql 9.6
* swagger
* java 8

## 2. how to run
### 2.1 install jdk 1.8

### 2.2 install postgresql 
download [postgresql 9.6](https://www.postgresql.org/) and install it, set the password to `root`,

#### 2.2.1 connect to postgres database
run following command in terminal to config psql:

`export PATH=/Library/PostgreSQL/9.6/bin:$PATH`

use `psql` to connect postgres database by following command:

`psql -U postgres -h 127.0.0.1 -p 5432`

and input password

#### 2.2.2 create database
use command 

`create database reactivesw;` 

to create a new database name `reactivesw`.

ps: database password `root` and database name `reactivesw` can be changed to other words,
but you need to change the config on `application.yaml`.

#### 2.2.2 drop database
if you need to drop database, connect to `postgres` by command 

`\c postgres;` 

and use command 

`drop database reactivesw;` 

to drop database.

### 2.3 build 

#### 2.3.1
build this project at the first time, should run

`git submodule update --init --recursive`

to pull the submodules from github. 

or when you get following error:

if you get following error
>FAILURE: Build failed with an exception.
>* Where:
Script '/Users/rai/it/project/reactivesw/customer_server/code_analyzer_test_local/code_analyzer.gradle' line: 6
>* What went wrong:
A problem occurred evaluating script.
> Could not read script '/Users/rai/it/project/reactivesw/customer_server/code_analyzer_test/code_analyzer_config.gradle' as it does not exist.
>* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.
>BUILD FAILED 

you need to run this command.

#### 2.3.2

run command 

`./gradlew clean build`

 to build the project

### 2.4 run
run command 
`java -jar build/libs/customer-server-0.0.1.jar`

after setup, you can visit the swagger ui page on the address 

`http:\\localhost:8088\swagger-ui.html`