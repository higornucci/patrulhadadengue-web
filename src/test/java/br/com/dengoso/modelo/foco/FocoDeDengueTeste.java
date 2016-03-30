package br.com.dengoso.modelo.foco;

import br.com.dengoso.modelo.coordenadas.Coordenadas;
import br.com.dengoso.modelo.excecao.ExcecaoDeCampoObrigatorio;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.exparity.hamcrest.date.DateMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.assertEquals;

public class FocoDeDengueTeste {

    private static final double  _20_496323D =  -20.496323d;
    private static final double  _20_496455D =  -20.496455d;

	@Test
	public void deve_poder_adicionar_coordenadas_a_um_foco_de_dengue() throws Exception {
		double latitudeEsperada =  _20_496323D;
		double longitudeEsperada =  _20_496455D;
		Coordenadas coordenadasEsperadas = Coordenadas.criar(latitudeEsperada, longitudeEsperada);
		
		FocoDeDengue focoDeDengue = FocoDeDengueBuilder.novo().localizadoNas(coordenadasEsperadas).criar();

		assertEquals(latitudeEsperada, focoDeDengue.getLatitude(), 0.001);
		assertEquals(latitudeEsperada, focoDeDengue.getLongitude(), 0.001);
	}

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void deve_ser_obrigatorio_informar_uma_latitude() throws Exception {
        double latitudeEsperada = 0;
        double longitudeEsperada =  _20_496455D;
        Coordenadas coordenadasEsperadas = Coordenadas.criar(latitudeEsperada, longitudeEsperada);

        FocoDeDengueBuilder.novo().localizadoNas(coordenadasEsperadas).criar();
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void deve_ser_obrigatorio_informar_uma_longitude() throws Exception {
        double latitudeEsperada =  _20_496323D;
        double longitudeEsperada =  0;
        Coordenadas coordenadasEsperadas = Coordenadas.criar(latitudeEsperada, longitudeEsperada);

        FocoDeDengueBuilder.novo().localizadoNas(coordenadasEsperadas).criar();
    }

    @Test
    public void deve_registrar_o_momento_de_criacao_do_foco_de_dengue() throws Exception{
        Coordenadas coordenadasEsperadas = Coordenadas.criar(_20_496323D, _20_496455D);
        FocoDeDengue focoDeDengue = FocoDeDengueBuilder.novo().localizadoNas(coordenadasEsperadas).criar();

        assertThat(focoDeDengue.getDataDeCriacao(), isToday());
    }

    @Test
    public void todo_foco_criado_deve_conter_a_distancia_que_o_mosquito_costuma_permenecer_longe_de_seu_foco() throws Exception {
        int raioEsperado = 100;
        Coordenadas coordenadasEsperadas = Coordenadas.criar(_20_496323D, _20_496455D);

        FocoDeDengue focoDeDengue = FocoDeDengueBuilder.novo().localizadoNas(coordenadasEsperadas).criar();

        assertThat(focoDeDengue.getRaioDoFoco(), is(raioEsperado));
    }
}
