pipeline {
    agent any

    environment {
        DB_IMAGE = "ada26/ktx:db"
        BE_IMAGE = "ada26/ktx:be"
        FE_IMAGE = "ada26/ktx:fe"

        DB_EC2_IP = '18.140.56.185'
        BE_EC2_IP = '3.0.50.156'
        FE_EC2_IP = '18.139.2.85'

        SSH_KEY_DB = credentials('SSH_KEY_DB')
        SSH_KEY_BE = credentials('SSH_KEY_BE')
        SSH_KEY_FE = credentials('SSH_KEY_FE')
    }

    stages {
        stage('Deploy to EC2') {
            parallel {
                stage('Deploy DB') {
                    steps {
                        bat """
                            mkdir -p ~/.ssh
                            echo "${SSH_KEY_DB}" > ~/.ssh/id_rsa
                            chmod 600 ~/.ssh/id_rsa
                            ssh -o StrictHostKeyChecking=no -i ~/.ssh/id_rsa ec2-user@${DB_EC2_IP} "
                                docker pull ${DB_IMAGE}
                                docker stop db-container || true
                                docker rm db-container || true
                                docker rmi \$(docker images --filter=reference='ada26/ktx-db:*' -q | grep -v \$(docker images -q ${DB_IMAGE})) || true
                                docker run -d --name db-container -p 3306:3306 ${DB_IMAGE}
                            "
                            rm -f ~/.ssh/id_rsa
                        """
                    }
                }

                stage('Deploy BE') {
                    steps {
                        bat """
                            mkdir -p ~/.ssh
                            echo "${SSH_KEY_BE}" > ~/.ssh/id_rsa
                            chmod 600 ~/.ssh/id_rsa
                            ssh -o StrictHostKeyChecking=no -i ~/.ssh/id_rsa ec2-user@${BE_EC2_IP} "
                                docker pull ${BE_IMAGE}
                                docker stop be-container || true
                                docker rm be-container || true
                                docker rmi \$(docker images --filter=reference='ada26/ktx-be:*' -q | grep -v \$(docker images -q ${BE_IMAGE})) || true
                                docker run -d --name be-container -p 8888:8888 ${BE_IMAGE}
                            "
                            rm -f ~/.ssh/id_rsa
                        """
                    }
                }

                stage('Deploy FE') {
                    steps {
                        bat """
                            mkdir -p ~/.ssh
                            echo "${SSH_KEY_FE}" > ~/.ssh/id_rsa
                            chmod 600 ~/.ssh/id_rsa
                            ssh -o StrictHostKeyChecking=no -i ~/.ssh/id_rsa ec2-user@${FE_EC2_IP} "
                                docker pull ${FE_IMAGE}
                                docker stop fe-container || true
                                docker rm fe-container || true
                                docker rmi \$(docker images --filter=reference='ada26/ktx-fe:*' -q | grep -v \$(docker images -q ${FE_IMAGE})) || true
                                docker run -d --name fe-container -p 4300:4300 ${FE_IMAGE}
                            "
                            rm -f ~/.ssh/id_rsa
                        """
                    }
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
