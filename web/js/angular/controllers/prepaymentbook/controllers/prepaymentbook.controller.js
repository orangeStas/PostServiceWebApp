app.controller('PrepaymentBooksController', function ($scope, PrepaymentBookService) {
    return PrepaymentBookService.loadPrepaymentBooks().then(function (data) {
        $scope.prepayment_books = data.data.prepayment_books;
    })
});