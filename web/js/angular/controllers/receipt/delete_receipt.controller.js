app.controller('DeleteReceiptController', function ($scope, $http, $routeParams, ReceiptService) {
    var receiptId = $routeParams.receipt_id;
    console.log(receiptId);
    $http({
        method: 'POST',
        url: '/deleteReceipt',
        data: {
            'receipt_id' : receiptId
        },
        headers: {'Content-Type': 'application/json; charset=utf-8'}
    }).success(function (data) {
        return ReceiptService.loadReceipts().
        then(function (data) {
            $scope.receipts = data.data.receipts;
        })
    });
    
});