package models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "gyudon")
@NamedQueries(value = {
        //@NamedQuery(name = "Gyudon.findById", query = "SELECT a FROM gyudon a WHERE a.id = :id")
        //@NamedQuery(name = "Gyudon.findByName", query = "SELECT a FROM gyudon a WHERE a.name = :name")
        //@NamedQuery(name = "Gyudon.findByResisterDt", query = "SELECT a FROM gyudon a WHERE a.resister_dt = :resisterDt"),
        //@NamedQuery(name = "Gyudon.getMaxId", query = "SELECT max(a.id) FROM gyudon a"),
        //@NamedQuery(name = "Gyudon.findAll", query = "SELECT a FROM gyudon a")
})
public class Gyudon {
    @Id
    @Column(name = "id")
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "create_at")
    public Date create_at;

    @Column(name = "update_at")
    public Date update_at;

    //getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    //setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

}
