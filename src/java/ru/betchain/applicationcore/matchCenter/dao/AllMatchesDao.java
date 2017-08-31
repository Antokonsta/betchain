package ru.betchain.applicationcore.matchCenter.dao;

/**
 * Created by Anton on 24.08.17.
 */

import org.springframework.data.jpa.repository.JpaRepository;

import ru.betchain.applicationcore.matchCenter.model.Match;

public interface AllMatchesDao extends JpaRepository<Match, Long> {
    Match findById(String id);
}