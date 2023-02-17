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
        stage('RUN'){
            steps{
                sh "chmod +x -R ${env.WORKSPACE}"
                sh "chmod u+x AIMV.py"
                sh 'python3 aigpt.py $img '
                sh 'mv Out.jpeg /var/www/html'
            }
        }
    }
}