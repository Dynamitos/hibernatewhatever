package dbUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import loggUtility.LoggerUtility;

public class DbConnector {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    
    public void initDb() throws Exception {
        if(emf == null || em == null) {
            //wenn eienr offen --> beide schließen
            closeDb();
        }
        
        emf = Persistence.createEntityManagerFactory("PU");
        em = emf.createEntityManager();
        
        //Logging ACTIVATED!!
        LoggerUtility.setShow(true);
        LoggerUtility.setWrite(true);
        
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public EntityManager getEm() {
        return em;
    }
    
    //Singleton
    private DbConnector() {
    }
    
    public static DbConnector getInstance() {
        return DbConnectorHolder.INSTANCE;
    }

    public void closeDb() throws Exception{
        if (em != null) {
            em.close();
        }
        if(emf != null) {
            emf.close();
        }
    }
    
    private static class DbConnectorHolder {

        private static final DbConnector INSTANCE = new DbConnector();
    }
}
