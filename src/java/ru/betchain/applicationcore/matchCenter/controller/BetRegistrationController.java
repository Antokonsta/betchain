package ru.betchain.applicationcore.matchCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.betchain.applicationcore.matchCenter.model.Bet;
import ru.betchain.applicationcore.matchCenter.model.Match;
import ru.betchain.applicationcore.matchCenter.service.BetRegistrationService;
import ru.betchain.applicationcore.matchCenter.service.MatchCenterService;
import ru.betchain.applicationcore.matchCenter.service.MatchesMinerFromSites;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Anton on 31.08.17.
 */
@Controller
public class BetRegistrationController {


    @Autowired
    MatchCenterService matchCenterService;

    @Autowired
    BetRegistrationService betRegistrationService;

    @Autowired
    private MatchesMinerFromSites matchesMinerFromSites;

    @RequestMapping(value = {"/betRegistr/{username}/{match.id}"}, method = RequestMethod.GET)
    public String betRegistr(@PathVariable("match.id") String matchId, @PathVariable("username") String username, Model model) {

        Match matchById = matchCenterService.findById(matchId);
        model.addAttribute("match", matchById);
        Bet bet = new Bet();
        bet.setTestMoney(true);
        bet.setUserInitiator(username);
        model.addAttribute("bet", bet);


        return "betRegistr";
    }

    @RequestMapping(
            value = {"/betRegistr/add/{matchId}"},
            method = {RequestMethod.POST}
    )
    public String addBet(@ModelAttribute("bet") Bet bet, Model model) {

        betRegistrationService.save(bet);

        List<Match> matchesByUrl = null;
        try {
            matchesByUrl = matchesMinerFromSites.getMatchesByUrl(null);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            model.addAttribute("listOfMatches", matchesByUrl != null ? matchesByUrl : null);
        }

        return "welcome";
    }
}
