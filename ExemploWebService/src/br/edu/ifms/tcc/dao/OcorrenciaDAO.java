package br.edu.ifms.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifms.tcc.model.Cidadao;
import br.edu.ifms.tcc.model.Ocorrencia;
import br.edu.ifms.tcc.util.JPAUtil;

public class OcorrenciaDAO {

	private EntityManager em;
	
	public boolean salva(Ocorrencia ocorrencia) {
		try {
			em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			String cpf = ocorrencia.getCidadao().getCpf();
			Cidadao cidadao = em.find(Cidadao.class, cpf);
			if(cidadao == null) {
				cidadao = ocorrencia.getCidadao();
				em.persist(cidadao);
				cidadao = em.find(Cidadao.class, cpf);
			} else {
				cidadao = em.merge(cidadao);
			}
			ocorrencia.setCidadao(cidadao);
			em.persist(ocorrencia);
			transacao.commit();
			em.close();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ocorrencia> recuperaTodos() {
		em = JPAUtil.getEntityManager();
		Query query = em.createQuery("FROM Ocorrencia ORDER BY dataHorario DESC");
		List<Ocorrencia> ocorrencias = query.getResultList();
		return ocorrencias;
	}
	
}
