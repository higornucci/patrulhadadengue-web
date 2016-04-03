package br.com.dengoso.aplicacao.foco;

public class FocoDeDengueResponse extends BaseResponse {

	private double latitude;
	private double longitude;
	private int raioDoFoco;
	private String descricao;

	public FocoDeDengueResponse(Long id, double latitude, double longitude, int raioDoFoco, String descricao) {
		super(id);
		this.latitude = latitude;
		this.longitude = longitude;
		this.raioDoFoco = raioDoFoco;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}
}
