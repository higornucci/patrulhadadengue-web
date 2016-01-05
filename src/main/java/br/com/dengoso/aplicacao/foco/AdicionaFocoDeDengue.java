package br.com.dengoso.aplicacao.foco;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dengoso.modelo.coordenadas.Coordenadas;
import br.com.dengoso.modelo.foco.FocoDeDengue;
import br.com.dengoso.modelo.foco.FocoDeDengueRepository;

@Service
public class AdicionaFocoDeDengue {

	private final FocoDeDengueRepository focoDeDengueRepository;

	@Autowired
	public AdicionaFocoDeDengue(FocoDeDengueRepository focoDeDengueRepository) {
		this.focoDeDengueRepository = focoDeDengueRepository;
	}

	@Transactional
	public void adicionar(FocoDeDengueRequest focoDeDengueRequest) {
		Coordenadas coordenadas = Coordenadas.criar(focoDeDengueRequest.getLatitude(), focoDeDengueRequest.getLongitude());
		FocoDeDengue focoDeDengue = FocoDeDengue.criar(coordenadas);
		
		focoDeDengueRepository.save(focoDeDengue);
		focoDeDengueRequest.setId(focoDeDengue.getId());
	}

}
