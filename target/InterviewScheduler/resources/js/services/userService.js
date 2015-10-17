'use strict';

/* Services */
interviewSchedulerApp.service('userService', ['$http', '$q', function($http, $q){
	return {
		fetchAllUsers : function(){
			console.log('inside userService.js');
			return $http.get('http://localhost:8080/InterviewScheduler/login')
			.then(
					function(response){
						return response.data;
					},

					function(errResponse){
						console.error('Error while fetching users');
						return $q.reject(errResponse);
					}
			);
		},
		 signUpNewUser: function(signUpNewUserData){
			console.log('User service : ' , signUpNewUserData);
			$http.post('http://localhost:8080/InterviewScheduler/signUpNewUser', signUpNewUserData)
			.success(function(signUpNewUserData, status, headers, config){
				console.log('post servie hit'+signUpNewUserData);

			}).error(function(signUpNewUserData, status, headers, config) {
				alert("failure");
			}
			);	

		}

	}

}]);
