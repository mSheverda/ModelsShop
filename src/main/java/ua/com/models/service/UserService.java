package ua.com.models.service;


import ua.com.models.model.Role;
import ua.com.models.model.User;

import java.util.List;

public interface UserService extends MainService<User> {

    User getByName(String name);

    User getByUsername(String username);

    User getMainAdministrator();

    List<User> getAdministrators();

    List<User> getManagers();

    List<User> getClients();

    List<User> getPersonnel();

    User getAuthenticatedUser();

    void removeByName(String name);

    void removeByRole(Role role);

    void removePersonnel();
}
