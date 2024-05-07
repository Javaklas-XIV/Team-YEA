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
    stage('Set Version') {
      when { not { equals(actual: "${VERSION}", expected: "${PREV_VERSION}") } }
      steps {
        script {
          SNAPSHOT_STRING = (BRANCH_NAME == 'main') ? "" : "-SNAPSHOT"
        }
        sh "git checkout $BRANCH_NAME"
        sh "mvn versions:set -DnewVersion=${VERSION}${SNAPSHOT_STRING}"
        sh 'git commit -am "ci: Updated version number."'
        withCredentials([string(credentialsId: 'Github-token', variable: 'TOKEN')]) {
          script {
            REPO_URL_WITH_AUTH = 'https://${TOKEN}@github.com/Javaklas-XIV/${REPO_NAME}.git'
          }
          sh "git config remote.origin.url ${REPO_URL_WITH_AUTH}"
          sh "git push origin ${BRANCH_NAME}"
        }
      }
    }

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

  post {
    cleanup {
      cleanWs()
    }
  }
}