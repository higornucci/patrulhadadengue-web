package br.com.dengoso.aplicacao.foco;

import br.com.dengoso.modelo.coordenadas.Coordenadas;
import br.com.dengoso.modelo.foco.FocoDeDengue;
import br.com.dengoso.modelo.foco.FocoDeDengueBuilder;
import br.com.dengoso.modelo.foco.FocoDeDengueRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ConsultaFocoDeDengueTeste {

    private static final double _20_496323D = -20.496323d;
    private static final double _20_496455D = -20.496455d;
    private FocoDeDengueRepository focoDeDengueRepository;
    private Coordenadas coordenadas;

    @Before
    public void init() {
        coordenadas = Coordenadas.criar(_20_496323D, _20_496455D);
        focoDeDengueRepository = mock(FocoDeDengueRepository.class);
    }

    @Test
    public void deve_retornar_um_foco_pelo_seu_id() throws Exception {
        FocoDeDengue focoDeDengue = FocoDeDengueBuilder.novo().localizadoNas(coordenadas).criar();
        when(focoDeDengueRepository.findOne(anyLong())).thenReturn(focoDeDengue);
        ConsultaFocoDeDengue consultaFocoDeDengue = new ConsultaFocoDeDengue(focoDeDengueRepository);

        FocoDeDengueResponse focoDeDengueResponse = consultaFocoDeDengue.buscarUm(focoDeDengue.getId());

        FocoDeDengueResponse focoDeDengueResponseEsperado = criarResponse(focoDeDengue);
        assertThat(focoDeDengueResponse, is(equalTo(focoDeDengueResponseEsperado)));
    }

    @Test
    public void deve_retornar_todos_os_focos() throws Exception {
        FocoDeDengue focoDeDengue1 = FocoDeDengueBuilder.novo().localizadoNas(coordenadas).criar();
        FocoDeDengue focoDeDengue2 = FocoDeDengueBuilder.novo().localizadoNas(coordenadas).criar();
        when(focoDeDengueRepository.findAll()).thenReturn(Arrays.asList(focoDeDengue1, focoDeDengue2));
        ConsultaFocoDeDengue consultaFocoDeDengue = new ConsultaFocoDeDengue(focoDeDengueRepository);

        List<FocoDeDengueResponse> focosDeDengue = consultaFocoDeDengue.buscarTodos();

        assertThat(focosDeDengue, contains(criarResponse(focoDeDengue1), criarResponse(focoDeDengue2)));
    }

    @Test
    public void deve_retornar_os_focos_com_sua_descricao() throws Exception {
        FocoDeDengue focoDeDengue1 = FocoDeDengueBuilder.novo().localizadoNas(coordenadas).criar();
        when(focoDeDengueRepository.findAll()).thenReturn(Collections.singletonList(focoDeDengue1));
        ConsultaFocoDeDengue consultaFocoDeDengue = new ConsultaFocoDeDengue(focoDeDengueRepository);

        List<FocoDeDengueResponse> focosDeDengue = consultaFocoDeDengue.buscarTodos();

        assertThat(focosDeDengue.stream().findFirst().get().getDescricao(),
                is(criarResponse(focoDeDengue1).getDescricao()));
    }

    private FocoDeDengueResponse criarResponse(FocoDeDengue focoDeDengue) {
        return new FocoDeDengueResponse(focoDeDengue.getId(), focoDeDengue.getLatitude(), focoDeDengue.getLongitude(),
                focoDeDengue.getRaioDoFoco(), focoDeDengue.getDescricao());
    }
}
