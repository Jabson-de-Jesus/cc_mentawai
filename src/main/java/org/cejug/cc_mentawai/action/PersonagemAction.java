package org.cejug.cc_mentawai.action;

import org.cejug.cc_mentawai.persistence.PersonagemPersistence;
import org.cejug.cc_mentawai.persistence.entity.Personagem;
import org.mentawai.core.BaseAction;

/**
 * Action do mentawai.
 * @author Helio Frota http://www.heliofrota.com
 *
 */
public class PersonagemAction extends BaseAction {

	/**
	 * Persistencia injetada pelo mentaContainer.
	 */
	private PersonagemPersistence personagemPersistence;

	/**
	 * Construtor paramétrico usando constructor injection.
	 * 
	 * @param personagemPersistence PersonagemPersistence
	 */
	public PersonagemAction(PersonagemPersistence personagemPersistence) {
		this.personagemPersistence = personagemPersistence;
	}

	/**
	 * Método executado por padrão quando nenhuma ação interna da action é informada.
	 * @return String 
	 */
	public String execute() {
	
		getPersonagens();
		
		// Retorna success indicando que o forward e/ou redirect será feito para 
		// determinado destino especificado com sucesso. 
		// Isso está configurado na classe AppManager.
		return SUCCESS;
	}
	
	/**
	 * Preenche o formulário com informações para update.
	 * @return String
	 */
	public String prepareUpdate() {
		// Obtém o personagem da base de dados a partir do id.
		Personagem personagem = personagemPersistence.findById(input.getInt("id"));
		// Envia o objeto personagem para o output da action.
		output.setValue("personagem", personagem);
		
		getPersonagens();
		
		return SUCCESS; 
	}
	
	/**
	 * Salva ou atualiza o personagem. 
	 * @return String
	 */
	public String salvaOuAtualiza() {
		
		if (input.getString("personagemId") == null || input.getString("personagemId").trim().equals("")) {
			
			// Cria um novo objeto personagem.
			Personagem personagem = new Personagem();
			// Atualiza o nome do personagem que veio no post pelo input da action.
			personagem.setNome(input.getString("nome"));
			// Atualiza as informações do personagem no banco.
			personagemPersistence.persist(personagem);
			
			
		} else {

			// Obtém o personagem da base de dados a partir do id.
			Personagem personagem = personagemPersistence.findById(input.getInt("personagemId"));
			// Atualiza o nome do personagem que veio no post pelo input da action.
			personagem.setNome(input.getString("nome"));
			// Atualiza as informações do personagem no banco.
			personagemPersistence.merge(personagem);

		}
		
		getPersonagens();
		
		return SUCCESS; 
	}
	
	/**
	 * Remove o personagem do banco de dados.
	 * @return String
	 */
	public String remove() {
		
		// Obtém o personagem da base de dados a partir do id.
		Personagem personagem = personagemPersistence.findById(input.getInt("id"));
		// Remove o personagem do banco de dados.
		personagemPersistence.remove(personagem);
		
		getPersonagens();
		
		return SUCCESS; 
	}
	
	private void getPersonagens() {
		// Obtém todos os personagens do banco e envia para o output da action.
		output.setValue("personagens", personagemPersistence.getPersonagens());
	}
	

}
