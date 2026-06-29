```groovy
pipeline {

    agent any

    tools {
        maven 'MAVEN1'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/abhijeetkumar873/Playwright_Opencart_Automation.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
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

                catchError(buildResult: 'SUCCESS',
                           stageResult: 'FAILURE') {

                    bat 'mvn test -Dsurefire.suiteXmlFiles=testng_Regrssion.xml'
                }
            }
        }

        stage('Publish Extent Report') {

            steps {

                publishHTML([
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output',
                    reportFiles: 'TestExecutionReport.html',
                    reportName: 'Extent Report'
                ])
            }
        }

    }
}
```
