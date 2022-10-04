package ga.kriox3.ApiPortfolio.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ga.kriox3.ApiPortfolio.dto.UserDTO;
import ga.kriox3.ApiPortfolio.exception.UserAlreadyExistAuthenticationException;
import ga.kriox3.ApiPortfolio.model.User;
import ga.kriox3.ApiPortfolio.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = (User) userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("No se encuentra usuario: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public User save(UserDTO userDTO) {
		
		User userDB = (User) userRepository.findByUsername(userDTO.getUsername());
		if (userDB != null) 
			throw new UserAlreadyExistAuthenticationException(userDTO.getUsername());
		
		User newUser = new User();
		newUser.setUsername(userDTO.getUsername());
		newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
		return userRepository.save(newUser);
	}
}