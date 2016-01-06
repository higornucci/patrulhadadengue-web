package br.com.dengoso.aplicacao.foco;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dengoso.modelo.foco.FocoDeDengue;
import br.com.dengoso.modelo.foco.FocoDeDengueRepository;

@Service
public class ConsultaFocoDeDengue {

	private final FocoDeDengueRepository focoDeDengueRepository;

	@Autowired
	public ConsultaFocoDeDengue(FocoDeDengueRepository focoDeDengueRepository) {
		this.focoDeDengueRepository = focoDeDengueRepository;
	}

	public FocoDeDengueResponse buscarUm(Long id) {
		FocoDeDengue focoDeDengue = focoDeDengueRepository.findOne(id);
		return new FocoDeDengueResponse(focoDeDengue.getId(), focoDeDengue.getLatitude(), focoDeDengue.getLongitude());
	}

	public List<FocoDeDengueResponse> buscarTodos() {
		List<FocoDeDengue> todosOsFocos = (List<FocoDeDengue>) focoDeDengueRepository.findAll();
		return criarResposta(todosOsFocos);
	}

	private List<FocoDeDengueResponse> criarResposta(List<FocoDeDengue> todosOsFocos) {
		List<FocoDeDengueResponse> resposta = new ArrayList<>();
		for (FocoDeDengue focoDeDengue : todosOsFocos) {
			resposta.add(
					new FocoDeDengueResponse(
							focoDeDengue.getId(), 
							focoDeDengue.getLatitude(), 
							focoDeDengue.getLongitude()));
		}
		return resposta;
	}
}
