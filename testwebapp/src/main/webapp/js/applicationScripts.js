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

function HomeCtrl($scope, $http, $timeout) {

	function onStartup() {
		getUsers().then(function(response) {
			console.log("Get Users");
			console.log(response);
			getUser(1).then(function(response) {
				console.log("get User 1");
				console.log(response);
			}, function(error) {
				console.log(error);
			});
		}, function(error) {
			console.log(error);
		})
	};

	function getUsers() {
		return $http.get(
				configuration.urls.users, {
				params: ""
			}).then(function (response) {
				return response;
			}, function (error) {
				return error;
			});
	};

	function getUser(id) {
		return $http.get(
				configuration.urls.user, {
				params: {
					"id" : id
				}
			}).then(function (response) {
				return response
			}, function (error) {
				return error;
			});
	};

	onStartup();
};

HomeCtrl.$inject = ['$scope', '$http', '$timeout'];
testWebapp.controller('HomeCtrl', HomeCtrl);