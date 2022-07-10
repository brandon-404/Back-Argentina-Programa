
package com.argentina_programa.Portfolio.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author bra5j
 */
@Data
@Entity
@Table(name ="experiencia" )
public class Experiencia implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "Experiencia_id")
    private int id;
    @Column(name = "Leyenda")
    private String leyenda;
    
    @Column(name = "ceateAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Column(name = "updateAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    
    @PrePersist
    public void prePersist(){
        this.createAt = new Date();  
    }
    @PreUpdate
    public void preUpdate (){
        this.updateAt = new Date();
    }
}
