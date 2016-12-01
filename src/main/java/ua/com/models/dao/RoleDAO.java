package ua.com.models.dao;


import ua.com.models.enums.RoleEnum;
import ua.com.models.model.Role;

public interface RoleDAO extends AbstractDao<Role> {

    void add(RoleEnum title, String description);

    Role get(RoleEnum title);

    Role getDefault();

    void remove(RoleEnum title);
}