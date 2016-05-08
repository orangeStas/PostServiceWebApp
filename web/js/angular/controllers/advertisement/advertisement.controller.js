app.controller('AdvertisementsController', function ($scope, AdvertisementService) {
    $scope.advertisements = [];

    return AdvertisementService.loadAdvertisements().
    then(function (data) {
        $scope.advertisements = data.data.advertisements;
    })
});