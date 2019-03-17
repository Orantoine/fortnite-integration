package fr.orantoine.fortniteintegration.models;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

@Document(collection = "Match")
public class Match {

    @Id
    private String id;
    private String accountId;
    private String playlist;
    private String kills;
    private String minutesPlayed;
    private String top1;
    private String top5;
    private String top6;
    private String top10;
    private String top12;
    private String top25;
    private String matches;
    private String top3;
    private String dateCollected;
    private String score;
    private String platform;
    private String trnRating;
    private String trnRatingChange;
    private String ratio;

    public Match(String id, String accountId, String playlist, String kills, String minutesPlayed, String top1, String top5, String top6, String top10, String top12, String top25, String matches, String top3, String dateCollected, String score, String platform, String trnRating, String trnRatingChange, String ratio) {
        this.id = id;
        this.accountId = accountId;
        this.playlist = playlist;
        this.kills = kills;
        this.minutesPlayed = minutesPlayed;
        this.top1 = top1;
        this.top5 = top5;
        this.top6 = top6;
        this.top10 = top10;
        this.top12 = top12;
        this.top25 = top25;
        this.matches = matches;
        this.top3 = top3;
        this.dateCollected = dateCollected;
        this.score = score;
        this.platform = platform;
        this.trnRating = trnRating;
        this.trnRatingChange = trnRatingChange;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public String getTop5() {
        return top5;
    }

    public void setTop5(String top5) {
        this.top5 = top5;
    }

    public String getTop6() {
        return top6;
    }

    public void setTop6(String top6) {
        this.top6 = top6;
    }

    public String getTop10() {
        return top10;
    }

    public void setTop10(String top10) {
        this.top10 = top10;
    }

    public String getTop12() {
        return top12;
    }

    public void setTop12(String top12) {
        this.top12 = top12;
    }

    public String getTop25() {
        return top25;
    }

    public void setTop25(String top25) {
        this.top25 = top25;
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

    public String getDateCollected() {
        return dateCollected;
    }

    public void setDateCollected(String dateCollected) {
        this.dateCollected = dateCollected;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getTrnRating() {
        return trnRating;
    }

    public void setTrnRating(String trnRating) {
        this.trnRating = trnRating;
    }

    public String getTrnRatingChange() {
        return trnRatingChange;
    }

    public void setTrnRatingChange(String trnRatingChange) {
        this.trnRatingChange = trnRatingChange;
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
                ", accountId='" + accountId + '\'' +
                ", playlist='" + playlist + '\'' +
                ", kills=" + kills +
                ", minutesPlayed=" + minutesPlayed +
                ", top1=" + top1 +
                ", top5=" + top5 +
                ", top6=" + top6 +
                ", top10=" + top10 +
                ", top12=" + top12 +
                ", top25=" + top25 +
                ", matches=" + matches +
                ", top3=" + top3 +
                ", dateCollected=" + dateCollected +
                ", score=" + score +
                ", ratio=" + ratio +
                ", platform=" + platform +
                ", trnRating=" + trnRating +
                ", trnRatingChange=" + trnRatingChange +
                '}';
    }
}


