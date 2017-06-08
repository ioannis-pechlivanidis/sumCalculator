pipeline{
	agent any
	
	stages{
		stage('Prepare Environment'){
			steps{
				sh 'chmod +x ./mvnw'
				sh './mvnw clean -Dhttp.proxyHost=172.28.12.5 -Dhttp.proxyPort=8080 -Dhttps.proxyHost=172.28.12.5 -Dhttps.proxyPort=8080 -X -e'
			}
		}
		
		stage('Compile'){
			steps{
				sh './mvnw compile'
			}
		}
		
		stage('Unit Test'){
			steps{
				sh './mvnw test'
			}
		}
		
		stage('Integration Test'){
			steps{
				sh './mvnw verify'
			}
		}
		
		stage('Build Docker Image') {
		  steps {
			sh 'docker build -t 10.0.2.15:5000/voxxedsg .'
		  }
		}
	}
}