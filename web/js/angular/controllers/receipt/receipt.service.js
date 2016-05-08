app.factory('ReceiptService', ['Service', function (Service) {
    return {
        loadReceipts: function () {
            return Service.request('/loadReceipts');
        }
    }
}]);