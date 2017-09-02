package ru.betchain.applicationcore.matchCenter.service;

import ru.betchain.applicationcore.matchCenter.model.Bet;
import ru.betchain.applicationcore.matchCenter.model.Match;

/**
 * Created by Anton on 02.09.17.
 */
public interface BetRegistrationService {
    void save(Bet bet);
}
