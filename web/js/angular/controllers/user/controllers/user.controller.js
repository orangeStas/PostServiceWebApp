app.controller('UsersController', function ($scope, UserService) {
    return UserService.loadUsers().
    then(function (data) {
        $scope.users = data.data.users;
        $scope.admins_count = data.data.admins_count;
    })
});