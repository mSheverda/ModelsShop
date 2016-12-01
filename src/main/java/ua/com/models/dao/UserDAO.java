package ua.com.models.dao;

import ua.com.models.model.Role;
import ua.com.models.model.User;

import java.util.List;

public interface UserDAO extends AbstractDao<User> {

    User getByName(String name);

    User getByUsername(String username);

    User getMainAdministrator();

    List<User> getAdministrators();

    List<User> getManagers();

    List<User> getClients();

    User getAuthenticatedUser();

    void remove(String name);

    void remove(Role role);
}
