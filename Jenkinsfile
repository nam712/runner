pipeline {
    agent any

    environment{
        COMPOSE_FILE = "docker-compose.yml"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/nam712/ktx-main.git'
            }
        }
        stage('build & deploy'){
            steps{
                script{
                    sh 'docker compose pull'

                    sh 'docker compose down'

                    sh 'docker compose up -d'

                }
            }
        }
    }
}
