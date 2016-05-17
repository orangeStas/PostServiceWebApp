app.controller('DeletePackageController', function ($scope, $location, PackageService, $http) {
    $scope.packageDat = {};
    $scope.deletePackage = function (id, index) {
        console.log("prodam dushu esli eta strochka vipolnit'sya");
        console.log(id);
        $http(
            {
                method: 'POST',
                url: '/deletePackage',
                data: {
                    'package_id' : id
                },
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        ).success(function () {
            PackageService.loadPackages().
            then(function (data) {
                $scope.packages = data.data.packages;
                $scope.new_package_ids = data.data.new_package_ids;
                $scope.packages.splice(index, 1);
                console.log(index);
            })
        })
    }
});