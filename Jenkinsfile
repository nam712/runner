pipeline {
    agent any

    environment {
        COMPOSE_FILE = "docker-compose.yml"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/nam712/ktx-main.git'
            }
        }
        stage('Build & Deploy') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'docker compose pull'
                        sh 'docker compose down'
                        sh 'docker compose up -d'
                    } else {
                        bat 'docker compose pull'
                        bat 'docker compose down'
                        bat 'docker compose up -d'
                    }
                }
            }
        }
    }
}
