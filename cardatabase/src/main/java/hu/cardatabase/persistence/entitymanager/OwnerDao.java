package hu.cardatabase.persistence.entitymanager;



import hu.cardatabase.persistence.entity.OwnerEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class OwnerDao {

    @PersistenceContext(unitName = "msSqlConn")
    protected EntityManager em;

    public void save(OwnerEntity t) {
        em.merge(t);
        em.flush();
    }

    public void delete(OwnerEntity t) {
        em.remove(t);
    }

    public OwnerEntity findOne(Long ownerId) {
        return em.find(OwnerEntity.class, ownerId);
    }

    public List<OwnerEntity> findAll() {
        return em.createNamedQuery("OwnerEntity.findAll", OwnerEntity.class).getResultList();
    }
}
