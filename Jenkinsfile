pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/iamjaeone/test-oplanner.git'
            }
        }

        stage('Build Image Only') {
            steps {
                sh 'docker-compose build'
            }
        }

        stage('Swap Running App') {
            steps {
                sh 'docker-compose up -d --no-deps --force-recreate app'
            }
        }
    }
}
