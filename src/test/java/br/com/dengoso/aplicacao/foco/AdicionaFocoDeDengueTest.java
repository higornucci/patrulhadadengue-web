package br.com.dengoso.aplicacao.foco;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import br.com.dengoso.modelo.foco.FocoDeDengue;
import br.com.dengoso.modelo.foco.FocoDeDengueRepository;

public class AdicionaFocoDeDengueTest {

	private FocoDeDengueRepository focoDeDengueRepository;
	private double latitudeEsperada;
	private double longitudeEsperada;

	@Before
	public void init() {
		focoDeDengueRepository = mock(FocoDeDengueRepository.class);
		latitudeEsperada = -20.496323d;
		longitudeEsperada = -20.496323d;
	}

	@Test
	public void deve_ser_possivel_adicionar_um_foco_de_dengue() throws Exception {
		FocoDeDengueRequest focoDeDengueRequest = new FocoDeDengueRequest(latitudeEsperada, longitudeEsperada, "");

		new AdicionaFocoDeDengue(focoDeDengueRepository).adicionar(focoDeDengueRequest);

		verify(focoDeDengueRepository).save(any(FocoDeDengue.class));
	}

	@Test
	public void deve_ser_possivel_adicionar_um_foco_de_dengue_sem_descricao() throws Exception {
		FocoDeDengueRequest focoDeDengueRequest = new FocoDeDengueRequest(latitudeEsperada, longitudeEsperada, "");

		new AdicionaFocoDeDengue(focoDeDengueRepository).adicionar(focoDeDengueRequest);

		verify(focoDeDengueRepository).save(any(FocoDeDengue.class));
	}
}