package org.cejug.cc_mentawai;

import javax.persistence.EntityManager;

import org.cejug.cc_mentawai.action.PersonagemAction;
import org.cejug.cc_mentawai.persistence.PersonagemPersistence;
import org.cejug.cc_mentawai.persistence.PersonagemPersistenceImpl;
import org.mentawai.core.ApplicationManager;
import org.mentawai.db.JPAHandler;
import org.mentawai.filter.MentaContainerFilter;

/**
 * Classe de configuração do mentawai.
 * @author Helio Frota http://www.heliofrota.com
 *
 */
public class AppManager extends ApplicationManager {

	/**
	 * Carrega os filtros globais da aplicação.
	 */
	@Override
	public void loadFilters() {
		// Configurando o mentaContainerFilter que cuidará do IOC.
		filter(new MentaContainerFilter());
	}

	/**
	 * Configura o ioc.
	 */
	@Override
	public void setupIoC() {

		/*
		 * O parametro false no JPAHandler indica que o desenvolvedor sera
		 * responsavel por tratar a transação do entityManager.
		 */
		ioc(EntityManager.class, new JPAHandler("cc_mentawai_pu", false));

		/*
		 * Configurando interfaces com devidas implementacoes para serem
		 * injetadas via construtor nas classes.
		 */
		ioc(PersonagemPersistence.class, PersonagemPersistenceImpl.class);
	}
	
	/**
	 * Configura as actions.
	 */
	@Override
    public void loadActions() {
		
		// Ao acessar essa action e o retorno for SUCCESS "ok" faz o forward para personagem.jsp 
        action(PersonagemAction.class).fwdOk("personagem.jsp");
        action("PersonagemAction.salvaOuAtualiza", PersonagemAction.class).fwdOk("personagem.jsp");
        action("PersonagemAction.prepareUpdate", PersonagemAction.class).fwdOk("personagem.jsp");
        action("PersonagemAction.remove", PersonagemAction.class).fwdOk("personagem.jsp");
        
	}

}
