package br.com.dengoso.aplicacao.foco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dengoso.modelo.coordenadas.Coordenadas;
import br.com.dengoso.modelo.foco.FocoDeDengue;
import br.com.dengoso.modelo.foco.FocoDeDengueRepository;

@Service
public class AdicionaAdicionaFocoDeDengue {

	private final FocoDeDengueRepository focoDeDengueRepository;

	@Autowired
	public AdicionaAdicionaFocoDeDengue(FocoDeDengueRepository focoDeDengueRepository) {
		this.focoDeDengueRepository = focoDeDengueRepository;
	}

	public void adicionar(FocoDeDengueRequest focoDeDengueRequest) {
		Coordenadas coordenadas = new Coordenadas(focoDeDengueRequest.getLatitude(), focoDeDengueRequest.getLongitude());
		FocoDeDengue focoDeDengue = FocoDeDengue.criar(coordenadas);
		
		focoDeDengueRepository.save(focoDeDengue);
	}

}
