/**
 * 
 */
package ma.ht.springboot.app;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.mockito.MockitoAnnotations;

import ma.ht.springboot.app.model.Role;
import ma.ht.springboot.app.model.User;
import ma.ht.springboot.app.repos.RoleRepository;
import ma.ht.springboot.app.repos.UserRepository;
import ma.ht.springboot.app.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author H.TARRERITI
 *
 */
public class UserServiceTest {

	
	@Mock
    private UserRepository mockUserRepository;
    @Mock
    private RoleRepository mockRoleRepository;
    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;
    
    private UserService userServiceUnderTest;
    private User user;

    
    
    @Before
    public void setUp() {
    	
    	initMocks(this);
        userServiceUnderTest = new UserService(mockUserRepository,
                                               mockRoleRepository,
                                               mockBCryptPasswordEncoder);
        
        Set<Role> listRoles=new HashSet<Role>();
        listRoles.add(mockRoleRepository.findByRole("ADMIN"));
        
        
        user = new User.Builder()
                .withId(1L)
                .withLogin("hassan")
                .withLastName("tarreriti")
                .withFirstName("hassan")
                .withActive(1)
                .withPassword("Password@")
                .withEmail("test@test.com")
                .withRoles(listRoles)
                .withBirthDate(Calendar.getInstance().getTime())
                .build();

        Mockito.when(mockUserRepository.save(any()))
                .thenReturn(user);
        Mockito.when(mockUserRepository.findByEmail(anyString()))
                .thenReturn(user);
        
        
        Mockito.when(mockRoleRepository.findByRole(anyString()))
        .thenReturn(new Role(0,"ADMIN"));
    }
    
    @Test
    public void testFindUserByEmail() {
        // Setup
        final String email = "test@test.com";
        
       

        // Run the test
        final User result = userServiceUnderTest.findUserByEmail(email);

        // Verify the results
        assertEquals(email, result.getEmail());
    }
    
    @Test
    public void testSaveUser() {
        // Setup
        final String email = "test@test.com";

        Set<Role> listRoles=new HashSet<Role>();
        listRoles.add(mockRoleRepository.findByRole("ADMIN"));
        
        user = new User.Builder()
                .withId(1L)
                .withLogin("hassan")
                .withLastName("tarreriti")
                .withFirstName("hassan")
                .withActive(1)
                .withPassword("Password@")
                .withEmail("test@test.com")
                .withRoles(listRoles)
                .withBirthDate(Calendar.getInstance().getTime())
                .build();
        
        // Run the test
        User result = userServiceUnderTest.saveUser(user);

        // Verify the results
        assertEquals(email, result.getEmail());
    }

}
