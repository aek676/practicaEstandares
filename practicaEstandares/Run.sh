mvn clean verify sonar:sonar   -Dsonar.projectKey=practicaEstandares   -Dsonar.host.url=http://sonarqube:9000   -Dsonar.login=TOKEN   -Dsonar.java.checkstyle.reportPaths=target/checkstyle-result.xml
