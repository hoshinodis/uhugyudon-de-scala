package models.repository;

import models.entity.Gyudon;

import play.db.jpa.JPA;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Created by B05748 on 2014/11/27.
 */

public class GyudonRepository {
    /**
     * テーブルIDから該当するEntityを返却.
     *
     * @param id
     *        Long
     * @return idList.get(0)
     *         Gyudon
     */
    private EntityManager em;
    public GyudonRepository() {
        em = JPA.em();
    }

    public Gyudon findById(Long id) {
        TypedQuery<Gyudon> gyudonQuery = em.createNamedQuery("Gyudon.findById", Gyudon.class)
                .setParameter("id", id);
        List<Gyudon> idList = gyudonQuery.getResultList();

        return idList.get(0);
    }

    public List<Gyudon> findByName(String name) {
        TypedQuery<Gyudon> gyudonQuery = em.createNamedQuery("Gyudon.findByName", Gyudon.class)
                .setParameter("name", "%" + name.replace("%", "\\%").replace("_","\\_") + "%");
        return gyudonQuery.getResultList();
    }

    public List<Gyudon> findAll() {
        return em.createNamedQuery("Gyudon.findAll", Gyudon.class)
                .getResultList();
    }

    public Gyudon findMaxId() {
        TypedQuery<Gyudon> gyudonQuery = em.createNamedQuery("Gyudon.getMaxId", Gyudon.class);
        List<Gyudon> idList = gyudonQuery.getResultList();

        return idList.get(0);
    }

}
