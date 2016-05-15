app.controller('PreparePackageCreationController', function ($scope, PackageService) {
    return PackageService.prepareDataForPackageCreation().
    then(function (data) {
        $scope.package_types = data.data.package_types;
        $scope.users = data.data.users;
        $scope.user = data.data.user;
    });
});