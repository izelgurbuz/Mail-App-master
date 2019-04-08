var component = angular.module("mail")
    .component("login", {
        templateUrl: "/app/template/login.html",
        controller: function ($scope, $location, UserApi,$rootScope, ngToast) {

            $scope.submit = function () {

                UserApi.authenticateUser({
                    name: $scope.userName,
                    password: $scope.userPassword
                }, {}, function (response) {

                    if(response.code== 0){
                        $scope.currentUser = response.data;
                        $location.path("/mail/inbox");

                    }
                    else
                        ngToast.create({
                            className: 'warning',
                            content: "Wrong name or password"
                        });

                })
            };


            $scope.init = function () {

                $scope.userName = "";
                $scope.userPassword = "";
                $rootScope.visible = false;
            };

            $scope.init();


        }
    });