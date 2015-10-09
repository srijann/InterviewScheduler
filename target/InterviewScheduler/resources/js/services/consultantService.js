'use strict';

/* ConsultantServices */

interviewSchedulerApp.service("consultantService", ['$http', '$q', function($http, $q){
	return {
		fetchAllConsultants : function(){
			return $http.get('http://localhost:8080/InterviewScheduler/consultants')
			.then(
					function(response){
						console.log('response: ', response);
						return response.data;
					},

					function(errResponse){
						console.error('Error while fetching consultants');
						return $q.reject(errResponse);
					}
			);
		}
	}

}]);


