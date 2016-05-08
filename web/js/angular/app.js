var app = angular.module('app', ['ngRoute', 'ngCookies']);

app.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true).hashPrefix('!');

    $routeProvider
        .when('/admin/loadPackages.action', {
            templateUrl: 'js/angular/controllers/package/packages.view.jsp',
            controller: 'PackagesController'
        })
        .when('/admin/loadReceipts.action', {
            templateUrl: 'js/angular/controllers/receipt/receipts.view.html',
            controller: 'ReceiptsController'
        })
        .when('/admin/loadAdvertisements.action', {
            templateUrl: 'js/angular/controllers/advertisement/advertisements.view.html',
            controller: 'AdvertisementsController'
        })
        .when('/admin/loadSearchStatements.action', {
            templateUrl: 'js/angular/controllers/searchstatement/searchstatement.view.html',
            controller: 'SearchStatementsController'
        })
}]);
