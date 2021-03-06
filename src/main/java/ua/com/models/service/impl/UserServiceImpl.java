package ua.com.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.models.dao.UserDAO;
import ua.com.models.model.Role;
import ua.com.models.model.User;
import ua.com.models.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 11/28/2016.
 */

@Service
public class UserServiceImpl extends MainServiceImpl<User> implements UserService, UserDetailsService {

    private final UserDAO dao;

    @Autowired
    public UserServiceImpl(UserDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public User getByName(String name)
    {
        User user = this.dao.getByName(name);

        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public User getByUsername(String username)
    {
        User user = this.dao.getByUsername(username);
         return user;
    }

    @Override
    @Transactional(readOnly = true)
    public User getMainAdministrator()
    {
        User user = this.dao.getMainAdministrator();

        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAdministrators() {
        return this.dao.getAdministrators();
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> getClients() {
        return this.dao.getClients();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getPersonnel() {
        List<User> users = new ArrayList<>();
        users.addAll(getAdministrators());
        users.addAll(getClients());
        return users;
    }

    @Override
    @Transactional(readOnly = true)
    public User getAuthenticatedUser() {
        return this.dao.getAuthenticatedUser();
    }

    @Override
    @Transactional
    public void removeByName(String name)
    {
        this.dao.remove(name);
    }

    @Override
    @Transactional
    public void removeByRole(Role role)
    {

        this.dao.remove(role);
    }

    @Override
    @Transactional
    public void removePersonnel() {
        List<User> personnel = getPersonnel();
        if (personnel.isEmpty()) {
            return;
        }
        personnel.remove(getMainAdministrator());
        this.dao.remove(personnel);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getByUsername(username);
    }

/*
    @Override
    @Transactional
    public List<User> searchProduct(String searchTerm)
    {
        return this.dao.search(searchTerm);
    }
  */

}
