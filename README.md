# satispay-authorization

> Replicate how clients authenticates with the Satispay gateway using RSA keys

> This Java project has been implemented using Maven as project management and comprehension tool. Spring Boot has been used to build the application.

 - You can run the project as a "Spring Boot App" in your IDE or executing "mvn spring-boot:run" from the root of the project via command line.
 - You can find an Interface Description Language (Swagger 2.0) describing the implemented RESTful APIs on http://localhost:8080/swagger-ui.html#/satispay-auth-controller.
 - You can explore and test the implemented APIs either using the Swagger or using another client (e.g. CURl, Postman...)

	###### CURl EXAMPLE OF GET REQUEST ######: 
	
		curl -i --location --request GET 'http://localhost:8080/authorize-satispay' \
		--header 'Accept: application/json' \
		--header 'Host: staging.authservices.satispay.com'
		
	###### CURl EXAMPLE OF POST REQUEST ######:
	
		curl --location --request POST 'http://localhost:8080/authorize-satispay' \
		--header 'Accept: application/json' \
		--header 'Host: staging.authservices.satispay.com' \
		--data-raw '{"dinosaurs": ["Tyrannosaurus rex", "Torosaurus latus", "Triceratops horridus"]}'
	
	###### CURl EXAMPLE OF PUT REQUEST ######:
	
		curl --location --request PUT 'http://localhost:8080/authorize-satispay' \
		--header 'Accept: application/json' \
		--header 'Host: staging.authservices.satispay.com' \
		--data-raw '{"dinosaur":"Tyrannosaurus rex"}'
		
	###### CURl EXAMPLE OF DELETE REQUEST ######:
	
		curl --location --request DELETE 'http://localhost:8080/authorize-satispay' \
		--header 'Accept: application/json' \
		--header 'Host: staging.authservices.satispay.com'
		
 - You can run Junit tests in your IDE  or executing "mvn test" via command line. 
   In "src/test/java" you can find some Junit tests to check the status code and the "authenticationKey.role" of the response.
