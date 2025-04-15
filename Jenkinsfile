pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/iamjaeone/test-oplanner.git'
            }
        }

        stage('Build React') {
            steps {
                dir("frontend") {
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }

        stage('Copy React → Spring Boot static') {
            steps {
                sh "rm -rf backend/src/main/resources/static/*"
                sh "cp -r frontend/dist/* backend/src/main/resources/static/"
            }
        }

        stage('Build Spring Boot') {
            steps {
                dir("backend") {
                    sh './gradlew clean build'
                }
            }
        }

        stage('Docker Compose Up') {
            steps {
                sh 'docker-compose down'
                sh 'docker-compose build'
                sh 'docker-compose up -d'
            }
        }
    }
}
