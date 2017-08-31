package ru.betchain.applicationcore.matchCenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.betchain.applicationcore.login.dao.UserDao;
import ru.betchain.applicationcore.matchCenter.dao.AllMatchesDao;
import ru.betchain.applicationcore.matchCenter.model.Match;

/**
 * Created by Anton on 31.08.17.
 */
@Component
@Service
public class MatchCenterServiceImpl implements MatchCenterService {
    @Autowired
    private AllMatchesDao allMatchesDao;

    @Override
    public void save(Match match) {
        allMatchesDao.save(match);
    }

    @Override
    public Match findById(String id) {
        return allMatchesDao.findById(id);
    }
}
