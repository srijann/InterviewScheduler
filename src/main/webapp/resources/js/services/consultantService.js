'use strict';
/* Services */
interviewSchedulerApp.service('consultantService', ['$http', '$q', function($http, $q){
	return {
		fetchAllConsultants : function(){
			return $http.get('http://localhost:8080/InterviewScheduler/consultants')
			.then(
					function(response){
						console.log('response: ', response);
						return response.data;
					},

					function(errResponse){
						console.error('Error while fetching users');
						return $q.reject(errResponse);
					}
			);
		},
		editConsultant : function(){
			var editConsulatantData = {
				      "id": 3,
				      "name": "Naresh",
				      "ssn": "443-30-8769",
				      "dob": "1984-02-28",
				      "email": "nrs@hotmail.com",
				      "phone": "303-344-4799",
				      "yrsExp": 6.5,
				      "consultantClient": [],
				      "educationDetail": {
				        "id": 3,
				        "institutionName": "Regis",
				        "location": "Denver, CO",
				        "graduateYear": 2009
				      },
				      "vendors": []
				    };
			console.log('cons serv : ' , editConsulatantData);
			$http.post('http://localhost:8080/InterviewScheduler/editConsultant', editConsulatantData)
			.success(function(editConsulatantData, status, headers, config){
				console.log('post servie hit'+editConsulatantData);

			}).error(function(editConsultantData, status, headers, config) {
				alert("failure");
			}
			);	

		}

	}

}]);


