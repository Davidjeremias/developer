package br.com.u2d.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.u2d.model.Endereco;

public class EnderecoDao {

	EntityManagerFactory emf;
	EntityManager em;
	
	public EnderecoDao() {
		emf = Persistence.createEntityManagerFactory("web");
		em = emf.createEntityManager();
	}
	
	public void Salvar(Endereco endereco) {
		try {
			em.getTransaction().begin();
			em.merge(endereco);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			emf.close();
		}
	}
	
	public void Excluir(Endereco endereco) {
		try {
			em.getTransaction().begin();
			em.remove(endereco);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			emf.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Endereco> ListaEndereco(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select endereco from Endereco endereco");
		List<Endereco> enderecos = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return enderecos;
	}
}
