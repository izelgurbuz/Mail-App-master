var component = angular.module("mail")
    .component("changePass", {
        templateUrl: "/app/template/changePass.html",
        controller: function ($scope, $routeParams, MailApi,UserApi,$location) {


            $scope.change = function(){
                if($scope.newPass === $scope.repeatPass && $scope.newPass!= "" ){
                    $scope.user.password = $scope.newPass;
                    UserApi.changePassword($scope.user,function(response){

                    });
                }
            }

            $scope.init = function () {
                $scope.newPass="";
                $scope.repeatPass="";
                $scope.user ={
                    password : ""
                };

            };

            $scope.init();
        }
    });