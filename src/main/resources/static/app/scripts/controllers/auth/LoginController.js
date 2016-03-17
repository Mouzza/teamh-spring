﻿(function (angular) {

    "use strict";

    function LoginController($location, $rootScope, AuthService, GebruikerService, JwtService, localStorageService) {

        var vm = this;

        vm.login = function (credentials) {

            AuthService.login(credentials).then(function (data) {

                localStorageService.set("auth", {
                    token: data.token
                });

                GebruikerService.find(JwtService.decodeToken(data.token).sub).then(function (gebruiker) {

                    $rootScope.id = gebruiker.id;
                    $rootScope.naam = gebruiker.gebruikersnaam;
                    $rootScope.rollen = gebruiker.rollen;
                    $rootScope.loggedIn = true;

                    $location.path("/");

                });

            });

        };

    }

    angular.module("kandoe").controller("LoginController", LoginController);

})(window.angular);