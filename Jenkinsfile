pipeline {
    stages {
        stage('Build') {
            steps {
                echo "Building with version: ${env.BUILD_VERSION}"
                sh "mvn clean compile -Dbuild.version=${env.BUILD_VERSION}"
            }
        }
        stage('Test') {
            steps {
                echo "Running unit tests"
                sh 'mvn test'
            }
        }
        stage('Package') {
            steps {
                echo "Packaging the JAR"
                sh "mvn package -DskipTests -Dbuild.version=${env.BUILD_VERSION}"
            }
        }
        stage('Archive Artifact') {
            steps {
                echo "Archiving the JAR artifact"
                archiveArtifacts artifacts: 'target/*.jar'
            }
        }

        /*
        // additional security scan stage and deployment to aws or on-prem
        // for veracode, need to set up credentials in Jenkins and configure the Veracode plugin
        // then adding a stage for veracode scan where the built artifact is uploaded for scanning
        // build is marked as UNSTABLE if the security scan fails, pipeline continues
        // Example :
        stage('Security Scan - Veracode') {
            steps {
                catchError(buildResult: 'UNSTABLE', stageResult: 'FAILURE') {
                    echo "uploading artifact to Veracode for security scan"
                    // use veracode here
                }
            }
        }
        // aws deployment stage, using aws codedeploy to pull artifacts from S3
        // Example :
        stage('Deploy to AWS') {
            steps {
                echo "Deploying to AWS"
                // use aws deploy here
            }
        }
        // for on-prem can use ssh to copy the artifact to the server and run deployment scripts to deploy
        // example
         stage('Deploy to On-Prem') {
            steps {
                echo "Deploying to On-Premises Server"
                // use ssh here
            }
         }
        */
    }
    post {
        always {
            echo "Publish test results"
            junit 'target/surefire-reports/*.xml'
        }
        success {
            echo "Build completed successfully with BUILD_VERSION: ${env.BUILD_VERSION}"
        }
        failure {
            echo "Build failed, Please check the logs"
        }
    }
}
