package br.com.dengoso.modelo.coordenadas;

public final class Coordenadas {
	
	private Latitude latitude;
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
