package ua.com.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.models.dao.RoleDAO;
import ua.com.models.enums.RoleEnum;
import ua.com.models.model.Role;
import ua.com.models.service.RoleService;

import java.util.Collections;
import java.util.List;

@Service
public class RoleServiceImpl extends MainServiceImpl<Role> implements RoleService {

    private final RoleDAO dao;

    @Autowired
    public RoleServiceImpl(RoleDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    @Transactional
    public void add(RoleEnum title, String description)
    {
        dao.add(new Role(title, description));
    }

    @Override
    @Transactional(readOnly = true)
    public Role get(RoleEnum title)
    {
        Role role = this.dao.get(title);

        return role;
    }

    @Override
    @Transactional(readOnly = true)
    public Role getAdministrator()
    {
        Role role = this.dao.get(RoleEnum.ADMIN);

        return role;
    }

    @Override
    @Transactional(readOnly = true)
    public Role getDefault()
    {
        Role role = this.dao.getDefault();

        return role;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> getPersonnel() {
        List<Role> roles = this.dao.getAll();
      /*
       if (roles.isEmpty()) {

            return Collections.emptyList();
        }
        roles.remove(getDefault());
       */
        return roles;
    }

    @Override
    @Transactional
    public void remove(RoleEnum title)
    {
        this.dao.remove(title);
    }
}