app.factory('PackageService', ['Service', function (Service) {
    return {
        loadPackages: function () {
            return Service.request('/loadPackages');
        }
    }
}]);