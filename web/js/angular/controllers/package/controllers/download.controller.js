app.controller('DownloadPackageController', function ($scope, PackageService, $routeParams, $location) {
    console.log($routeParams.package_id);
    var doc_type = "pdf";
    return PackageService.downloadDoc($routeParams.package_id, doc_type);
});