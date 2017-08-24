package ru.betchain.applicationcore.login.service;

/**
 * Created by Anton on 24.08.17.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}