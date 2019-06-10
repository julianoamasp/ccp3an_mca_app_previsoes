package com.usjt.Aula3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.usjt.Aula3.model.Cidade;
import com.usjt.Aula3.model.Dia;
import com.usjt.Aula3.model.Tempo;
import com.usjt.Aula3.persistence.JPAUtil;

@Service
public class DiaService {
	
	public void save(Dia dia, Tempo tempo, Cidade cidade) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		dia.setCidade(cidade);
		dia.setTempo(tempo);
		
		manager.persist(cidade);
		manager.persist(tempo);
		manager.persist(dia);
		transaction.commit();

	}
	
	public List<Dia> listar(){
	EntityManager manager = JPAUtil.getEntityManager();
	
	Query query = manager.createQuery("from Dia");
	List <Dia> dias = query.getResultList();
	return dias;
	}
}
