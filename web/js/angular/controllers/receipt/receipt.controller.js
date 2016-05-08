app.controller('ReceiptsController', function ($scope, ReceiptService) {
    $scope.receipts = [];

    return ReceiptService.loadReceipts().
    then(function (data) {
        $scope.receipts = data.data.receipts;
    })
});