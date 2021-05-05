package br.com.cacamba.ecacamba.core.auth.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.cacamba.ecacamba.core.auth.model.UsuarioEntity;

public class UsuarioCustomDTO implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String login;
    private String senha;

    public UsuarioCustomDTO(UsuarioEntity usuario) {
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.nome = usuario.getNome();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

   public String getNome() {
	  return nome;
   }

   public void setNome(String nome) {
	  this.nome = nome;
   }
}