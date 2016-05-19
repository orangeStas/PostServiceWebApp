app.controller('DeletePackageController', function ($scope, $routeParams, $location, PackageService, $http) {
    var id = $routeParams.package_id;
    console.log("prodam dushu esli eta strochka vipolnitsya");
    console.log(id);
    $http(
        {
            method: 'POST',
            url: '/deletePackage',
            data: {
                'package_id': id
            },
            headers: {'Content-Type': 'application/json; charset=utf-8'}
        }
    ).success(function (data) {
        return PackageService.loadPackages()
            .then(function (data) {
            $scope.packages = data.data.packages;
            $scope.new_package_ids = data.data.new_package_ids;
            $scope.packages.splice(index, 1);
            console.log(index);
        })
    })
});