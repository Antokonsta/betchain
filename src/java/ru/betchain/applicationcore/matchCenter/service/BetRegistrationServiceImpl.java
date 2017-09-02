package ru.betchain.applicationcore.matchCenter.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.betchain.applicationcore.matchCenter.dao.AllMatchesDao;
import ru.betchain.applicationcore.matchCenter.dao.BetsDAO;
import ru.betchain.applicationcore.matchCenter.model.Bet;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Anton on 02.09.17.
 */
@Component
@Service

public class BetRegistrationServiceImpl implements BetRegistrationService {


    @Autowired
    BetsDAO betsDAO;



    @Override
    public void save(Bet bet) {
        betsDAO.save(bet);
    }

}
