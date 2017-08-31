package ru.betchain.applicationcore.matchCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.betchain.applicationcore.matchCenter.model.Match;
import ru.betchain.applicationcore.matchCenter.service.MatchCenterService;
import ru.betchain.applicationcore.matchCenter.service.MatchesMinerFromSites;
import sun.misc.Contended;

import java.io.IOException;
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
        List<Match> matchesByUrl = null;
        try {
            matchesByUrl = matchesMinerFromSites.getMatchesByUrl(null);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            model.addAttribute("listOfMatches", matchesByUrl != null ? matchesByUrl : null);
        }
        if (matchesByUrl != null) {
            for (Match match : matchesByUrl) {
                if(matchCenterService.findById(match.getId()) == null){
                    matchCenterService.save(match);
                }
            }
        }

        return "welcome";
    }

}
