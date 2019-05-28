package fr.orantoine.fortniteintegration.models;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.util.Date;

@Document(collection = "Match")
public class Match {

    @Id
    private String id;
    private String playlist;
    private String kills;
    private String minutesPlayed;
    private String top1;
    private String matches;
    private String top3;
    private String ratio;

    public Match(String id, String playlist, String kills, String minutesPlayed, String top1, String matches, String top3, String ratio) {
        this.id = id;
        this.playlist = playlist;
        this.kills = kills;
        this.minutesPlayed = minutesPlayed;
        this.top1 = top1;
        this.matches = matches;
        this.top3 = top3;
        this.ratio = ratio;
    }

    public Match() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaylist() {
        return playlist;
    }

    public void setPlaylist(String playlist) {
        this.playlist = playlist;
    }

    public String getKills() {
        return kills;
    }

    public void setKills(String kills) {
        this.kills = kills;
    }

    public String getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(String minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public String getTop1() {
        return top1;
    }

    public void setTop1(String top1) {
        this.top1 = top1;
    }

    public String getMatches() {
        return matches;
    }

    public void setMatches(String matches) {
        this.matches = matches;
    }

    public String getTop3() {
        return top3;
    }

    public void setTop3(String top3) {
        this.top3 = top3;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id='" + id + '\'' +
                ", playlist='" + playlist + '\'' +
                ", kills='" + kills + '\'' +
                ", minutesPlayed='" + minutesPlayed + '\'' +
                ", top1='" + top1 + '\'' +
                ", matches='" + matches + '\'' +
                ", top3='" + top3 + '\'' +
                ", ratio='" + ratio + '\'' +
                '}';
    }
}


