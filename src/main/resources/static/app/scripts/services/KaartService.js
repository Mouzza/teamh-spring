(function (angular) {

    "use strict";

    function KaartService($http) {

        var exports = {};

        exports.find = function (kaartId) {

            return $http.get("/api/kaarten/" + kaartId).then(function (response) {
                return response.data;
            });

        };

        exports.update = function (kaart) {

            return $http.put("/api/kaarten/" + kaart.id, kaart).then(function (response) {
                return response.data;
            });

        };

        exports.createKaart = function (cirkelsessieId, kaart) {

            return $http.post("/api/cirkelsessies/" + cirkelsessieId + "/spelkaarten", kaart).then(function (response) {
                return response.data;
            });

        };

        exports.delete = function (id) {
            return $http.delete("/api/kaarten/" + id).then(function (response) {
                return response.data;
            });

        };


        exports.createKaartForSubthema = function (subthemaId, kaart) {

            return $http.post("/api/subthemas/" + subthemaId + "/kaart", kaart).then(function (response) {
                return response.data;
            });

        };

        exports.verschuifKaart = function (spelkaartId) {

            return $http.post("/api/spelkaarten/" + spelkaartId + "/verschuif").then(function (response) {
                return response.data;
            });

        };

        exports.getGebruiker = function (id) {

            return $http.get("/api/kaarten/" + id + "/gebruiker").then(function (response) {
                return response.data;
            });

        };

        exports.getKaarten = function (subthemaId) {

            return $http.get("/api/subthemas/" + subthemaId + "/kaarten").then(function (response) {
                return response.data;
            });

        };

        exports.getComments = function (kaartId) {

            return $http.get("/api/kaarten/" + kaartId + "/commentaren").then(function (response) {
                return response.data;
            });

        };

        exports.createComment = function (kaartId, comment) {

            return $http.post("/api/kaarten/" + kaartId + "/commentaren", comment).then(function (response) {
                return response.data;
            });

        };

        return exports;

    }

    angular.module("kandoe").factory("KaartService", KaartService);

})(window.angular);
