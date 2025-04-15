pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/your-user/your-repo.git'
            }
        }

        stage('Build React') {
            steps {
                dir("${REACT_DIR}") {
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }

        stage('Copy React → Spring Boot static') {
            steps {
                sh "rm -rf ${SPRING_BOOT_DIR}/src/main/resources/static/*"
                sh "cp -r ${REACT_DIR}/build/* ${SPRING_BOOT_DIR}/src/main/resources/static/"
            }
        }

        stage('Build Spring Boot') {
            steps {
                dir("${SPRING_BOOT_DIR}") {
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
