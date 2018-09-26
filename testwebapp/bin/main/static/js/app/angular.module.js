var testWebapp = angular.module('testWebapp', [
	'ngRoute'
]);

testWebapp.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl: 'templates/components/home.html',
		controller: 'HomeCtrl'
	}).otherwise({
		redirectTo: '/home'
	});
}]);