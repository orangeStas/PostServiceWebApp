app.factory("PrepaymentBookService", ['Service', function (Service) {
    return {
        loadPrepaymentBooks : function () {
            return Service.request('/loadPrepaymentBooks');
        },

        selectPrepaymentBook: function (id) {
            return Service.request('/selectPrepaymentBook.action?prepayment_book_number='+id);
        }
    }
}]);