
package edu.ctu.spring.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import edu.ctu.mongodb.repositories.UserRepositoryDao;

@Component
public class MongoUserDetailsService implements UserDetailsService {

	@Resource
	private UserRepositoryDao userRepositoryDao;

	private org.springframework.security.core.userdetails.User userdetails;

	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		edu.ctu.mongodb.domain.User user = getUserDetail(email);

		userdetails = new User(user.getEmail(), user.getPassword(),
				user.isEnabled(), user.isAccountNonExpired(),
				user.isCredentialsNonExpired(), user.isAccountNonLocked(),
				getAuthorities(user.getRole()));
		return userdetails;
	}

	public List<GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority("ROLE_" + role));
		return authList;
	}

	public edu.ctu.mongodb.domain.User getUserDetail(String email) {
		edu.ctu.mongodb.domain.User user = userRepositoryDao.findByEmail(email);
		return user;
	}

}