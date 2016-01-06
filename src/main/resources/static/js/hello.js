angular.module('dengoso', []).controller('MapCtrl', function ($scope, $http) {

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
            fillColor: '#777',
            fillOpacity: 0.1,
            strokeColor: '#AA0000',
            strokeOpacity: 0.8,
            strokeWeight: 2
        });
    }

    function iniciarMapa(focosDeDengue) {
        var zoomDefault = 16;

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

        addMarker($scope.map, myLatLng);

        addCircle($scope.map, myLatLng);

        $scope.map.addListener("click", function (event) {
            var latitude = event.latLng.lat();
            var longitude = event.latLng.lng();
            console.log(latitude + ', ' + longitude);

            addMarker($scope.map, event.latLng);

            addCircle($scope.map, event.latLng);
        });
    }

    $http.get('foco/').success(function (data) {
        iniciarMapa(data);
    });
});
