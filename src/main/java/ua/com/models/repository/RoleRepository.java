package ua.com.models.repository;


import ua.com.models.enums.RoleEnum;
import ua.com.models.model.Role;

public interface RoleRepository extends MainRepository<Role, Long> {
    /**
     * Возвращает роль из базы даных по названию, которое может принимать
     * одно из значений перечисления {@link RoleEnum}.
     *
     * @param title Название роли.
     * @return Объект класса {@link Role} - роль с уникальным названием.
     */
    Role findByTitle(RoleEnum title);

    /**
     * Удаляет роль из базы даных по названию, которое может принимать одно
     * из значений перечисления {@link RoleEnum}.
     *
     * @param title Название роли.
     */
    void deleteByTitle(RoleEnum title);
}
