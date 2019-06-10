package com.usjt.Aula3;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.usjt.Aula3.model.Cidade;
import com.usjt.Aula3.repository.TestCidadeLongitudeLatitudeNamedQuery;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLogintudeLogintudeNamedQuery {


	@Autowired
	private TestCidadeLongitudeLatitudeNamedQuery repo;
	
	@Test
	public void buscar() {
		List<Cidade> cidades = repo.findByLatitudeAndLongitude(2.232323, 3.34345);
		for(Cidade a : cidades) 
			System.out.println("Busca por latitude e longitude " + a.getNome());
	}
	
	@Test
	public void buscarNome() {
		List<Cidade> cidades = repo.findByNome("sao paulo");
		for(Cidade a: cidades)
			System.out.println("Busca por nome " + a.getNome());
	}
	
	
	
	@Test
	public void buscarPorNomeIgnorando() {
		String nome = "São Paulo";
		List<Cidade> cidades = repo.findByNome(nome.toLowerCase());
		for(Cidade a : cidades)
			System.out.println("Busca por nome ignorando maiusculas " + a.getNome());
	}
}
