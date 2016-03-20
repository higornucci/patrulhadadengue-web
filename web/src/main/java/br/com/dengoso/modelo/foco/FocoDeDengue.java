package br.com.dengoso.modelo.foco;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import br.com.dengoso.modelo.EntidadeBase;
import br.com.dengoso.modelo.coordenadas.Coordenadas;
import br.com.dengoso.modelo.excecao.ExcecaoDeCampoObrigatorio;

import java.util.Date;

@Entity
public final class FocoDeDengue extends EntidadeBase {
	
	@Embedded
	private Coordenadas coordenadas;
	private Date dataDeCriacao;

	FocoDeDengue() {
	}
	
	private FocoDeDengue(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
		this.dataDeCriacao = new Date();
	}

	public static FocoDeDengue criar(Coordenadas coordenadas) throws ExcecaoDeCampoObrigatorio {
		new ExcecaoDeCampoObrigatorio()
				.quandoZero(coordenadas.getLatitude(), "Uma latitude deve ser informada.")
                .quandoZero(coordenadas.getLongitude(), "Uma longitude deve ser informada.")
				.entaoDispara();
		return new FocoDeDengue(coordenadas);
	}

	public double getLatitude() {
		return coordenadas.getLatitude();
	}

	public double getLongitude() {
		return coordenadas.getLongitude();
	}

	public Date getDataDeCriacao() {
		return this.dataDeCriacao;
	}
}
