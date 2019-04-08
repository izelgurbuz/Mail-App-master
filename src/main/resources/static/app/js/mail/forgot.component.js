var component = angular.module("user")
    .component("forgotPassword", {
        templateUrl: "/app/template/forgot.html",
        controller: function ($scope, UserApi) {

            $scope.check = function () {
                UserApi.getUserByNameL({receiver: $scope.username}, {}, function (response) {

                    $scope.user1 = response;
                    $scope.user1.$promise.then(function (data) {
                        $scope.user1 = data;
                        if ($scope.user1 != null) {
                            $scope.question = $scope.user1.question;
                        } else {
                            alert("user yok");
                        }
                    });

                });
            };
            $scope.confirm = function () {
                if ($scope.user1 != null) {
                    if ($scope.user1.answer === $scope.answer) {
                        if ($scope.newPassword != "" && $scope.confirmPassword != "" && $scope.newPassword === $scope.confirmPassword) {
                            $scope.user1.password = $scope.newPassword;
                            UserApi.changePasswordL($scope.user1, function (response) {

                            });
                            alert("SUCCESFULL !");
                        } else {
                            alert("passwords are not the same");
                        }
                    } else {
                        alert("Wrong Answer");
                    }
                } else {
                    alert("Answer Question");
                }

            };

            $scope.init = function () {
                $scope.user = {};
                $scope.username = "";
            };

            $scope.init();
        }
    });