package br.com.dengoso.resource.foco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dengoso.aplicacao.foco.AdicionaFocoDeDengue;
import br.com.dengoso.aplicacao.foco.ConsultaFocoDeDengue;
import br.com.dengoso.aplicacao.foco.FocoDeDengueRequest;
import br.com.dengoso.aplicacao.foco.FocoDeDengueResponse;

@RestController
@RequestMapping("/foco")
public class FocoDeDengueResource {

	private final AdicionaFocoDeDengue adicionaFocoDeDengue;
	private final ConsultaFocoDeDengue consultaFocoDeDengue;

	@Autowired
	public FocoDeDengueResource(AdicionaFocoDeDengue adicionaFocoDeDengue, ConsultaFocoDeDengue consultaFocoDeDengue) {
		this.adicionaFocoDeDengue = adicionaFocoDeDengue;
		this.consultaFocoDeDengue = consultaFocoDeDengue;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> registrarFocoDeDengue(@RequestBody FocoDeDengueRequest focoDeDengueRequest) {
		adicionaFocoDeDengue.adicionar(focoDeDengueRequest);
		System.out.println(focoDeDengueRequest.getLatitude() + ", " + focoDeDengueRequest.getLongitude());

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(focoDeDengueRequest.getId()).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<FocoDeDengueResponse> buscarTodos() {
		return consultaFocoDeDengue.buscarTodos();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void remover(@PathVariable String id) {
	}
}
