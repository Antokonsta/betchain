package ru.betchain.applicationcore.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.betchain.applicationcore.login.model.Role;

/**
 * Created by Anton on 24.08.17.
 */
public interface RoleDao extends JpaRepository<Role, Long> {
}