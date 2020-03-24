package com.blitzware.gestaoAPI.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.blitzware.gestaoAPI.model.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String email;
	@JsonIgnore
	private String password;
	private boolean enable;
	private Collection<? extends GrantedAuthority> authorities;

	public UserPrincipal(Long id, String email, String password, GrantedAuthority authorities, boolean enable) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.authorities = Arrays.asList(authorities);
		this.enable = enable;
	}

	public static UserPrincipal create(UserModel user) {
		GrantedAuthority authorities = new SimpleGrantedAuthority(user.getRole().getRoleName());
		return new UserPrincipal(user.getId(), user.getEmail(), user.getPassword(), authorities, user.isEnable());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.email;
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
		return this.enable;
	}
	
	public Long getId() {
		return this.id;
	}

}
