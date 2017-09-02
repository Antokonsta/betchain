package ru.betchain.applicationcore.matchCenter.service;

import ru.betchain.applicationcore.login.model.User;
import ru.betchain.applicationcore.matchCenter.model.Bet;
import ru.betchain.applicationcore.matchCenter.model.BetMatchAssociation;
import ru.betchain.applicationcore.matchCenter.model.Match;

import java.util.List;

/**
 * Created by Anton on 31.08.17.
 */
public interface MatchCenterService {
    void save(Match match);

    List<Bet> showBetsForUser(String userName);

    List<BetMatchAssociation> showBetMatchAssociation();

    Match findById(String id);
}
