package br.com.dengoso.aplicacao.foco;

import javax.transaction.Transactional;

import br.com.dengoso.modelo.excecao.ExcecaoDeCampoObrigatorio;
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
	public void adicionar(FocoDeDengueRequest focoDeDengueRequest) throws ExcecaoDeCampoObrigatorio {
        FocoDeDengue focoDeDengue = criarFocoDeDengue(focoDeDengueRequest);

		focoDeDengueRepository.save(focoDeDengue);
		focoDeDengueRequest.setId(focoDeDengue.getId());
	}

    private FocoDeDengue criarFocoDeDengue(FocoDeDengueRequest focoDeDengueRequest) throws ExcecaoDeCampoObrigatorio {
        Coordenadas coordenadas = Coordenadas.criar(focoDeDengueRequest.getLatitude(), focoDeDengueRequest.getLongitude());
        FocoDeDengue focoDeDengue;
        if(focoNaoTemDescricao(focoDeDengueRequest)) {
            focoDeDengue = FocoDeDengue.criar(coordenadas);
        } else {
            focoDeDengue = FocoDeDengue.criar(coordenadas, focoDeDengueRequest.getDescricao());
        }
        return focoDeDengue;
    }

    private boolean focoNaoTemDescricao(FocoDeDengueRequest focoDeDengueRequest) {
        return focoDeDengueRequest.getDescricao().isEmpty();
    }

}
