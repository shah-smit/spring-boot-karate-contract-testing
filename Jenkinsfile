pipeline{
    agent any

    stages {
        stage('Compile Stage'){
            steps {
                withMaven(maven: 'maven_3_6_3'){
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Testing Stage'){
            steps {
                withMaven(maven: 'maven_3_6_3'){
                     sh 'mvn test'
                }
            }
        }

        stage('Package Stage'){
            steps {
                withMaven(maven: 'maven_3_6_3'){
                    sh 'mvn package'
                }
            }
        }

        stage('Deploy Stage'){
            steps {
                script {
                    sh 'java -jar target/karateframework-0.0.1-SNAPSHOT.jar'
                 }
             }
        }
    }
}