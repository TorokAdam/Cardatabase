package hu.cardatabase.persistence.entitymanager;

import hu.cardatabase.persistence.entity.CarsEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CarsDao {

    @PersistenceContext(unitName = "msSqlConn")
    protected EntityManager em;

    public void save(CarsEntity t) {
        em.merge(t);
        em.flush();
    }

    public void delete(CarsEntity t) {
        em.remove(t);
    }

    public CarsEntity findOne(Long carId) {
        return em.find(CarsEntity.class, carId);
    }

    public List<CarsEntity> findAll() {
        return em.createNamedQuery("CarsEntity.findAll", CarsEntity.class).getResultList();
    }
}
