package com.usjt.Aula3.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.usjt.Aula3.model.Cidade;
import com.usjt.Aula3.repository.TestCidadeLongitudeLatitude;

@RestController
@RequestMapping("/cidades")
public class CidadeResources {

	@Autowired
	private TestCidadeLongitudeLatitude repo;
	
	@GetMapping("/nome={nome}")
	public List<Cidade> listarPrimeiraLetra(@PathVariable String nome) {
		List<Cidade> cidades = repo.findAll();
		ArrayList<Cidade> cidadesRetorno = new ArrayList<Cidade>();

		for (Cidade cidade : cidades) {
			String nome1 = cidade.getNome().toString();
			if(!nome1.isEmpty() && nome1.substring(0,1).equals(nome.substring(0,1))) {
				cidadesRetorno.add(cidade);
			}
		}
		return cidadesRetorno;
	}

	@GetMapping("/listartodas")
	public List<Cidade> listarTodasCidades() {
		List<Cidade> cidades = repo.findAll();
		return cidades;
	}

	@GetMapping("/{latitude}/{longitude}")
	public List<Cidade> buscarLatitudeLongitude(@PathVariable Double latitude, @PathVariable Double longitude) {
		return repo.findByLatitudeAndLongitude(latitude, longitude);
	}

	@PostMapping("/salvar")
	// @ResponseStatus (HttpStatus.CREATED) agora desnecessária
	public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade, HttpServletResponse response) {
		Cidade l = repo.save(cidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}").buildAndExpand(l.getId())
				.toUri();
		// desnecessário também
		// response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(l);
	}

}
