package com.ankur.superhero.businesslogic.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ankur.superhero.dataaccess.entity.UserAccess;
import com.ankur.superhero.dataaccess.entity.UserRole;

@SuppressWarnings("serial")
@Component
public class UserDetailMapper {

	public UserDetails mapEntityToUserDetail(UserAccess userAccess) {

		return new UserDetails() {

			@Override
			public boolean isEnabled() {
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			@Override
			public String getUsername() {
				return userAccess.getUser();
			}

			@Override
			public String getPassword() {
				return userAccess.getPassword();
			}

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return getUserAuthorities(userAccess.getUserRole());
			}
		};
	}

	private Collection<? extends GrantedAuthority> getUserAuthorities(List<UserRole> roles) {
	 
		Collection<GrantedAuthority> userAuthorities = new ArrayList<>();
		for (UserRole role : roles) {

			GrantedAuthority authority = new GrantedAuthority() {
				@Override
				public String getAuthority() {
					return role.getRole();
				}
			};
			userAuthorities.add(authority);
		}
		return userAuthorities;
	}

}
