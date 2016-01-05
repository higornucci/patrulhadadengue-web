package br.com.dengoso.modelo.foco;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.dengoso.modelo.coordenadas.Coordenadas;

public class FocoDeDengueTeste {
	@Test
	public void deve_poder_adicionar_coordenadas_a_um_foco_de_dengue() throws Exception {
		double latitudeEsperada =  -20.496323d;
		double longitudeEsperada =  -20.496323d;
		Coordenadas coordenadasEsperadas = new Coordenadas(latitudeEsperada, longitudeEsperada);
		
		FocoDeDengue focoDeDengue = FocoDeDengueBuilder.novo().localizadoNas(coordenadasEsperadas).criar();
		
		assertEquals(latitudeEsperada, focoDeDengue.getLatitude(), 0.001);
		assertEquals(latitudeEsperada, focoDeDengue.getLongitude(), 0.001);
	}
}
