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
		editConsultant : function(editConsulatantData){
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


