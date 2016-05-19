app.controller('SelectPrepaymentBookController', function ($scope, PrepaymentBookService, $routeParams) {
    return PrepaymentBookService.selectPrepaymentBook($routeParams.book_id).then(function (data) {
        $scope.prepayment_book = data.data.prepayment_book;
    })
});