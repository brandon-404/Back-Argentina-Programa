
package com.argentina_programa.Portfolio.dto.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

import lombok.Data;

/**
 *
 * @author bra5j
 */
@Data
public class UserRequest implements Serializable{
    @JsonProperty("name")
    private String name;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty ("correo")
    private String correo;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("img_perfil")
    private String img_perfil;
    @JsonProperty("img_portada")
    private String img_portada;
}
