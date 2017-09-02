package ru.betchain.applicationcore.matchCenter.dao;

import ru.betchain.applicationcore.matchCenter.model.Bet;

import java.util.List;

/**
 * Created by Anton on 02.09.17.
 */
public interface BetsDaoFromTable {
    List<Bet> showBetsForUser(String userName);
}
