app.controller('UpdatePrepaymentBookController', function ($scope, $location, $http) {
    $scope.updatePrepaymentBook = function () {
        $http({
            method: 'POST',
            url: '/updatePrepaymentBook',
            data: {
                'prepaymentBook' : $scope.prepayment_book
            },
            headers: {'Content-Type': 'application/json; charset=utf-8'}
        }).success(function (data, status, headers, config) {
            $location.path('/admin/loadPrepaymentBooks.action')
        })
    }
});