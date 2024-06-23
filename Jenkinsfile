node {
  stage("Clone project") {
    git branch: 'main', url: 'https://github.com/HanDaWoon/madras_check_assignment.git'
  }

  stage("Deploy to DockerHub with Jib") {
    withCredentials([usernamePassword(credentialsId: 'DOCKER_CRED', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
        sh '''
        echo "${DOCKER_PASSWORD}" | docker login -u "${DOCKER_USERNAME}" --password-stdin
        ./gradlew jib -Djib.to.auth.username="${DOCKER_USERNAME}" -Djib.to.auth.password="${DOCKER_PASSWORD}"
        '''
    }
  }

  stage("Pull Image and Restart Container") {
    withCredentials([file(credentialsId: 'madras_check_secret', variable: 'DB_URL')]) {
      sh '''
        docker pull handawoon/madras-assignment

        if [ "$(docker ps -q -f name=madras-assignment)" ]; then
          docker stop madras-assignment
          docker rm madras-assignment
        fi

        docker run -d --network nginx-nw --env-file $DB_URL --name madras-assignment handawoon/madras-assignment
      '''
    }
  }
}
