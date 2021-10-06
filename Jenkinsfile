pipeline {
    agent any
    stages{
        stage('Build do Banckend'){
            steps{
                bat 'mvn clean package -DskipTests=true'
            }
        }
         stage('Unit Tests'){
            steps{
                bat 'mvn test'
            }
        }
        stage('Sonar Analysis'){
            environment {
                scannerHome = tool 'SONAR_SCANNER'
            }
            steps{
                withSonarQubeEnv('SONAR_LOCAL'){
                     bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack  -Dsonar.host.url=http://localhost:9000  -Dsonar.login=e5b2f37b0c4b7e1a17c03e84707503b79da02a49 -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/mvn/**,**/src/test/**,**/model/**,**Aplication.java "
                }               
            }
        }
        stage('Quality Gate'){
            steps{
                sleep(5)
                timeout(time:1, unit: 'MINUTES'){
                    waitForQualityGate abortPipeline: true
                }                
            }
        }
        stage('Deploy Backend'){
            steps{
                deploy adapters: [tomcat8(credentialsId: 'TomcatLogin', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
                                
            }
        }
        stage('API Test'){
            steps{
                dir('api-test') {
                    git credentialsId: '997dd19c-c595-4e5e-86d0-c402c512b18f', url: 'https://github.com/jadson76/tasks-api-test' 
                    bat 'mvn test'                               
                }                  
                
            }
        }
    }
}

 
