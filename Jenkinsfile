
pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('build') {
            steps {
                echo 'Compile project..'
                sh 'chmod +x gradlew'
                sh './gradlew test'
            }
        }
    }
}
