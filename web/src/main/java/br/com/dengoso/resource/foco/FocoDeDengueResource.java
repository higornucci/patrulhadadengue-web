package br.com.dengoso.resource.foco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/focos")
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
		FocoDeDengueRequest focoDeDengue = new FocoDeDengueRequest(focoDeDengueRequest.getLatitude(), focoDeDengueRequest.getLongitude());
		adicionaFocoDeDengue.adicionar(focoDeDengue);
		System.out.println(focoDeDengue.getLatitude() + ", " + focoDeDengue.getLongitude());

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(focoDeDengue.getId()).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<FocoDeDengueResponse> buscarTodos() {
		return consultaFocoDeDengue.buscarTodos();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public FocoDeDengueResponse buscarUm(@PathVariable Long id) {
		System.out.println(id);
		return consultaFocoDeDengue.buscarUm(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void remover(@PathVariable String id) {
	}
}
