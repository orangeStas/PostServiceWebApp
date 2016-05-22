app.controller('DeleteAdvertisementController', function ($scope, $routeParams, AdvertisementService, $http) {
    var id = $routeParams.package_id;
    $http(
        {
            method: 'POST',
            url: '/deleteAdvertisement',
            data : {
                'package_id' : id
            },
            headers: {'Content-Type': 'application/json; charset=utf-8'}
        }
    ).success(function (data) {
        return AdvertisementService.loadAdvertisements().then(function (data) {
            $scope.advertisements = data.data.advertisements;
        })
    })
});