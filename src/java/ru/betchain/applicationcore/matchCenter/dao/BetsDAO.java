package ru.betchain.applicationcore.matchCenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.betchain.applicationcore.matchCenter.model.Bet;
import ru.betchain.applicationcore.matchCenter.model.Match;

/**
 * Created by Anton on 02.09.17.
 */
public interface BetsDAO extends JpaRepository<Bet, Long> {
}
