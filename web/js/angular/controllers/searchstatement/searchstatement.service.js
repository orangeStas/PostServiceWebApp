app.factory('SearchStatementService', ['Service', function (Service) {
    return {
        loadSearchStatements: function () {
            return Service.request('/loadSearchStatements');
        },
        
        selectStatement: function (id) {
            return Service.request('/selectSearchStatement.action?statement_id=' + id);
        }
    }
}]);