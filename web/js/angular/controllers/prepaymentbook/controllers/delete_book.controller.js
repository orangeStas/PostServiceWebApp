app.controller('DeletePrepaymentBookController', function ($scope, $routeParams, PrepaymentBookService, $http) {
    var id = $routeParams.book_id;
    $http(
        {
            method: 'POST',
            url: '/deletePrepaymentBook',
            data: {
                'prepayment_book_number': id
            },
            headers: {'Content-Type': 'application/json; charset=utf-8'}
        }
    ).success(function (data) {
        return PrepaymentBookService.loadPrepaymentBooks().then(function (data) {
            $scope.prepayment_books = data.data.prepayment_books;
        })
    })
})