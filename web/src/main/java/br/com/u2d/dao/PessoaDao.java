package br.com.u2d.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.u2d.model.Pessoa;

public class PessoaDao {

	EntityManagerFactory emf;
	EntityManager em;
	
	public PessoaDao() {
		emf = Persistence.createEntityManagerFactory("web");
		em = emf.createEntityManager();
	}
	
	public void Salvar(Pessoa pessoa) {
		try {
			em.getTransaction().begin();
			em.merge(pessoa);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			emf.close();
		}
	}
	
	public void Excluir(Pessoa pessoa) {
		try {
			em.getTransaction().begin();
			em.remove(pessoa);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			emf.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> ListaPessoas(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select pessoa from Pessoa pessoa");
		List<Pessoa> pessoas = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return pessoas;
	}
}
