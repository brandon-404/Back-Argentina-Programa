
package com.argentina_programa.Portfolio.dto.users;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author bra5j
 */
@Data
public class UsersDTO implements Serializable {
    private String id;
    private String name;
    private String correo;
    private String titulo;
    private String img_perfil;
    private String img_portada;
    private Date createAt;
    private Date updateAt;
    
    
}
