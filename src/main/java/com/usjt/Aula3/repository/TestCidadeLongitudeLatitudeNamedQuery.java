package com.usjt.Aula3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import com.usjt.Aula3.model.Cidade;

public interface TestCidadeLongitudeLatitudeNamedQuery extends JpaRepository<Cidade, Long> {

	@Async
	public List <Cidade> findByLatitudeAndLongitude(@Param("latitude") Double latitude, @Param("longitude") Double longitude);
	
	@Async
	public List<Cidade> findByNome(@Param ("nome") String nome);
}
