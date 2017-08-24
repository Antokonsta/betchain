package ru.betchain.applicationcore.login.dao;

/**
 * Created by Anton on 24.08.17.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import ru.betchain.applicationcore.login.model.User;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}