app.controller('LogoutController', function ($scope, Service) {
    window.location.replace('/');
    return Service.request('/logout');
});