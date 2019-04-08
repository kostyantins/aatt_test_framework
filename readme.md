 Advanced-md automation test framework
### This tool is developed for the purpose of 'AATT' project.

### Main goal:
- API testing

### Environment requirements: 
#### How to install:

1. **install JDK** (version 8-12) (http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- 1.1 set jdk path to 'JAVA_HOME' environment variable
- 1.2 add %JAVA_HOME%\bin to 'Path' environment variable

2. **install MAVEN** (latest version) (http://maven.apache.org/download.cgi)
- 2.1 set maven path to 'MAVEN_HOME' environment variable
- 2.2 add %MAVEN_HOME%\bin to 'Path' environment variable


#### Project dependencies:
* `testNG` - unit test framework for tests execution.
* `asswrtJ` - matchers library for providing test assertions.
* `allure-testNG` - allure adapter for testNG that enables logging feature.
* `aspectjweaver` - aspects weaver for AOP.
* `lombok` - helper library that simplifies creating/editing Java POJOs.
         
### How to use:
#### to understand project compiled correctly:
```
$ mvn install -U -DskipTests=true
```

#### 1. run one of this commands:
##### all tests :
```
$ mvn test (run smoke suite by default)
```

##### particular suite:
```
currently evaluable suites are: 
- smoke

$ mvn test -Dsuite='name of your particular suite'
```

##### single test:
```
$ mvn clean test -Dtest='pakage name of test class'.'class name'
```

#### 2. Reports :
- after run please find report in 'target\surefire-reports\index.html' - using surefire report
- after run use Allure report generator: 
```
$ mvn allure:report - to get it into base project directory (the command generates a package into the based framework directory and allowed lunch report manually via IDE)
$ mvn allure:serve - to get it on your localhost (will open automatically in your browser)
```

#### 3. CI: 
 TODO

### Additional tools which need to be installed:
- lombok (plugin needs to be installed annotation processing needs tobe launched)
- .ignore
- readme

### Additional recommendations which need to be followed (because of API):
 TODO
