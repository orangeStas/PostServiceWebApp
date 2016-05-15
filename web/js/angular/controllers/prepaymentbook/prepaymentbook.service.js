app.factory("PrepaymentBookService", ['Service', function (Service) {
    return {
        loadPrepaymentBooks : function () {
            return Service.request('/loadPrepaymentBooks');
        }
    }
}]);