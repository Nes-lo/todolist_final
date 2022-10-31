pipeline{
    agent any

    stages{

    stage('gradlew clean')
       {
          steps{
          bat "gradlew clean"
           }
        }

       stage('build'){
          steps{
          bat "gradlew build -x test"
          }
       }

       stage('test'){
                 catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                                     bat "gradlew test"
                                 }
         }

       stage('cobertura'){
                   steps{
                   bat "gradlew jacocoTestReport"
                   }
                }


    stage('SonarQube analysis') {
           //withSonarQubeEnv() { // Will pick the global server connection you have configured
                 steps {
                   withSonarQubeEnv('SonarCloud'){
                    bat "gradlew sonarqube " // -Dsonar.branch.targe=${BRANCH_NAME} -Dsonar.branch.name=${BRANCH_NAME}
                   }
                 }
         }


         stage("Quality Gate") {
                     steps {
                         timeout(time: 1, unit: 'HOURS') {
                             waitForQualityGate abortPipeline: true
                         }
                     }
                 }

    }
}