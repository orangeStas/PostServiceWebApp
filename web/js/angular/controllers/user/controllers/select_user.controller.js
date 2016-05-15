app.controller('SelectUserController', function ($scope, UserService, $routeParams) {
    return UserService.selectUser($routeParams.user_id).
    then(function (data) {
        $scope.userr = data.data.userr;
        $scope.admins_count = data.data.admins_count;
        $scope.user_id = data.data.user_id;
        $scope.passports = data.data.passports;
        $scope.user_roles = data.data.user_roles;
    });
    
});