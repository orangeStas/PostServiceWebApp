app.controller('SelectSearchStatementController', function ($scope, SearchStatementService, $routeParams) {
    return SearchStatementService.selectStatement($routeParams.statement_id).
        then(function (data) {
            $scope.search_statement = data.data.search_statement;
    })
});