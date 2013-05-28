package org.cejug.cc_mentawai;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.eclipse.persistence.config.PersistenceUnitProperties;

/**
 * Listener que cria o contexto do JPA para geração do DDL.
 * 
 * @author helio frota http://www.heliofrota.com
 * 
 */
@WebListener()
public class DataBaseSetupListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		// Mapa para guardar as propriedades que também são definidas no persistence.xml
        // Mas aqui no caso faremos programaticamente.
        Map<String, String> persistenceUnitProperties = new HashMap<>();
        // Propriedade para criar as tabelas também existe na versão xml.
        persistenceUnitProperties.put(PersistenceUnitProperties.DDL_GENERATION, "create-tables");
        // Vai gerar no banco e não criar script de criação.
        persistenceUnitProperties.put(PersistenceUnitProperties.DDL_GENERATION_MODE, "database");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cc_mentawai_pu", persistenceUnitProperties);
		emf.createEntityManager();
	}
}
