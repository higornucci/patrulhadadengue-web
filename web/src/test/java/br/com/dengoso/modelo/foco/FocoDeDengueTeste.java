package br.com.dengoso.modelo.foco;

import br.com.dengoso.modelo.coordenadas.Coordenadas;
import br.com.dengoso.modelo.excecao.ExcecaoDeCampoObrigatorio;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FocoDeDengueTeste {
	@Test
	public void deve_poder_adicionar_coordenadas_a_um_foco_de_dengue() throws Exception {
		double latitudeEsperada =  -20.496323d;
		double longitudeEsperada =  -20.496323d;
		Coordenadas coordenadasEsperadas = Coordenadas.criar(latitudeEsperada, longitudeEsperada);
		
		FocoDeDengue focoDeDengue = FocoDeDengueBuilder.novo().localizadoNas(coordenadasEsperadas).criar();

		assertEquals(latitudeEsperada, focoDeDengue.getLatitude(), 0.001);
		assertEquals(latitudeEsperada, focoDeDengue.getLongitude(), 0.001);
	}

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void deve_ser_obrigatorio_informar_uma_latitude() throws Exception {
        double latitudeEsperada = 0;
        double longitudeEsperada =  -20.496323d;
        Coordenadas coordenadasEsperadas = Coordenadas.criar(latitudeEsperada, longitudeEsperada);

        FocoDeDengueBuilder.novo().localizadoNas(coordenadasEsperadas).criar();
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void deve_ser_obrigatorio_informar_uma_longitude() throws Exception {
        double latitudeEsperada = -20.496323d;
        double longitudeEsperada =  0;
        Coordenadas coordenadasEsperadas = Coordenadas.criar(latitudeEsperada, longitudeEsperada);

        FocoDeDengueBuilder.novo().localizadoNas(coordenadasEsperadas).criar();
    }
}
