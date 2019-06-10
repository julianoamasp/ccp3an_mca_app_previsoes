package com.usjt.Aula3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import com.usjt.Aula3.model.Cidade;

public interface TestCidadeLongitudeLatitude extends JpaRepository<Cidade, Long>{

	@Async
	@Query("SELECT cid FROM Cidade cid WHERE latitude = :latitude AND longitude = :longitude")
	public List <Cidade> findByLatitudeAndLongitude (@Param("latitude") Double latitude, @Param("longitude") Double longitude);
	
	@Async
	@Query("SELECT cid FROM Cidade cid WHERE cid.nome = :nome")
	public List<Cidade> findByNome(@Param ("nome") String nome);
	
	
}
