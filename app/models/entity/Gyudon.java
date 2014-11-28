package models.entity;

import javax.persistence.*;

@Entity
@Table(name = "gyudon")
/*
@NamedQueries(value = {
        @NamedQuery(name = "Gyudon.findById", query = "SELECT a FROM gyudon a WHERE a.id = :id"),
        //@NamedQuery(name = "Gyudon.findByName", query = "SELECT a FROM gyudon a WHERE a.name = :name"),
        //@NamedQuery(name = "Gyudon.findByResisterDt", query = "SELECT a FROM gyudon a WHERE a.resister_dt = :resisterDt"),
        @NamedQuery(name = "Gyudon.getMaxId", query = "SELECT max(a.id) FROM gyudon a"),
        @NamedQuery(name = "Gyudon.findAll", query = "SELECT a FROM gyudon a") })
*/
public class Gyudon {
    @Id
    public Long id;
    
    public String name;
    
    public String resister_dt;

    //getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getResister_dt() {
        return resister_dt;
    }

    //setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResister_dt(String resister_dt) {
        this.resister_dt = resister_dt;
    }
}
