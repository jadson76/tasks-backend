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
    }
}