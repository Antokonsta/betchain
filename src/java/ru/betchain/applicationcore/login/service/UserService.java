package ru.betchain.applicationcore.login.service;

import ru.betchain.applicationcore.login.model.User;

/**
 * Created by Anton on 24.08.17.
 */


public interface UserService {

    void save(User user);

    User findByUsername(String username);
}