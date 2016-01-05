package br.com.dengoso.aplicacao.foco;

public class FocoDeDengueRequest {

	private double latitude;
	private double longitude;

	public FocoDeDengueRequest(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
}
