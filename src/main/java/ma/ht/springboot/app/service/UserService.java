/**
 * 
 */
package ma.ht.springboot.app.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import ma.ht.springboot.app.model.Role;
import ma.ht.springboot.app.model.User;
import ma.ht.springboot.app.repos.RoleRepository;
import ma.ht.springboot.app.repos.UserRepository;
import ma.ht.springboot.app.usecases.RegisterUserUseCase;

/**
 * @author H.TARRERITI
 *
 */

@Service("userService")
public class UserService implements RegisterUserUseCase{
	
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    final private static Logger LOGGER= (Logger) LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
	
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        LOGGER.debug("Saving User As {}","Admin");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }
    
    public List<User> findAllUsers(){
    	
    	
    	return userRepository.findAll();
    }
    
}
