import groovy.transform.Field

@Field
def qualityGateStatus = null

pipeline {
  agent any
  environment {
    REPO_NAME = env.GIT_URL.replace('.git', '').split('/').last()
    VERSION = getNextSemanticVersion minorPattern: '^[Ff]eat.*', patchPattern: '^[Ff]ix'
    PREV_VERSION = getHighestSemanticVersion().toString()
    SONAR_BREAKS_BUILD = false
    SONAR_PROJECT_KEY = 'Team-YEA'
    SONAR_PROJECT_NAME = 'Team YEA'
  }
  tools {
    maven 'Maven 3.9.6'
    jdk 'JDK21'
  }
  stages {
    stage('Unit Tests') {
      when {
        not {
          branch 'main'
        }
      }
      steps {
        sh "mvn clean package"
        junit testResults: '**/target/surefire-reports/*.xml'
      }
    }

    stage('All Tests') {
      when {
        branch 'main'
      }
      steps {
        script {
          withSonarQubeEnv(credentialsId: 'Sonar-Secret') {
            sh "mvn clean verify sonar:sonar -Dsonar.projectKey=${SONAR_PROJECT_KEY} -Dsonar.projectName='${SONAR_PROJECT_NAME}'"
          }
        }
        waitForQualityGate abortPipeline: SONAR_BREAKS_BUILD, credentialsId: 'Sonar-Secret'
        junit testResults: '**/target/surefire-reports/*.xml, **/target/failsafe-reports/*.xml'
      }
    }
  }
  post {
    cleanup {
      cleanWs()
    }
  }
}