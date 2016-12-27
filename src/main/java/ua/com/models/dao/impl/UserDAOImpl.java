package ua.com.models.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import ua.com.models.dao.UserDAO;
import ua.com.models.model.Role;
import ua.com.models.model.User;
import ua.com.models.repository.RoleRepository;
import ua.com.models.repository.UserRepository;

import java.util.List;

@Repository
public class UserDAOImpl extends AbstractDaoImpl<User> implements UserDAO {

    private final static Long CLIENT_ROLE_ID = 1L;

    private final static Long ADMIN_ROLE_ID = 2L;

    private final static Long MANAGER_ROLE_ID = 3L;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserDAOImpl(UserRepository userRepository, RoleRepository roleRepository) {
        super(userRepository);
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User getByName(String name) {
        return this.userRepository.findByName(name);
    }

    @Override
    public User getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User getMainAdministrator() {
        Role admin = this.roleRepository.findOne(ADMIN_ROLE_ID);
        return this.userRepository.findAllByRole(admin).get(0);
    }

    @Override
    public List<User> getAdministrators() {
        Role admin = this.roleRepository.findOne(ADMIN_ROLE_ID);
        return this.userRepository.findAllByRole(admin);
    }



    @Override
    public List<User> getClients() {
        Role client = this.roleRepository.findOne(CLIENT_ROLE_ID);
        return this.userRepository.findAllByRole(client);
    }

    @Override
    public User getAuthenticatedUser() {
        User user;
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            user = (User) authentication.getPrincipal();
        } catch (Exception ex) {
            //ex.printStackTrace();
            user = null;
        }
        return user;
    }

    @Override
    public void remove(String name) {
        this.userRepository.deleteByName(name);
    }

    @Override
    public void remove(Role role) {
        this.userRepository.deleteAllByRole(role);
    }

    /*
    @Override

    public List<User> search(String searchTerm)
    {
        return this.userRepository.search(searchTerm);
    }
    */

}
