package com.seriendar.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Alexandre Lara on 18/07/2016.
 */
public class TVShowEpisode {
    private Integer id;
    private String seriesName;
    private int absoluteNumber;
    private int airedEpisodeNumber;
    private int airedSeason;
    private Integer airedSeasonID;
    private int dvdEpisodeNumber;
    private int dvdSeason;
    private String episodeName;
    private String firstAired;
    private String overview;
    private Integer tvShowId;

    private Map<String, String> language;

    public Integer getId() {
        return id;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getAbsoluteNumber() {
        return absoluteNumber;
    }

    public int getAiredEpisodeNumber() {
        return airedEpisodeNumber;
    }

    public int getAiredSeason() {
        return airedSeason;
    }

    public Integer getAiredSeasonID() {
        return airedSeasonID;
    }

    public int getDvdEpisodeNumber() {
        return dvdEpisodeNumber;
    }

    public int getDvdSeason() {
        return dvdSeason;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public String getFirstAired() {
        return firstAired;
    }

    public String getFirstAiredPtBr(){
        Locale brasil = new Locale("pt", "BR");
        String stringToReturn = null;
        SimpleDateFormat tradeDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = tradeDate.parse(firstAired);
            DateFormat f = DateFormat.getDateInstance(DateFormat.FULL, brasil);
            stringToReturn = f.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return stringToReturn;
    }

    public Map<String, String> getLanguage() {
        return language;
    }

    public String getOverview() {
        return overview;
    }

    public String getAiredEpisodeNumberString(){
        return String.format("%02d", airedEpisodeNumber);
    }

    public String getAiredEpisodeSeasonString(){
        return String.format("%02d", airedSeason);
    }

    public Integer getTvShowId() {
        return tvShowId;
    }
}
