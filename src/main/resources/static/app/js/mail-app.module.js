var app = angular.module("MailApp", [
    'ngResource',
    'ngRoute',
    'mail',
    'user',
    'ngToast'
]);

app.config(["$routeProvider", "$locationProvider",
    function ($routeProvider, $locationProvider) {

        $locationProvider.html5Mode({enabled: true});

        $routeProvider
            .when('/', {
                template: "<login></login>"
            })
            .when('/forgot', {
                template: "<forgot-password></forgot-password>"
            })
            .when('/user/:param', {

                template: "<inbox></inbox>"

            })
            .when('/user/mail-list', {

                template: "<inbox></inbox>"

            })
            .when('/mail/inbox', {

                template: "<inbox></inbox>"

            })
            .when('/mail/new-mail', {

                template: "<new-mail></new-mail>"

            })
            .when('/change-pass', {

                template: "<change-pass></change-pass>"

            })
            .when('/change-question', {

                template: "<change-question></change-question>"

            })
            .when('/mail/:param', {

                template: "<mail-show></mail-show>"

            })

            .otherwise({
                redirectTo: '/'
            });

    }]);


app.controller("MenuController", function ($scope, $location) {

    $scope.goPass = function (option) {
        if (option == 0)
            $location.path("/change-pass");
        else
            $location.path("/change-question");
    }
    $scope.init = function () {
    };
    $scope.init();

});
