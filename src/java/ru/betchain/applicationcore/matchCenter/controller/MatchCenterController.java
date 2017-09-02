package ru.betchain.applicationcore.matchCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.betchain.applicationcore.login.service.SecurityServiceImpl;
import ru.betchain.applicationcore.matchCenter.dao.BetsDaoFromTable;
import ru.betchain.applicationcore.matchCenter.model.Bet;
import ru.betchain.applicationcore.matchCenter.model.BetMatchAssociation;
import ru.betchain.applicationcore.matchCenter.model.Match;
import ru.betchain.applicationcore.matchCenter.service.MatchCenterService;
import ru.betchain.applicationcore.matchCenter.service.MatchesMinerFromSites;
import sun.misc.Contended;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 31.08.17.
 */
@Controller
public class MatchCenterController {

    @Autowired
    private MatchesMinerFromSites matchesMinerFromSites;

    @Autowired
    MatchCenterService matchCenterService;




    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {

        //получаем игры с чемпионата
        List<Match> matchesByUrl = null;
        try {
            matchesByUrl = matchesMinerFromSites.getMatchesByUrl(null);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            model.addAttribute("listOfMatches", matchesByUrl != null ? matchesByUrl : null);
        }

        // сохраняем в бд новые
        if (matchesByUrl != null) {
            for (Match match : matchesByUrl) {
                if (matchCenterService.findById(match.getId()) == null) {
                    matchCenterService.save(match);
                }
            }
        }


        List<BetMatchAssociation> betMatchAssociationList = matchCenterService.showBetMatchAssociation();

        model.addAttribute("betMatchForUser",betMatchAssociationList);

        return "welcome";
    }

}
