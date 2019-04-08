var component = angular.module("mail")
    .component("mailShow", {
        templateUrl: "/app/template/show.html",
        controller: function ($scope, $routeParams, MailApi) {



            $scope.init = function () {

                var id = $routeParams.param;
                $scope.mail = MailApi.mail({id : id});


            };

            $scope.init();
        }
    });