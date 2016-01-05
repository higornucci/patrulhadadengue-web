package br.com.dengoso.modelo.coordenadas;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public final class Coordenadas {
	
	@Embedded
	private Latitude latitude;
	@Embedded
	private Longitude longitude;

	public Coordenadas(double latitude, double longitude) {
		this.latitude = new Latitude(latitude);
		this.longitude = new Longitude(longitude);
	}
	
	public double getLatitude() {
		return latitude.getValor();
	}
	
	public double getLongitude() {
		return longitude.getValor();
	}
}
