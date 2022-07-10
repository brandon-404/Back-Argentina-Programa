/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Table(name ="social" )
public class Social implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "social_id")
    private int id;
    @Column(name = "redSocial")
    private String redSocial;
    @Column (name = "link")
    private String link;
    
    
    
    
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
