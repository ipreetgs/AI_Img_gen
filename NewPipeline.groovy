pipeline{
    agent any
    tools {
        git 'Default'
    }
   parameters {
        choice(name: 'AIfor', choices: ['ImageGeneration', 'TextComplition','WriteParagraph'], description: 'Select AI usecase') 
        string(name: 'img', defaultValue: 'white Cat sitting on table', description: 'Type USE Case')
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
                        sh 'python3 aiText.py $img>Out.txt'
                        sh 'mv Out.jpeg /var/www/html/'
                        echo "Wait for input."
                    } else if (params.AIfor == 'WriteParagraph') {
                        echo "you are not to proceed."
                        sh 'python3 AiWriter.py $img>Out.txt'
                        sh 'mv Out.jpeg /var/www/html/'
                    } else {
                        echo "Error"
                    }
                }
            }
        }
    }
}