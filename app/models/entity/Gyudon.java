package models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Gyudon {
    @Id
    public Long id;
    
    public String name;
    
    public String resister_dt;

}
