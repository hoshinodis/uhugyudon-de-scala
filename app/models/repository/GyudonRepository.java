package models.repository;

import models.entity.Gyudon;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
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


    public static Gyudon findById(Long id) {
        TypedQuery<Gyudon> gyudonQuery = JPA.em().createNamedQuery("Gyudon.findById", Gyudon.class).setParameter("id", id);
        List<Gyudon> idList = gyudonQuery.getResultList();

        return idList.get(0);
    }

    public static List<Gyudon> findAll() {
        return JPA.em().createNamedQuery( "Gyudon.findAll", Gyudon.class).getResultList();
    }
}
