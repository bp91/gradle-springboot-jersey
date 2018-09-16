function HomeCtrl($scope, $http, $timeout) {
	console.log("CIAO");

	$http.get(configuration.urls.users, {
		params: ""
	}).then(function (response) {
		console.log(response)
	}, function (response) {
		console.log(response);
	});

	$http.get(configuration.urls.user, {
		params: {
			"id" : 1
		}
	}).then(function (response) {
		console.log(response)
	}, function (response) {
		console.log(response);
	});
};

HomeCtrl.$inject = ['$scope', '$http', '$timeout'];
testWebapp.controller('HomeCtrl', HomeCtrl);