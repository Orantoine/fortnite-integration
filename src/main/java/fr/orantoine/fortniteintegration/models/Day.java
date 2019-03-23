package fr.orantoine.fortniteintegration.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.util.Date;

@Document(collection = "Day")
public class Day {

    @Id
    private String id;

    private Date day;
    private int kills;
    private int matchs;
    private float ratio;
    private int duo;
    private int solo;
    private int section;
    private int wins;
    private String accountid;

    public Day(String id, Date day, int kills, int matchs, int ratio, int duo, int solo, int section, int wins, String accountid) {
        this.id = id;
        this.day = day;
        this.kills = kills;
        this.matchs = matchs;
        this.ratio = ratio;
        this.duo = duo;
        this.solo = solo;
        this.section = section;
        this.wins = wins;
        this.accountid = accountid;
    }

    public Day() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getMatchs() {
        return matchs;
    }

    public void setMatchs(int matchs) {
        this.matchs = matchs;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public int getDuo() {
        return duo;
    }

    public void setDuo(int duo) {
        this.duo = duo;
    }

    public int getSolo() {
        return solo;
    }

    public void setSolo(int solo) {
        this.solo = solo;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id='" + id + '\'' +
                ", day=" + day +
                ", kills=" + kills +
                ", matchs=" + matchs +
                ", ratio=" + ratio +
                ", duo=" + duo +
                ", solo=" + solo +
                ", section=" + section +
                ", wins=" + wins +
                ", accountid='" + accountid + '\'' +
                '}';
    }
}
