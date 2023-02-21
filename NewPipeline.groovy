pipeline{
    agent any
    tools {
        git 'Default'
    }
   parameters {
        choice(name: 'AI for ', choices: ['ImageGeneration', 'TextComplition','Write'], description: 'Select AI usecase') 
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
                    if (params.Services == 'ImageGeneration') {
                        sh 'python3 aigpt.py $img '
                        sh 'mv index.html /var/www/html'
                        sh 'mv Out.jpeg /var/www/html/'
                        // sh 'mv logo.png /var/www/html/'

                    } else if (params.Services == 'TextComplition') {
                        echo "Wait for input."
                    } else if (params.Services == 'Write') {
                        echo "you are not to proceed."
                    } else {
                        echo "Error"
                    }
                }
            }
        }
    }
}