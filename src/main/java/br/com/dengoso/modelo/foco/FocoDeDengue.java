package br.com.dengoso.modelo.foco;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import br.com.dengoso.modelo.EntidadeBase;
import br.com.dengoso.modelo.coordenadas.Coordenadas;
import br.com.dengoso.modelo.excecao.ExcecaoDeCampoObrigatorio;

import java.util.Date;

@Entity
public final class FocoDeDengue extends EntidadeBase {

    private static final String DESCRICAO_PADRAO = "Possível criadouro do mosquito";
    @Embedded
	private Coordenadas coordenadas;
    private String descricao;
    private int raioDoFoco;
	private Date dataDeCriacao;

	FocoDeDengue() {
	}
	
	private FocoDeDengue(Coordenadas coordenadas, String descricao) {
        this.descricao = descricao;
		this.coordenadas = coordenadas;
		this.dataDeCriacao = new Date();
		this.raioDoFoco = 100;
	}

	public static FocoDeDengue criar(Coordenadas coordenadas) throws ExcecaoDeCampoObrigatorio {
        validarCamposObrigatorios(coordenadas, DESCRICAO_PADRAO);
        return new FocoDeDengue(coordenadas, DESCRICAO_PADRAO);
	}

    public static FocoDeDengue criar(Coordenadas coordenadas, String descricao) throws ExcecaoDeCampoObrigatorio {
        validarCamposObrigatorios(coordenadas, descricao);
       return new FocoDeDengue(coordenadas, descricao);
    }

    private static void validarCamposObrigatorios(Coordenadas coordenadas, String descricao) throws ExcecaoDeCampoObrigatorio {
        new ExcecaoDeCampoObrigatorio()
                .quandoZero(coordenadas.getLatitude(), "Uma latitude deve ser informada.")
                .quandoZero(coordenadas.getLongitude(), "Uma longitude deve ser informada.")
                .quandoNuloOuVazio(descricao, "Uma descricao deve ser informada.")
                .entaoDispara();
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

	public int getRaioDoFoco() {
		return this.raioDoFoco;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
