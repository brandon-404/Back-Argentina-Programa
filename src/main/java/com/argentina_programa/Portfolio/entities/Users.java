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
@Table(name = "users")
public class Users  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "user_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column (name ="email")
    private String correo;
    @Column (name ="titulo")
    private String titulo;
    @Column (name = "img_perfil")
    private String img_perfil;
    @Column (name = "img_portada")
    private String img_portada;
    
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
