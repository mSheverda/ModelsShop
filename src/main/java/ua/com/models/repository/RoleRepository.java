package ua.com.models.repository;


import ua.com.models.enums.RoleEnum;
import ua.com.models.model.Role;

public interface RoleRepository extends MainRepository<Role, Long> {

    Role findByTitle(RoleEnum title);

    void deleteByTitle(RoleEnum title);
}
