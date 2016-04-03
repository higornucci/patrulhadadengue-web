package br.com.dengoso.aplicacao.foco;

public class FocoDeDengueRequest extends BaseRequest {

	private double latitude;
	private double longitude;
	private String descricao;

    public FocoDeDengueRequest() {
    }

	public FocoDeDengueRequest(double latitude, double longitude, String descricao) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.descricao = descricao;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
