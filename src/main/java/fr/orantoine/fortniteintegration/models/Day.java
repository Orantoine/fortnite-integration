package fr.orantoine.fortniteintegration.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Day")
public class Day {

    @Id
    private String id;
    private String accountName;
    private Date day;
    private float kills;
    private float matchs;
    private float ratio;
    private int wins;
    private String accountid;
    private Match[] listMatchs;


    public Day(String id,String accountName,Date day, float kills, float matchs, float ratio, int duo, int solo, int section, int wins, String accountid, Match[] listMatch) {
        this.id = id;
        this.accountName = accountName;
        this.day = day;
        this.kills = kills;
        this.matchs = matchs;
        this.ratio = ratio;
        this.wins = wins;
        this.accountid = accountid;
        this.listMatchs = listMatch;
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

    public float getKills() {
        return kills;
    }

    public void setKills(float kills) {
        this.kills = kills;
    }

    public float getMatchs() {
        return matchs;
    }

    public void setMatchs(float matchs) {
        this.matchs = matchs;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Match[] getListMatchs() {
        return listMatchs;
    }

    public void setListMatchs(Match[] listMatchs) {
        this.listMatchs = listMatchs;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id='" + id + '\'' +
                ", accountName='" + accountName + '\'' +
                ", day=" + day +
                ", kills=" + kills +
                ", matchs=" + matchs +
                ", ratio=" + ratio +
                ", wins=" + wins +
                ", accountid='" + accountid + '\'' +
                '}';
    }
}
