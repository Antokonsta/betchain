package ru.betchain.applicationcore.matchCenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.betchain.applicationcore.login.dao.UserDao;
import ru.betchain.applicationcore.matchCenter.dao.AllMatchesDao;
import ru.betchain.applicationcore.matchCenter.dao.BetsDaoFromTable;
import ru.betchain.applicationcore.matchCenter.model.Bet;
import ru.betchain.applicationcore.matchCenter.model.BetMatchAssociation;
import ru.betchain.applicationcore.matchCenter.model.Match;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 31.08.17.
 */
@Component
@Service
public class MatchCenterServiceImpl implements MatchCenterService {
    @Autowired
    private AllMatchesDao allMatchesDao;

    @Autowired
    @Qualifier(value = "betsDaoFromTable")
    private BetsDaoFromTable betsDaoFromTable;

    @Override
    public void save(Match match) {
        allMatchesDao.save(match);
    }

    @Override
    public Match findById(String id) {
        return allMatchesDao.findById(id);
    }

    @Override
    @Transactional
    public List<Bet> showBetsForUser(String userName) {
        return betsDaoFromTable.showBetsForUser(userName);
    }

    @Override
    public List<BetMatchAssociation> showBetMatchAssociation() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Bet> betListForUser = showBetsForUser(user.getUsername());

        List<BetMatchAssociation> betMatchAssociationList = new ArrayList<>();
        for (Bet bet : betListForUser) {
            BetMatchAssociation betMatchAssociation = new BetMatchAssociation();
            Match match = findById(bet.getMatchId());
            betMatchAssociation.setMatch(match);
            betMatchAssociation.setBet(bet);
            betMatchAssociationList.add(betMatchAssociation);
            betMatchAssociation.setWinnerPic(bet.getInitiatorWinner().equals("right") ? match.getRightPic() :
                    match.getLeftPic());
        }

        return betMatchAssociationList;
    }
}
