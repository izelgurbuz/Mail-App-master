var component = angular.module("mail")
    .component("inbox", {
        templateUrl: "/app/template/main.html",
        controller: function ($scope, MailApi, $routeParams, UserApi, $location, $rootScope) {


            $scope.select = function (mail, index) {
                $scope.current = mail;
                $scope.currentIndex = index;

            };

            $scope.remove = function (mail, index) {
                //console.log(mail.id);
                // implement
                // not: Dont forget to splice
                MailApi.remove({id: mail.id}, {}, function (response) {
                    $scope.mails.splice(index, 1);

                })
            };

            $scope.open = function (mail) {
                $scope.mail.id = mail.id;
                $scope.mail.content = mail.content;
                $scope.mail.contentHeader = mail.contentHeader;
                $scope.mail.date = mail.date;
                $scope.mail.sender = mail.sender;
                $scope.mail.receiver = mail.receiver;
                $scope.mail.read = true;
                MailApi.updateRead($scope.mail, function (response) {

                })
                $location.path("/mail/" + mail.id);
            };

            $scope.newMail = function () {
                $location.path("/mail/new-mail");
            };

            $scope.init = function () {
                //  var id = $routeParams.param;
                // $scope.currentUser = UserApi.getUser({'id': id});
                /*$scope.currentUser.$promise.then(function(data) {
                    console.log(data);
                    $scope.currentUser = data;*/
                $rootScope.visible = true;
                UserApi.getMailList(function (response) {
                    $scope.mails = response;
                });
                $scope.data = {
                    currentPage: 1
                };
                $scope.mail = {};


            };

            $scope.init();
        }
    });