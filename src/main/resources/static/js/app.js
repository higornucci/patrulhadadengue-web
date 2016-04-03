angular.module('module.mapa', [])
    .controller('MapCtrl', ['$http', function ($http) {

        function adicionarBotaoMinhaLocalizacao(mapa, initialLocation) {
            var controlDiv = document.createElement('div');

            var firstChild = document.createElement('button');
            firstChild.style.backgroundColor = '#fff';
            firstChild.style.border = 'none';
            firstChild.style.outline = 'none';
            firstChild.style.width = '28px';
            firstChild.style.height = '28px';
            firstChild.style.borderRadius = '2px';
            firstChild.style.boxShadow = '0 1px 4px rgba(0,0,0,0.3)';
            firstChild.style.cursor = 'pointer';
            firstChild.style.marginRight = '10px';
            firstChild.style.padding = '0';
            firstChild.title = 'Sua localização';
            controlDiv.appendChild(firstChild);

            var secondChild = document.createElement('div');
            secondChild.style.margin = '5px';
            secondChild.style.width = '18px';
            secondChild.style.height = '18px';
            secondChild.style.backgroundImage = 'url(https://maps.gstatic.com/tactile/mylocation/mylocation-sprite-2x.png)';
            secondChild.style.backgroundSize = '180px 18px';
            secondChild.style.backgroundPosition = '0 0';
            secondChild.style.backgroundRepeat = 'no-repeat';
            firstChild.appendChild(secondChild);

            google.maps.event.addListener(mapa, 'center_changed', function () {
                secondChild.style['background-position'] = '0 0';
            });

            firstChild.addEventListener('click', function () {
                mapa.setCenter(initialLocation);
            });

            controlDiv.index = 1;
            mapa.controls[google.maps.ControlPosition.RIGHT_BOTTOM].push(controlDiv);
        }

        function adicionarMarcadorNoBanco(mapa, coordenadas, descricaoDoFoco) {
            var focoDeDengueASerCadastrado = {
                latitude: coordenadas.lat,
                longitude: coordenadas.lng,
                descricao: descricaoDoFoco
            };
            $http.post('/focos', focoDeDengueASerCadastrado).success(function () {
                adicionarFoco(mapa, coordenadas, descricaoDoFoco, 100);
            });
        }

        function adicionarFoco(mapa, latLng, descricaoDoFoco, raio) {
            var image = 'img/map-marker.png';
            new google.maps.Marker({
                position: latLng,
                map: mapa,
                title: descricaoDoFoco,
                icon: image
            });
            adicionarRaioDoFoco(mapa, latLng, raio);
        }

        function adicionarRaioDoFoco(mapa, latLng, raio) {
            new google.maps.Circle({
                map: mapa,
                radius: raio,
                center: latLng,
                fillColor: '#AA6F39',
                fillOpacity: 0.3,
                strokeColor: '#AB5709',
                strokeOpacity: 0.7,
                strokeWeight: 2
            });
        }

        function iniciarMapa(focosDeDengue) {

            var zoomPadrao = 17;

            var initialLocation;
            var campoGrande = {
                lat: -19.55722,
                lng: -53.35361
            };

            var mapa = new google.maps.Map(document.getElementById('mapa'), {
                zoom: zoomPadrao,
                streetViewControl: true,
                disableDoubleClickZoom: true,
                mapTypeId: google.maps.MapTypeId.SATELLITE
            });

            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(function (position) {
                    initialLocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
                    mapa.setCenter(initialLocation);
                    adicionarBotaoMinhaLocalizacao(mapa, initialLocation);
                }, function () {
                    mapa.setCenter(campoGrande);
                });
            } else {
                mapa.setCenter(campoGrande);
            }


            var i, coordenadas;
            for (i = 0; i < focosDeDengue.length; i++) {
                coordenadas = {
                    lat: focosDeDengue[i].latitude,
                    lng: focosDeDengue[i].longitude
                };
                var raio = focosDeDengue[i].raioDoFoco;
                var descricao = focosDeDengue[i].descricao;
                adicionarFoco(mapa, coordenadas, descricao, raio);
            }

            mapa.addListener("click", function (event) {
                coordenadas = {
                    lat: event.latLng.lat(),
                    lng: event.latLng.lng()
                };
                adicionarMarcadorNoBanco(mapa, coordenadas, '');
            });
        }

        $http({
            method: 'GET',
            url: 'focos/'
        }).then(function successCallback(response) {
            iniciarMapa(response.data);
        }, function errorCallback() {
            $log.error('Não foi possível encontrar os focos');
        });

    }]);