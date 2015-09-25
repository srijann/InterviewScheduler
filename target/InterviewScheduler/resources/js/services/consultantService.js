'use strict';

/* Services */

app.service("consultantService", ['$http', '$q', function($http, $q){
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
		}
	}

}]);


