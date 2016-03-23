package br.com.dengoso.aplicacao.foco;

import br.com.dengoso.modelo.foco.FocoDeDengue;
import br.com.dengoso.modelo.foco.FocoDeDengueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaFocoDeDengue {

	private final FocoDeDengueRepository focoDeDengueRepository;

	@Autowired
	public ConsultaFocoDeDengue(FocoDeDengueRepository focoDeDengueRepository) {
		this.focoDeDengueRepository = focoDeDengueRepository;
	}

	public FocoDeDengueResponse buscarUm(Long id) {
		FocoDeDengue focoDeDengue = focoDeDengueRepository.findOne(id);
		return criarRespostaUnica(focoDeDengue);
	}

	public List<FocoDeDengueResponse> buscarTodos() {
		List<FocoDeDengue> todosOsFocos = (List<FocoDeDengue>) focoDeDengueRepository.findAll();
		return criarResposta(todosOsFocos);
	}

	private List<FocoDeDengueResponse> criarResposta(List<FocoDeDengue> todosOsFocos) {
		return todosOsFocos.stream().map(this::criarRespostaUnica).collect(Collectors.toList());
	}

	private FocoDeDengueResponse criarRespostaUnica(FocoDeDengue focoDeDengue) {
		return new FocoDeDengueResponse(
                focoDeDengue.getId(),
                focoDeDengue.getLatitude(),
                focoDeDengue.getLongitude(),
                focoDeDengue.getRaioDoFoco());
	}
}
