app.controller('UserPackagesController', function ($scope, PackageService) {
    return PackageService.loadUserPackages().
    then(function (data) {
        $scope.packages = data.data.packages;
    })
});