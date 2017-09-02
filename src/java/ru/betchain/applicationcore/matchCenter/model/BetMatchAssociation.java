package ru.betchain.applicationcore.matchCenter.model;

/**
 * Created by Anton on 02.09.17.
 */
public class BetMatchAssociation {
    private Bet bet;
    private Match match;
    private String winnerPic;

    public String getWinnerPic() {
        return winnerPic;
    }

    public void setWinnerPic(String winnerPic) {
        this.winnerPic = winnerPic;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
