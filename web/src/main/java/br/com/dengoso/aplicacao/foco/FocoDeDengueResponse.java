package br.com.dengoso.aplicacao.foco;

public class FocoDeDengueResponse extends BaseResponse {

	private double latitude;
	private double longitude;
	private int raioDoFoco;

	public FocoDeDengueResponse(Long id, double latitude, double longitude, int raioDoFoco) {
		super(id);
		this.latitude = latitude;
		this.longitude = longitude;
		this.raioDoFoco = raioDoFoco;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public int getRaioDoFoco() {
		return this.raioDoFoco;
	}
}
