package br.com.dengoso.aplicacao.foco;

import br.com.dengoso.modelo.coordenadas.Coordenadas;
import br.com.dengoso.modelo.foco.FocoDeDengue;
import br.com.dengoso.modelo.foco.FocoDeDengueRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ConsultaFocoDeDengueTeste {

    private static final double  _20_496323D =  -20.496323d;
    private static final double  _20_496455D =  -20.496455d;
    private FocoDeDengueRepository focoDeDengueRepository;
    private Coordenadas coordenadas;

    @Before
    public void init() {
        coordenadas = Coordenadas.criar(_20_496323D, _20_496455D);
        focoDeDengueRepository = mock(FocoDeDengueRepository.class);
    }

    @Test
    public void deve_retornar_um_foco_pelo_seu_id() throws Exception {
        FocoDeDengue focoDeDengue = FocoDeDengue.criar(coordenadas);
        when(focoDeDengueRepository.findOne(anyLong())).thenReturn(focoDeDengue);
        ConsultaFocoDeDengue consultaFocoDeDengue = new ConsultaFocoDeDengue(focoDeDengueRepository);

        FocoDeDengueResponse focoDeDengueResponse = consultaFocoDeDengue.buscarUm(focoDeDengue.getId());

        FocoDeDengueResponse focoDeDengueResponseEsperado = criarResponse(focoDeDengue);
        assertThat(focoDeDengueResponse, is(equalTo(focoDeDengueResponseEsperado)));
    }

    private FocoDeDengueResponse criarResponse(FocoDeDengue focoDeDengue) {
        return new FocoDeDengueResponse(focoDeDengue.getId(), focoDeDengue.getLatitude(), focoDeDengue.getLongitude(), focoDeDengue.getRaioDoFoco());
    }
}
