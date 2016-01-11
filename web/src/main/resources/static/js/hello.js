angular.module('dengoso', []).controller('MapCtrl', function ($scope, $http) {

    function adicionarMarcadorNoBanco(mapa, coordenadas) {
        var coordenadasParaEnvio = {
            latitude: coordenadas.lat,
            longitude: coordenadas.lng
        };
        $http.post('/focos', coordenadasParaEnvio).success(function (data, status, headers, config) {
            addMarker(mapa, coordenadas);

            addCircle(mapa, coordenadas);
        });
    }

    function addMarker(map, latLng) {
        var image = 'img/map-marker.png';
        new google.maps.Marker({
            position: latLng,
            map: map,
            title: 'Existe um foco de dengue aqui',
            icon: image
        });
    }

    function addCircle(map, latLng) {
        new google.maps.Circle({
            map: map,
            radius: 100,
            center: latLng,
            fillColor: '#AA6F39',
            fillOpacity: 0.3,
            strokeColor: '#AB5709',
            strokeOpacity: 0.7,
            strokeWeight: 2
        });
    }

    function iniciarMapa(focosDeDengue) {
        var zoomDefault = 17;

        var initialLocation;
        var campoGrande = {
            lat: -19.55722,
            lng: -53.35361
        };

        $scope.map = new google.maps.Map(document.getElementById('mapa'), {
            zoom: zoomDefault,
            streetViewControl: true,
            disableDoubleClickZoom: true,
            mapTypeId: google.maps.MapTypeId.SATELLITE
        });

        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                initialLocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
                $scope.map.setCenter(initialLocation);
            }, function () {
                $scope.map.setCenter(campoGrande);
            });
        } else {
            $scope.map.setCenter(campoGrande);
        }


        var i, coordenadas;
        for (i = 0; i < focosDeDengue.length; i++) {
            coordenadas = {
                lat: focosDeDengue[i].latitude,
                lng: focosDeDengue[i].longitude
            };
            addMarker($scope.map, coordenadas);

            addCircle($scope.map, coordenadas);
        }

        $scope.map.addListener("click", function (event) {
            coordenadas = {
                lat: event.latLng.lat(),
                lng: event.latLng.lng()
            };
            adicionarMarcadorNoBanco($scope.map, coordenadas);
        });
    }

    $http.get('focos/').success(function (data) {
        iniciarMapa(data);
    });
});
