app.controller('AddPackageController', function ($scope, $location, PackageService, $http, $window) {
    $scope.packageData = {};
    $scope.addPackage = function () {
        $http(
            {
                method: 'POST',
                url: '/client/addPackage',
                data: {
                    'package_type' : $scope.packageData.package_type,
                    'package_sender_name' : $scope.packageData.package_sender_name,
                    'package_getter_name' : $scope.packageData.package_getter_name,
                    'package_address' : $scope.packageData.package_address,
                    'package_post_index' : $scope.packageData.package_post_index
                },
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        ).success(function (data, status, headers, config) {
            $location.path('/client/loadUserPackages.action');
        });

    }
});