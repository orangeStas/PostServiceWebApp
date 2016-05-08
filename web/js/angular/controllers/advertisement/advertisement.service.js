app.factory('AdvertisementService', ['Service', function (Service) {
    return {
        loadAdvertisements: function () {
            return Service.request('/loadAdvertisements');
        }
    }
}]);