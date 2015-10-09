'use strict';

var app = angular.module('interviewSchedulerApp');
app.controller('login.controller',function ($scope, loginData) {
	console.log('Inside login.controller', loginData);
	$scope.user = loginData;

 });

   