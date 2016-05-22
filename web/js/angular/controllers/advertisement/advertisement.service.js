app.factory('AdvertisementService', ['Service', function (Service) {
    return {
        loadAdvertisements: function () {
            return Service.request('/loadAdvertisements');
        },
        
        selectAdvertisement: function (id) {
            return Service.request('/selectAdvertisement.action?package_id=' + id);
        }
    }
}]);