pipeline{
	agent any
	
	stages{
		stage('Prepare Environment'){
			steps{
				sh 'chmod +x ./mvnw'
				sh './mvnw clean -Dhttp.proxyHost=172.28.12.5 -Dhttp.proxyPort=8080 -Dhttps.proxyHost=172.28.12.5 -Dhttps.proxyPort=8080'
			}
		}
		
		stage('Compile'){
			steps{
				sh './mvnw compile -Dhttp.proxyHost=172.28.12.5 -Dhttp.proxyPort=8080 -Dhttps.proxyHost=172.28.12.5 -Dhttps.proxyPort=8080'
			}
		}
		
		stage('Unit Test'){
			steps{
				sh './mvnw test -Dhttp.proxyHost=172.28.12.5 -Dhttp.proxyPort=8080 -Dhttps.proxyHost=172.28.12.5 -Dhttps.proxyPort=8080'
			}
		}
		
		stage('Integration Test'){
			steps{
				sh './mvnw verify -Dhttp.proxyHost=172.28.12.5 -Dhttp.proxyPort=8080 -Dhttps.proxyHost=172.28.12.5 -Dhttps.proxyPort=8080'
			}
		}
		
		stage('Build Docker Image') {
		  steps {
			sh 'docker build -t 10.0.2.15:5000/voxxedsg .'
		  }
		}
		
		stage("Docker push") {
		  steps {
			sh "docker push 10.0.2.15:5000/voxxedsg"
		  }
		}
		stage("Acceptance test") {
		  steps {
			sh "docker run -d -p 8765:8080 --name calculator 10.0.2.15:5000/voxxedsg"
			sleep 60
			sh 'chmod +x ./acceptance_test.sh'
			sh "./acceptance_test.sh"
			sh "docker stop calculator"
			sh "docker rm calculator"
		  }
		}
	}
}