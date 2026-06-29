pipeline {

agent any

tools {
    maven 'MAVEN1'
}

stages {

    stage('Build') {
        steps {
            bat 'mvn clean install'
        }

        post {

            always {
                junit allowEmptyResults: true,
                      testResults: '**/target/surefire-reports/*.xml'
            }

            success {
                archiveArtifacts artifacts: 'target/*.jar',
                                 fingerprint: true
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

            catchError(
                buildResult: 'SUCCESS',
                stageResult: 'FAILURE'
            ) {

                bat 'mvn test -Dsurefire.suiteXmlFiles=testng_Regression.xml'
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