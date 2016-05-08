app.factory('SearchStatementService', ['Service', function (Service) {
    return {
        loadSearchStatements: function () {
            return Service.request('/loadSearchStatements');
        }
    }
}]);