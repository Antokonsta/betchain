package ru.betchain.applicationcore.matchCenter.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import ru.betchain.applicationcore.matchCenter.vo.Match;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 25.08.17.
 */
@Component
public class MatchesMinerFromSites {

    private static final String DEFAULT_URL = "https://www.championat.com/football/_spain.html";

    public List<Match> getMatchesByUrl (String url) throws IOException {
        Document doc = Jsoup.connect(url != null ? url : DEFAULT_URL).get();
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
                    game.setFinished(true);
                }
                game.setDate(date);
                games.add(game);
            }
        }
        return games;
    }

}
