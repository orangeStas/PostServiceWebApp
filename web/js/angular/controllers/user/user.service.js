app.factory('UserService', ['Service', function (Service) {
    return {
        loadUsers: function () {
            return Service.request('/loadUsers');
        },
        
        selectUser: function (id) {
            return Service.request('/admin/selectUser?user_id=' + id);
        }
    }
}]);