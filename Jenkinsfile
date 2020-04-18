pipeline {

    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    stages {
        stage('Git Checkout') {
            steps {
                script {
                   currentBuild.result = "SUCCESS"
                }
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'master']],
                    userRemoteConfigs: [[credentialsId: 'roopaworld@yahoo.com',
                    url: 'https://github.com/roopakris/api-cucumber']]
                ])

            }
        }

        stage('Execute E2E Scenario Tests') {
                    steps {
                        catchError {
                                             sh ('mvn clean test -Dcucumber.options="--tags @login"')
                                        }
                                        sh ('mvn cluecumber-report:reporting')
                                        echo currentBuild.result
                    }
                }

                    stage('Publish Jenkinsfile and Archive Results') {
                            steps {
                                  junit '**/target/surefire-reports/junitreports/TEST-*.xml'
                                  archiveArtifacts 'target/generated-report/**/*.*'

                            }
                        }

                 stage('Publish Jenkinsfile') {
                            steps {
                                archive 'Jenkinsfile'
                            }
                        }
            }
        }
