var app = angular.module('app', ['ngRoute', 'ngCookies']).config(function ($sceProvider) {
    $sceProvider.enabled(false);
});

app.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true).hashPrefix('!');

    $routeProvider
        .when('/admin/loadPackages.action', {
            templateUrl: 'js/angular/controllers/package/views/packages.view.jsp',
            controller: 'PackagesController'
        })
        .when('/managerr/loadPackages.action', {
            templateUrl: 'js/angular/controllers/package/views/packages.view.jsp',
            controller: 'PackagesController'
        })
        .when('/admin/loadReceipts.action', {
            templateUrl: 'js/angular/controllers/receipt/receipts.view.jsp',
            controller: 'ReceiptsController'
        })
        .when('/admin/loadAdvertisements.action', {
            templateUrl: 'js/angular/controllers/advertisement/advertisements.view.jsp',
            controller: 'AdvertisementsController'
        })
        .when('/admin/loadSearchStatements.action', {
            templateUrl: 'js/angular/controllers/searchstatement/searchstatement.view.jsp',
            controller: 'SearchStatementsController'
        })
        .when('/managerr/loadSearchStatements.action', {
            templateUrl: 'js/angular/controllers/searchstatement/searchstatement.view.jsp',
            controller: 'SearchStatementsController'
        })
        .when('/admin/loadPrepaymentBooks.action', {
            templateUrl: 'js/angular/controllers/prepaymentbook/prepaymentbook.view.jsp',
            controller: 'PrepaymentBooksController'
        })
        .when('/managerr/loadPrepaymentBooks.action', {
            templateUrl: 'js/angular/controllers/prepaymentbook/prepaymentbook.view.jsp',
            controller: 'PrepaymentBooksController'
        })
        .when('/admin/loadUsers.action', {
            templateUrl: 'js/angular/controllers/user/views/users.view.jsp',
            controller: 'UsersController'
        })
        .when('/admin/selectUser.action/:user_id', {
            templateUrl: 'js/angular/controllers/user/views/user_view.view.jsp',
            controller: 'SelectUserController'
        })
        .when('/admin/selectSearchStatement.action/:statement_id', {
            templateUrl: 'js/angular/controllers/searchstatement/views/search_statement_view.view.jsp',
            controller: 'SelectSearchStatementController'
        })
        .when('/admin/advertisement/:package_id', {
            templateUrl: 'js/angular/controllers/advertisement/views/advertisement_view.view.jsp',
            controller: 'SelectAdvertisementController'
        })
        .when('/selectPrepaymentBook.action/:book_id', {
            templateUrl: 'js/angular/controllers/prepaymentbook/views/prepaymentbook_view.view.jsp',
            controller : 'SelectPrepaymentBookController'
        })
        .when('/admin/deleteReceipt.action/:receipt_id', {
            templateUrl: 'js/angular/controllers/receipt/receipts.view.jsp',
            controller : 'DeleteReceiptController'
        })
        .when('/admin/deletePackage.action/:package_id', {
            templateUrl: 'js/angular/controllers/package/views/packages.view.jsp',
            controller : 'DeletePackageController'
        })
        .when('/deleteAdvertisement/:package_id', {
            templateUrl: 'js/angular/controllers/advertisement/advertisements.view.jsp',
            controller : 'DeleteAdvertisementController'
        })
        .when('/admin/deletePrepaymentBook.action/:book_id', {
            templateUrl: 'js/angular/controllers/prepaymentbook/prepaymentbook.view.jsp',
            controller : 'DeletePrepaymentBookController'
        })
        .when('/admin/deleteSearchStatement.action/:id', {
            templateUrl: 'js/angular/controllers/searchstatement/searchstatement.view.jsp',
            controller: 'DeleteSearchStatementController'
        })
        .when('/download/:package_id', {
            controller: 'DownloadPackageController',
            templateUrl: '/admin/loadPackages.action'
        })
        .when('/admin/loadAdvertisements.action', {
            templateUrl: 'js/angular/controllers/advertisement/advertisements.view.jsp',
            controller: 'AdvertisementsController'
        })
        .when('/managerr/loadAdvertisements.action', {
            templateUrl: 'js/angular/controllers/advertisement/advertisements.view.jsp',
            controller: 'AdvertisementsController'
        })
        .when('/logout.action', {
            controller: 'LogoutController',
            template : "<div></div>"
        })
        .when('/client/loadUserPackages.action', {
            templateUrl: 'js/angular/controllers/package/views/user_packages.view.jsp',
            controller: 'UserPackagesController'
        })
        .when('/client/prepareDataForPackageCreation.action', {
            templateUrl: 'js/angular/controllers/package/views/package_view.view.jsp',
            controller: 'PreparePackageCreationController'
        })
        .otherwise({
            templateUrl: 'js/angular/home.view.jsp'
        })
}]);
