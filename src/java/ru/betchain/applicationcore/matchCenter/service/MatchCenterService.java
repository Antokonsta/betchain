package ru.betchain.applicationcore.matchCenter.service;

import ru.betchain.applicationcore.login.model.User;
import ru.betchain.applicationcore.matchCenter.model.Match;

/**
 * Created by Anton on 31.08.17.
 */
public interface MatchCenterService {
    void save(Match match);

    Match findById(String id);
}
