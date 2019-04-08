var component = angular.module("mail")
    .component("newMail", {
        templateUrl: "/app/template/newMail.html",
        controller: function ($scope, $location, UserApi, MailApi) {


            $scope.send = function () {

                UserApi.getUserByName({receiver: $scope.receiverName}, {}, function (response) {

                    $scope.mail.receiver = response;
                    $scope.mail.receiver.$promise.then(function (data) {
                        $scope.mail.receiver = data;
                        if ($scope.mail.receiver != null) {
                            $scope.mail.content = $scope.content;
                            $scope.mail.contentHeader = $scope.contentHeader;
                            MailApi.createNewMail($scope.mail, function (response) {
                                $location.path("/mail/inbox");
                            });

                        } else
                            alert("Wrong receiver name!");


                    })
                });


                $scope.init = function () {

                    $scope.mail = {
                        read: 'false'
                    };


                };

                $scope.init();
            }
        }
    });