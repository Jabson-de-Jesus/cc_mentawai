package org.cejug.cc_mentawai.persistence;

import java.util.List;

import org.cejug.cc_mentawai.persistence.entity.Personagem;

/**
 * Interface com as operações de persistência.
 * 
 * @author Helio Frota http://www.heliofrota.com
 *
 */
public interface PersonagemPersistence {

	void persist(Personagem personagem);

	void remove(Personagem personagem);

	void merge(Personagem personagem);

	List<Personagem> getPersonagens();

	Personagem findById(int id);
	
}
