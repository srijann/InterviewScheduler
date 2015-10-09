'use strict';

/* loginServices */

interviewSchedulerApp.service('loginService', ['$http','$q', function($http, $q) {
	return {
		getUserInfo: function() {
			var deferred = $q.defer();

			$http.get('http://localhost:8080/InterviewScheduler/login')
			.then(function (response) {
				if (response.status == 200) {
					deferred.resolve(response.data);
				}
				else {
					deferred.reject('Error retrieving user info');
				}
			}
			);

			return deferred.promise;
		}
	}
}]);


