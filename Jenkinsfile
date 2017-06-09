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
			sh 'docker build -t 10.0.2.15:5000/calculator .'
		  }
		}
		
		stage("Docker push") {
		  steps {
			sh "docker push 10.0.2.15:5000/calculator"
		  }
		}
		stage("Acceptance test") {
		  steps {
			sh "docker run -d -p 8084:8080 --name calculator 10.0.2.15:5000/calculator"
			sleep 60
			sh 'chmod +x ./acceptance_test.sh'
			sh "./acceptance_test.sh"
			sh "docker stop calculator"
			sh "docker rm calculator"
		  }
		}
		
		/*stage("Release") {
			steps {
				sh "docker -H 192.168.1.4:2375 stop calculator | true"
				sh "docker -H 192.168.1.4:2375 rm calculator | true"
				sh "docker -H 192.168.1.4:2375 run -d -p 8080:8080 --name calculator 192.168.1.2:5000/calculator"
			}
		}
		stage("Smoke test") {
			steps {
				sleep 60
				sh 'chmod +x ./smoke_test.sh'
				sh "./smoke_test.sh"
			}
		}*/
	}
}