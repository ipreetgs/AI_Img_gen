pipeline{
    agent any
    tools {
        git 'Default'
    }
   parameters {
        string(name: 'img', defaultValue: 'white Cat sitting on table', description: 'Enter Image you want to Create')
    }

    stages {
        stage('Git checkout') {
           steps{
                git branch: 'main', credentialsId: 'Github_tx_Creds', url: 'https://github.com/igurpreetsinghi/jenkinspipeline-aws.git'
            }
        }
        stage('RUN'){
            steps{
                echo "hello"
                sh 'python3 AIMV.py '
            }
        }
    }
}