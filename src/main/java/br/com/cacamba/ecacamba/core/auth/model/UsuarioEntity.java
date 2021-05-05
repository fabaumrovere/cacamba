package br.com.cacamba.ecacamba.core.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue
    private Long id;
    
    @NotBlank
    @Column( length = 20 )
    private String nome;

    @NotBlank
    @Column( length = 20 )
    private String login;

    @NotBlank
    private String senha;

    @NotBlank
    @Column( length = 50 )
    private String email;

}