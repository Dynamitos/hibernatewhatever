package dbUtility;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import pojo.Konto;

public class DbAccessBase<T> {

    private EntityManager em = null;

    private String entity_T;
    private Class class_T;

    public DbAccessBase(String entity_T, Class class_T) throws Exception {
        em = DbConnector.getInstance().getEm();
        this.entity_T = entity_T;
        this.class_T = class_T;
    }

    public List<T> read() throws Exception {
        TypedQuery query;
        query = em.createQuery(" FROM " + entity_T, class_T);
        em.getTransaction().begin();
        List<T> liste = query.getResultList();
        em.getTransaction().commit();
        
        return liste;
    }

    public void add(T... pojos) throws Exception {
        for (T pojo : pojos) {
            em.persist(pojo);
        }
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
    

}
