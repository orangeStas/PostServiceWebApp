app.controller("UpdateSearchStatementController", function ($scope, $location, $http) {
    $scope.updateSearchStatement = function () {
        console.log($scope.search_statement);
        $http({
            method : 'POST',
            url: '/updateSearchStatement',
            data : {
                'searchStatement' : $scope.search_statement
            },
            headers: {'Content-Type': 'application/json; charset=utf-8'}
        }).success(function (data, status, headers, config) {
            $location.path('/admin/loadSearchStatements.action');
        })
    }
});