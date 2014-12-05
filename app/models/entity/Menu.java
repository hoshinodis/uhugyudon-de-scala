package models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import java.util.Date;

/**
 * Created by uhu on 2014/12/05.
 */
@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer id;

    @Column(name = "name")
    public String name;

    @Column(name = "size_id")
    public Integer size_id;

    @Column(name = "topping_id")
    public Integer topping_id;

    @Column(name = "create_at")
    public Date create_at;

    @Column(name = "update_at")
    public Date update_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize_id() {
        return size_id;
    }

    public void setSize_id(Integer size_id) {
        this.size_id = size_id;
    }

    public Integer getTopping_id() {
        return topping_id;
    }

    public void setTopping_id(Integer topping_id) {
        this.topping_id = topping_id;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }
}
