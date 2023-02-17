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
                sh 'sudo apt install python-is-python3'
                sh 'ip install -r req.txt'
                sh 'pip3 install -r req.txt'
                sh "chmod u+x AIMV.py"
                sh 'python3 aigpt.py $img '
                sh 'mv Out.jpeg /var/www/html'
            }
        }
    }
}