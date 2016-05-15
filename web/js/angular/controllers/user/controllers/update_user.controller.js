app.controller("UpdateUserController", function ($scope, $location, $http) {
    $scope.userData = {};
    $scope.updateUser = function () {
        console.log($scope.userr);
        $http(
            {
                method: 'POST',
                url: '/admin/updateUser',
                data: {
                    'user' : $scope.userr,
                },
                headers: {'Content-Type': 'application/json; charset=utf-8'}
            }
        ).success(function (data, status, headers, config) {
            $location.path('/admin/loadUsers.action');
        })
    }
});