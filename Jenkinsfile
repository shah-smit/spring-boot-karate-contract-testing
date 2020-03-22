pipeline{
    agent any

    stages {
        stage('Compile'){
            steps {
                withMaven(maven: 'maven_3_6_3'){
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Unit Testing'){
            steps {
                withMaven(maven: 'maven_3_6_3'){
                     sh 'mvn test'
                }
            }
        }

        stage('Jar Package'){
            steps {
                withMaven(maven: 'maven_3_6_3'){
                    sh 'mvn package'
                }
            }
        }

        stage('Local Deploy'){
            steps {
                script {
                    sh 'nohup java -jar target/karateframework-0.0.1-SNAPSHOT.jar &'
                 }
             }
        }

        stage('Waiting'){
            steps {
                sleep(time:10,unit:"SECONDS")
            }
        }

        stage('Functional Testing'){
            steps {
                script {
                    sh 'mvn test -Dtest=KarateRunner'
                 }
            }
        }

        stage('Kill Deployment'){
            steps {
                script {
                    sh 'kill $(lsof -ti:8080)'
                }
            }
        }
    }
}