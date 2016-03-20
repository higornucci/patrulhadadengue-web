package br.com.dengoso.modelo.foco;

import br.com.dengoso.modelo.coordenadas.Coordenadas;
import br.com.dengoso.modelo.excecao.ExcecaoDeCampoObrigatorio;

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

	public FocoDeDengue criar() throws ExcecaoDeCampoObrigatorio {
		return FocoDeDengue.criar(coordenadas);
	}

}
