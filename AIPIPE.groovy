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
                git branch: 'main', credentialsId: 'Github_tx_Creds', url: 'https://github.com/ipreetgs/AI_Img_gen.git'
            }
        }
        stage('IMAGE CREATION'){
            steps{
                sh 'python3 aigpt.py $img '
                sh 'mv index.html /var/www/html'
                sh 'mv Out.jpeg /var/www/html/'
                sh 'mv logo.png /var/www/html/'
            }
        }
        stage('Open webpage') {
            steps {
                script {
                    'start http://18.215.63.72'
                }
            }
        }
    }
}