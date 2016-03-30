package br.com.dengoso.aplicacao.foco;

public class FocoDeDengueRequest {

	private double latitude;
	private double longitude;
	private Long id;
	
	public FocoDeDengueRequest() {
	}

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

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}
