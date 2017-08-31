package ru.betchain.applicationcore.matchCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.betchain.applicationcore.matchCenter.model.Match;
import ru.betchain.applicationcore.matchCenter.service.MatchCenterService;
import ru.betchain.applicationcore.matchCenter.service.MatchesMinerFromSites;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Anton on 31.08.17.
 */
@Controller
public class BetRegistrationController {


    @Autowired
    MatchCenterService matchCenterService;

    @RequestMapping(value = {"/betRegistr/{match.id}"}, method = RequestMethod.GET)
    public String welcome(@PathVariable("match.id") String matchId, Model model) {

        Match matchById = matchCenterService.findById(matchId);
        model.addAttribute("match",matchById);

        return "betRegistr";
    }
}
