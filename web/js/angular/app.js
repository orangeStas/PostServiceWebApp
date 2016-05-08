var app = angular.module('app', ['ngRoute', 'ngCookies']);

app.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true).hashPrefix('!');

    $routeProvider
        .when('/admin/loadReceipts.action', {
            templateUrl: 'js/angular/controllers/receipt/receipts.view.html',
            controller: 'ReceiptsController'
        })
}]);

app.controller('postapp', function ($scope) {

});
