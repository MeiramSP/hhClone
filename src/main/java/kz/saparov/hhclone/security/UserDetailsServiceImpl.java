package kz.saparov.hhclone.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kz.saparov.hhclone.entity.User;
import kz.saparov.hhclone.repository.UserRepository;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username)
				.orElseThrow(()-> new UsernameNotFoundException("Could not find user"));
        return new MyUserDetails(user.getId(), 
				        		 user.getEmail(), 
				        		 user.getFirstName(),
				        		 user.getPassword(),
				        		 user.isEnabled(),
				        		 user.getRoles());
	}
	

}
