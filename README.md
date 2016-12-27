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
install postgresql 9.6 and set user and password to be `root`,
create a new database name `reactivesw`.

ps: user name, password and database name can be changed to other words,
but you need to change the config on `application.yaml`.

### 2.3 build 
run command `./gradlew clean build` to build the project

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

you need to run `git submodule update --init --recursive` to pull the submodules from github. 

### 2.4 run
run command `java -jar build/libs/customer-server-0.0.1.jar`
after setup, you can visit the swagger ui page on the address `http:\\localhost:8088\swagger-ui.html`