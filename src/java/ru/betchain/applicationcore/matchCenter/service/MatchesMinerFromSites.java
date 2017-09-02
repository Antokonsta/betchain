package ru.betchain.applicationcore.matchCenter.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import ru.betchain.applicationcore.matchCenter.model.Match;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anton on 25.08.17.
 */
@Component
public class MatchesMinerFromSites {

    private static final String ENGLAND_URL = "https://www.championat.com/football/_england.html";

    private static final String WORLD_CUP = "https://www.championat.com/football/_worldcup.html";

    private static final String ENGLAND_ICON = "https://www.championat.com/football/_england/2214/teams.html";
    private static final String WORLD_ICON = "https://www.championat.com/football/_worldcup/1585/teams.html";

    public List<Match> getMatchesByUrl(String url) throws IOException {
        Document doc = Jsoup.connect(url != null ? url : ENGLAND_URL).get();
        //  Elements el = doc.select("div.sport__calendar__block__row");
        Elements el1 = doc.select("div.sport__calendar__block");
        List<Match> games = new ArrayList<>();
        for (Element element : el1) {
            // Дата матча
            Elements fullBlockInfo = element.select("div.sport__calendar__block__date");
            String blockInfo = fullBlockInfo.get(0).ownText();
            String date = blockInfo.split(",")[0];

            Elements el = element.select("div.sport__calendar__block__row");
            for (Element e : el) {
                Match game = new Match();
                Elements select = e.select("a");
                //Заполняем название команд
                game.setLeft(select.get(0).ownText());
                game.setRight(select.get(1).ownText());
                Elements span = select.get(2).select("span");
                //Заполняем результат
                if (span.size() != 0) {
                    game.setLeftRes(Integer.valueOf(span.get(0).ownText()));
                    game.setRightRes(Integer.valueOf(span.get(1).ownText()));
                    game.setRightRes(Integer.valueOf(span.get(1).ownText()));
                    game.setFinished(true);
                }

                String hrefForResult = select.get(2).attr("href");
                String matchIdWithHtml = hrefForResult.split("/match/")[1];
                game.setId(matchIdWithHtml.replaceAll(".html", ""));
                game.setDate(date);

                Map<String, String> teamsIcons = getTeamsIcons();
                game.setLeftPic(teamsIcons.get(game.getLeft()));
                game.setRightPic(teamsIcons.get(game.getRight()));
                games.add(game);
            }
        }
        return games;
    }

    public Map<String, String> getTeamsIcons() throws IOException {
        Document doc = Jsoup.connect(ENGLAND_ICON).get();
        Elements el1 = doc.select("div.sport__table");
        Element teams = el1.get(0);
        Elements tds = teams.select("td");
        Map<String, String> teamsWithRef = new HashMap<>();
        for (Element td : tds) {
            Elements teamWithRef = td.select("img[alt]");
            for (Element element : teamWithRef) {
                teamsWithRef.put(element.attr("alt"), element.attr("src"));
            }
        }
        return teamsWithRef;
    }



}
