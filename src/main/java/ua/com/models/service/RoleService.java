package ua.com.models.service;


import ua.com.models.enums.RoleEnum;
import ua.com.models.model.Role;

import java.util.List;

public interface RoleService extends MainService<Role> {

    void add(RoleEnum title, String description);

    Role get(RoleEnum title);

    Role getAdministrator();

    Role getDefault();

    List<Role> getPersonnel();

    void remove(RoleEnum title);
}
