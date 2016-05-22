app.controller('UpdateAdvertisementController', function ($scope, $location, $http) {
    $scope.updateAdvertisement = function () {
        $http({
            method: 'POST',
            url: '/admin/updateAdvertisement',
            data: {
                'advertisement' : $scope.advertisement
            },
            headers: {'Content-Type': 'application/json; charset=utf-8'}
        }).success(function (data, status, headers, config) {
            $location.path('/admin/loadAdvertisements.action')
        })
    }
});