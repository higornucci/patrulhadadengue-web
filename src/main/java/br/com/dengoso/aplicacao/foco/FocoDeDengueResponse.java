package br.com.dengoso.aplicacao.foco;

public class FocoDeDengueResponse {

	private long id;
	private double latitude;
	private double longitude;

	public FocoDeDengueResponse(long id, double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public long getId() {
		return id;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
}
