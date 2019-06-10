package com.usjt.Aula3.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.usjt.Aula3.model.Cidade;
import com.usjt.Aula3.model.Dia;
import com.usjt.Aula3.model.Tempo;
import com.usjt.Aula3.persistence.JPAUtil;

public class TesteAdicaoDia {
	public static void main(String args[]) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Dia dia = new Dia();
		Tempo tempo = new Tempo();
		Cidade cidade = new Cidade();
		
		cidade.setNome("São Paulo");
		cidade.setLatitude(2.232323);
		cidade.setLongitude(3.34345);
		
		tempo.setTmax(4.0);
		tempo.setTmin(4.0);
		tempo.setHumidade(45.0);
		tempo.setDescricao("frio");
		tempo.setLatitude(4.55555);
		tempo.setLongitude(3.4444444444444);		
		tempo.setData("22-02-2018");
		
		dia.setNome("segunda");
		
		dia.setCidade(cidade);
		dia.setTempo(tempo);

		manager.persist(cidade);
		manager.persist(tempo);
		manager.persist(dia);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}
}
