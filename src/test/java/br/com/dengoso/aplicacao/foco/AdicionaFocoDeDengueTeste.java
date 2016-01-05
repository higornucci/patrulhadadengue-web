package br.com.dengoso.aplicacao.foco;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.dengoso.modelo.foco.FocoDeDengue;
import br.com.dengoso.modelo.foco.FocoDeDengueRepository;
import demo.RepositoryConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class AdicionaFocoDeDengueTeste {
	
	@Autowired
	private AdicionaFocoDeDengue adicionaFocoDeDengue;
	
	@Autowired
	private ConsultaFocoDeDengue consultaFocoDeDengue;
	
	@Test
	public void deve_ser_possivel_adicionar_um_foco_de_dengue() throws Exception {
		FocoDeDengueRepository focoDeDengueRepository = mock(FocoDeDengueRepository.class);
		double latitudeEsperada = -20.496323d;
		double longitudeEsperada = -20.496323d;
		FocoDeDengueRequest focoDeDengueRequest = new FocoDeDengueRequest(latitudeEsperada, longitudeEsperada);

		new AdicionaFocoDeDengue(focoDeDengueRepository).adicionar(focoDeDengueRequest);

		verify(focoDeDengueRepository).save(any(FocoDeDengue.class));
	}
	
	@Test
	public void deve_ser_possivel_adicionar_um_foco_de_dengue_no_banco_de_dados() throws Exception {
		double latitudeEsperada = -20.496323d;
		double longitudeEsperada = -20.496323d;
		FocoDeDengueRequest focoDeDengueRequest = new FocoDeDengueRequest(latitudeEsperada, longitudeEsperada);

		adicionaFocoDeDengue.adicionar(focoDeDengueRequest);

		FocoDeDengueResponse focoDeDengueResponse = consultaFocoDeDengue.buscarPorId(1l);
		assertEquals(latitudeEsperada, focoDeDengueResponse.getLatitude(), 0.001);
		assertEquals(longitudeEsperada, focoDeDengueResponse.getLongitude(), 0.001);
	}
}