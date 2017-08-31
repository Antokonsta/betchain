package ru.betchain.applicationcore.matchCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.betchain.applicationcore.matchCenter.service.MatchesMinerFromSites;
import ru.betchain.applicationcore.matchCenter.vo.Match;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Anton on 31.08.17.
 */
@Controller
public class betRegistrationController {


    @Autowired
    private MatchesMinerFromSites matchesMinerFromSites;

    @RequestMapping(value = {"/betRegistr/{match.left}-{match.right}"}, method = RequestMethod.GET)
    public String welcome(@PathVariable("match.left") String matchLeft,
                          @PathVariable("match.right") String matchRight,
                          Model model) {

        model.addAttribute("matchLeft",matchLeft);
        model.addAttribute("matchRight",matchRight);
        Map<String, String> teamsIcons = null;
        try {
            teamsIcons = matchesMinerFromSites.getTeamsIcons();
        } catch (IOException e) {

        }
        model.addAttribute("matchLeftPic",teamsIcons != null ? teamsIcons.get(matchLeft) : null);
        model.addAttribute("matchRightPic",teamsIcons != null ? teamsIcons.get(matchRight) : null);

        return "betRegistr";
    }
}
