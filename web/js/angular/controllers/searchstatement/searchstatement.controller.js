app.controller('SearchStatementsController', function ($scope, SearchStatementService) {
    
    return SearchStatementService.loadSearchStatements().
    then(function (data) {
        $scope.search_statements = data.data.search_statements;
    })
});