package ru.betchain.applicationcore.matchCenter.model;


import javax.persistence.*;

/**
 * Created by Anton on 01.09.17.
 */
@Entity
@Table(name = "bets")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "matchId")
    private String matchId;

    @Column(name = "userInitiator")
    private String userInitiator;

    @Column(name = "priceOfInitiator")
    private long priceOfInitiator;

    @Column(name = "initiatorWinner")
    private String initiatorWinner;

    @Column(name = "testMoney")
    private boolean testMoney;

    @Column(name = "privateBet")
    private boolean privateBet;

    @Column(name = "invitedUser")
    private String invitedUser;

    @Column(name = "approved")
    private boolean approved;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getUserInitiator() {
        return userInitiator;
    }

    public void setUserInitiator(String userInitiator) {
        this.userInitiator = userInitiator;
    }

    public long getPriceOfInitiator() {
        return priceOfInitiator;
    }

    public void setPriceOfInitiator(long priceOfInitiator) {
        this.priceOfInitiator = priceOfInitiator;
    }

    public String getInitiatorWinner() {
        return initiatorWinner;
    }

    public void setInitiatorWinner(String initiatorWinner) {
        this.initiatorWinner = initiatorWinner;
    }

    public boolean isTestMoney() {
        return testMoney;
    }

    public void setTestMoney(boolean testMoney) {
        this.testMoney = testMoney;
    }

    public boolean isPrivateBet() {
        return privateBet;
    }

    public void setPrivateBet(boolean privateBet) {
        this.privateBet = privateBet;
    }

    public String getInvitedUser() {
        return invitedUser;
    }

    public void setInvitedUser(String invitedUser) {
        this.invitedUser = invitedUser;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
