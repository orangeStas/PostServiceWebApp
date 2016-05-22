app.controller('SelectAdvertisementController', function ($scope, AdvertisementService, $routeParams) {
    return AdvertisementService.selectAdvertisement($routeParams.package_id).then(function (data) {
        $scope.advertisement = data.data.advertisement;
    })
});