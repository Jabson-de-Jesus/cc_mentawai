package org.cejug.cc_mentawai.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.cejug.cc_mentawai.persistence.entity.Personagem;

/**
 * Classe que irá cuidar da persistência de personagem.
 * @author Helio Frota http://www.heliofrota.com
 *
 */
public class PersonagemPersistenceImpl implements PersonagemPersistence {

	/**
	 * EntityManager que será injetado via construtor pelo MentaContainer.
	 */
	private EntityManager entityManager;

	public PersonagemPersistenceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Persiste um personagem no banco de dados.
	 * 
	 * @param personagem Personagem
	 */
	public void persist(Personagem personagem) {
		// Inicia a transação.
		entityManager.getTransaction().begin();
		// Persiste.
		entityManager.persist(personagem);
		// Comita a transação.
		entityManager.getTransaction().commit();
	}

	/**
	 * Remove um personagem no banco de dados.
	 * 
	 * @param personagem Personagem
	 */
	public void remove(Personagem personagem) {
		// Inicia a transação.
		entityManager.getTransaction().begin();
		// Remove.
		entityManager.remove(personagem);
		// Comita a transação.
		entityManager.getTransaction().commit();
	}

	/**
	 * Atualiza um personagem no banco de dados.
	 * 
	 * @param personagem Personagem
	 */
	public void merge(Personagem personagem) {
		// Inicia a transação.
		entityManager.getTransaction().begin();
		// Atualiza.
		entityManager.merge(personagem);
		// Comita a transação.
		entityManager.getTransaction().commit();
	}

	/**
	 * Lista todos os personagens cadastrados no banco de dados.
	 * 
	 * @return List < Personagem >
	 */
	public List<Personagem> getPersonagens() {
		return entityManager.createQuery("select p from Personagem p", Personagem.class).getResultList();
	}

	/**
	 * Busca um personagem pelo id.
	 * 
	 * @param int id
	 * @return Personagem
	 */
	public Personagem findById(int id) {
		return entityManager.find(Personagem.class, id);
	}

}
