'use strict';

var app = angular.module('interviewSchedulerApp');
app.controller('consultant.controller', function($scope, consultantsData) {
	//$scope.message = message;

	console.log('Inside consultant.controller', consultantsData);
	$scope.consultant = consultantsData;
});