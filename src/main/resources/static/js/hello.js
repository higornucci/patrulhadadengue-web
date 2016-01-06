angular.module('dengoso', []).controller('MapCtrl', function ($scope, $http) {

    function adicionarMarcadorNoBanco(mapa, coordenadas) {
        var coordenadasParaEnvio = {
            latitude: coordenadas.lat,
            longitude: coordenadas.lng
        };
        $http.post('/foco', coordenadasParaEnvio).success(function(data, status, headers, config) {
			addMarker(mapa, coordenadas);

            addCircle(mapa, coordenadas);
		});
    }
    
    function addMarker(map, latLng) {
        var image = 'img/map-marker.png';
        new google.maps.Marker({
            position: latLng,
            map: map,
            title: 'Hello World!',
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

        var myLatLng = {
            lat: -20.496323,
            lng: -54.573407
        };

        $scope.map = new google.maps.Map(document.getElementById('mapa'), {
            zoom: zoomDefault,
            center: myLatLng,
            streetViewControl: true,
            mapTypeId: google.maps.MapTypeId.SATELLITE
        });

        var i, coordenadas;
        for(i = 0; i < focosDeDengue.length; i++){
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

    $http.get('foco/').success(function (data) {
        iniciarMapa(data);
    });
});
