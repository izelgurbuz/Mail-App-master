var module = angular.module("mail",['ui.bootstrap','user']);

module.factory("MailApi", ["$resource", function ($resource) {
    var baseUrl = "/mail";
    return $resource(baseUrl, {},
        {
            list: {
                method: "GET",
                url: baseUrl + "/list",
                isArray: true
            },
            add: {
                method: "POST",
                url: baseUrl + "/add"
            },
            remove: {
                 method: "POST",
                 url: baseUrl +"/remove"
             },
            getMailList : {
                method :"POST",
                url: baseUrl +"/inbox"
            },
            createNewMail :{
                method : "POST",
                url: baseUrl +"/new-mail"
            },
            mail: {
                method: "GET",
                url: baseUrl + "/:id",
            },
            updateRead: {
                method: "POST",
                url: baseUrl + "/update-read"
            },
        });
}]);