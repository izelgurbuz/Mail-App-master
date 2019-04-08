var component = angular.module("mail")
    .component("changeQuestion", {
        templateUrl: "/app/template/changeQuestion.html",
        controller: function ($scope, $routeParams, MailApi, UserApi, $location) {


            $scope.change = function () {

                $scope.user.question = $scope.selectedQ.q;
                $scope.user.answer = $scope.answer;
                UserApi.changeQuestion($scope.user, function (response) {

                });

            }

            $scope.init = function () {
                $scope.newPass = "";
                $scope.repeatPass = "";
                $scope.selectedQ = "";
                $scope.answer ="";
                $scope.questions = [
                    {q: 'What is the name of your pet?'},
                    {q: 'What is your favorite color?'},
                    {q: 'What is ypur favorite music band?'},
                    {q: 'What is your favorite hero?'},
                    {q: 'What is the name of your math teacher?'}
                ];

                $scope.user = {
                    question: ""
                };

            };

            $scope.init();
        }
    });