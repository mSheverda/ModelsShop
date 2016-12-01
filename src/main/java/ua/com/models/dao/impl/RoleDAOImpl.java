package ua.com.models.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.models.dao.RoleDAO;
import ua.com.models.enums.RoleEnum;
import ua.com.models.model.Role;
import ua.com.models.repository.RoleRepository;

@Repository
public class RoleDAOImpl extends AbstractDaoImpl<Role> implements RoleDAO {

    private final RoleRepository repository;

    @Autowired
    public RoleDAOImpl(RoleRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public void add(RoleEnum title, String description) {
        this.repository.save(new Role(title, description));
    }

    @Override
    public Role get(RoleEnum title) {
        return this.repository.findByTitle(title);
    }

    @Override
    public Role getDefault() {
        return this.repository.findOne((long) 1);
    }

    @Override
    public void remove(RoleEnum title) {
        this.repository.deleteByTitle(title);
    }
}