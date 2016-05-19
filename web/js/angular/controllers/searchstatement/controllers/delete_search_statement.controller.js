app.controller('DeleteSearchStatementController', function ($scope, $routeParams, SearchStatementService, $http) {
    var id = $routeParams.id;
    $http(
        {
            method: 'POST',
            url: '/deleteSearchStatement',
            data: {
                'search_statement_id': id
            },
            headers: {'Content-Type': 'application/json; charset=utf-8'}
        }
    ).success(function (data) {
        return SearchStatementService.loadSearchStatements().
        then(function (data) {
            $scope.search_statements = data.data.search_statements;
        })
    })
})