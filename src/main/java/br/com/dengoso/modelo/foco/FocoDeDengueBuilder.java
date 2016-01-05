package br.com.dengoso.modelo.foco;

import br.com.dengoso.modelo.coordenadas.Coordenadas;

public final class FocoDeDengueBuilder {
	
	private Coordenadas coordenadas;

	private FocoDeDengueBuilder() {
	}

	public static FocoDeDengueBuilder novo() {
		return new FocoDeDengueBuilder();
	}

	public FocoDeDengueBuilder localizadoNas(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
		return this;
	}

	public FocoDeDengue criar() {
		return FocoDeDengue.criar(coordenadas);
	}

}
