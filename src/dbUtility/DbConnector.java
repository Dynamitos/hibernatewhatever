package dbUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import loggUtility.LoggerUtility;

public class DBConnector {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;

    public void initDb() throws Exception {
        if (emf == null || em == null) {
            //NUR wenn einer der beiden offen => dann beide schließen
            closeDb();
        }
        //Erzeugen
        emf = Persistence.createEntityManagerFactory("puVK");
        em = emf.createEntityManager();
        
        //Logging
        LoggerUtility.setShow(true);
        LoggerUtility.setWrite(true);
    }

    public void closeDb() throws Exception {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public EntityManager getEm() {
        return em;
    }
    
    

    private DBConnector() {
    }

    public static DBConnector getInstance() {
        return DBConnectorHolder.INSTANCE;
    }

    private static class DBConnectorHolder {

        private static final DBConnector INSTANCE = new DBConnector();
    }
}
