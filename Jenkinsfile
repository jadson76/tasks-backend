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
                timeout(time:1, unit: 'MINUTES'){
                    waitForQualityGate abortPipeline: true
                }                
            }
        }
    }
}

 
