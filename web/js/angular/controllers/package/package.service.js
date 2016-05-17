app.factory('PackageService', ['Service', function (Service) {
    return {
        loadPackages: function () {
            return Service.request('/loadPackages');
        },
        
        loadUserPackages: function () {
            return Service.request('client/loadUserPackages');
        },
        
        prepareDataForPackageCreation : function () {
            return Service.request('client/prepareDataForPackageCreation');
        },

        downloadDoc : function (id, doc) {
            console.log(doc);
            console.log(id);
            return Service.request('/downloadPackageDoc.action?doc_type=' + doc + '&package_id=' + id);
        }
    }
}]);