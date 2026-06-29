pipeline {

    agent any

    tools {
        maven 'MAVEN1'
    }

    stages {

        stage('Build') {

            steps {

                git 'https://github.com/jglick/simple-maven-project-with-tests.git'

                bat 'mvn -Dmaven.test.failure.ignore=true clean package'
            }

            post {

                always {
                    junit '**/target/surefire-reports/*.xml'
                }

                success {
                    archiveArtifacts artifacts: 'target/*.jar'
                }
            }
        }

        stage('Deploy to QA') {
            steps {
                echo 'Deploy to QA'
            }
        }

        stage('Regression Automation Test') {

            steps {

                git 'https://github.com/abhijeetkumar873/Playwright_Opencart_Automation.git'
                bat 'dir'
                  bat 'mvn clean test -Dsurefire.suiteXmlFiles=.//testng_Regrssion.xml'
            }
        }
    }
}