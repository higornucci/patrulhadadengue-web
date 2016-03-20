package br.com.dengoso.modelo.coordenadas;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public final class Coordenadas {
	
	@Embedded
	private Latitude latitude;
	@Embedded
	private Longitude longitude;
	
	Coordenadas() {
	}

	private Coordenadas(double latitude, double longitude) {
		this.latitude = new Latitude(latitude);
		this.longitude = new Longitude(longitude);
	}
	
	public static Coordenadas criar(double latitude, double longitude) {
		return new Coordenadas(latitude, longitude);
	}
	
	public double getLatitude() {
		return latitude.getValor();
	}
	
	public double getLongitude() {
		return longitude.getValor();
	}
}
