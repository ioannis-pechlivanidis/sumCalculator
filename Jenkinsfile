pipeline{
	agent any
	
	stages{
		stage('Prepare Environment'){
			steps{
				sh 'chmod +x ./mvnw'
				sh './mvnw clean'
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
	}
}