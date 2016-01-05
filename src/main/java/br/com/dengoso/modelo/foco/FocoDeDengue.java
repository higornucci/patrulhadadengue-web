package br.com.dengoso.modelo.foco;

import br.com.dengoso.modelo.coordenadas.Coordenadas;

public final class FocoDeDengue {

	private Coordenadas coordenadas;

	private FocoDeDengue(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
	}

	public static FocoDeDengue criar(Coordenadas coordenadas) {
		return new FocoDeDengue(coordenadas);
	}

	public double getLatitude() {
		return coordenadas.getLatitude();
	}

	public double getLongitude() {
		return coordenadas.getLongitude();
	}
}
