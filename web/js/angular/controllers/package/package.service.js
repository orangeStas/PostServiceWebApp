app.factory('PackageService', ['Service', function (Service) {
    return {
        loadPackages: function () {
            return Service.request('/loadPackages');
        },
        
        loadUserPackages: function () {
            return Service.request('client/loadUserPackages');
        },
        
        prepareDataForPackageCreation : function () {
            return Service.request('client/prepareDataForPackageCreation');
        }
    }
}]);