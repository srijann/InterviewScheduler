var interviewSchedulerApp = angular.module('interviewSchedulerApp', ['ui.router']);

interviewSchedulerApp.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/home');

	$stateProvider

	// HOME STATES AND NESTED VIEWS ========================================
	.state('home', {
		url: '/home',
		templateUrl: 'resources/html/home/home.html'
	})

	// ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
	.state('about', {
		url: '/about',
		templateUrl: 'resources/html/about/about.html'   
	})

	.state('contact', {
		url: '/contact',
		templateUrl: 'resources/html/contact/contact.html'

	})
	.state('consultants', {
		url: '/consultants',
		templateUrl: 'resources/html/consultant/consultant.html',
		controller: 'consultant.controller',
		resolve: {
			/*message: function(consultantService){
				var message = consultantService.getMessage();
				console.log('state :', message);
				return message;
			}*/
			/*message : function() {
				console.log('inside state');
				return {value : 'Hello!'};
			}*/
			consultantsData : ['consultantService', function(consultantService){
				return consultantService.fetchAllConsultants();
			}]
		}

	})
	.state('vendors',{
		url: '/vendors',
		templateUrl: 'resources/html/vendor/vendor.html'

	})
	.state('login',{
		url: '/login',
		templateUrl:'resources/html/login/login.html',
		controller: 'login.controller',
		resolve: {
			loginData : ['loginService', function(loginService){
				return loginService.getUserInfo();
			}]
		}
		
	});

});
