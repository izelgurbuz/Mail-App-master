var module = angular.module("user", ['ui.bootstrap']);

module.factory("UserApi", ["$resource", function ($resource) {
    var baseUrl = "/user";
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
                method: "DELETE",
                url: baseUrl
            },

            authenticateUser: {
                method: "POST",
                url: baseUrl + "/authentication",
            },

            getUser: {
                method: "GET",
                url: baseUrl + "/:id",
                params: {
                    id: '@id'
                }
            },
            getUserByName: {
                method: "POST",
                url: baseUrl + "/get-by-name",

            },
            getUserByNameL: {
                method: "POST",
                url: baseUrl + "/get-by-nameL",

            },
            getMailList: {
                method: "POST",
                url: baseUrl + "/mail-list",
                isArray: true

            },
            changePassword: {
                method: "POST",
                url: baseUrl + "/change-password"
            },
            changePasswordL: {
                method: "POST",
                url: baseUrl + "/change-passwordL"
            },
            changeQuestion: {
                method: "POST",
                url: baseUrl + "/change-question"
            }
        });
}]);