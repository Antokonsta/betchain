package ru.betchain.applicationcore.matchCenter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.betchain.applicationcore.matchCenter.model.Bet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Anton on 02.09.17.
 */
@Repository
public class BetsDaoFromTableImpl implements BetsDaoFromTable {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<Bet> showBetsForUser(String userName) {
      /*  Session session = this.sessionFactory.getCurrentSession();
        List betsList = session.createQuery("from bets where userInitiator = :acc ")
                .setString("acc", userName).list();
        return betsList;*/
      return em.createQuery("from Bet where userInitiator = :acc ").setParameter("acc", userName).getResultList();
    }

}
