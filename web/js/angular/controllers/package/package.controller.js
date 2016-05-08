app.controller('PackagesController', function ($scope, PackageService) {
    
    return PackageService.loadPackages().
    then(function (data) {
        $scope.packages = data.data.packages;
        $scope.new_package_ids = data.data.new_package_ids;
    })
});