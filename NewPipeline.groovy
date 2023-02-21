pipeline{
    agent any
    tools {
        git 'Default'
    }
   parameters {
        choice(name: 'AIfor ', choices: ['ImageGeneration', 'TextComplition','Write'], description: 'Select AI usecase') 
        string(name: 'img', defaultValue: 'white Cat sitting on table', description: 'Enter Image you want to Create')
    }
    stages {
        stage('Git checkout') {
           steps{
                git branch: 'main', credentialsId: 'Github_tx_Creds', url: 'https://github.com/ipreetgs/AI_Img_gen.git'
            }
        }
        stage(' Genarating !!') {
            steps{
                script{
                    if (params.AIfor == 'ImageGeneration') {
                        sh 'python3 aigpt.py $img '
                        sh 'mv index.html /var/www/html'
                        sh 'mv Out.jpeg /var/www/html/'
                        // sh 'mv logo.png /var/www/html/'

                    } else if (params.AIfor == 'TextComplition') {
                        echo "Wait for input."
                    } else if (params.AIfor == 'Write') {
                        echo "you are not to proceed."
                    } else {
                        echo "Error"
                    }
                }
            }
        }
    }
}