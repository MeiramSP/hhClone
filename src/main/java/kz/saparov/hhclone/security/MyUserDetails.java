package kz.saparov.hhclone.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import kz.saparov.hhclone.entity.Role;

public class MyUserDetails implements UserDetails {
	private static final long serialVersionUID = 964763380368249163L;
	private final Long id;
	private final String email;
	private final String firstName;
	private final String password;
	private final boolean enabled;
	private final Set<Role> roles;
	
	public MyUserDetails(Long id, String email, String firstName, String password, boolean enabled, Set<Role> roles) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		return roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toSet());
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
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
		return enabled;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}
	
}
