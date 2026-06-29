pipeline {

agent any

tools {
    maven 'MAVEN1'
}

stages {

    stage('Build') {
        {
                 git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                 sh "mvn -Dmaven.test.failure.ignore=true clean package"
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
				git 'https://github.com/naveenanimation20/Playwright-Java-PageObjectModel'
				bat 'dir'
                bat 'mvn clean test -Dsurefire.suiteXmlFiles=.//testng_Regrssion.xml'
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