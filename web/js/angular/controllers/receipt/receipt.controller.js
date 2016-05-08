app.controller('ReceiptsController', function ($scope, ReceiptService) {
    return ReceiptService.loadReceipts().
    then(function (data) {
        $scope.receipts = data.data.receipts;
    })
});