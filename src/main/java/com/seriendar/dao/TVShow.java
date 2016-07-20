package com.seriendar.dao;


import java.util.Date;
import java.util.List;

/**
 * Created by Alexandre Lara on 18/07/2016.
 */
public class TVShow {
    private Integer id;
    private String seriesName;
    private List<String> aliases;
    private String banner;
    private String seriesId;
    private String status;
    private String firstAired;
    private String network;
    private String networkId;
    private String runtime;
    private List<String> genre;
    private String overview;
    private Integer lastUpdated;
    private String airsDayOfWeek;
    private String airsTime;
    private String rating;
    private String imdbId;
    private String zap2itId;
    private String added;
    private Integer addedBy;
    private Double siteRating;
    private Integer siteRatingCount;


    public Integer getId() {
        return id;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public String getBanner() {
        return banner;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public String getStatus() {
        return status;
    }

    public String getFirstAired() {
        return firstAired;
    }

    public String getNetwork() {
        return network;
    }

    public String getNetworkId() {
        return networkId;
    }

    public String getRuntime() {
        return runtime;
    }

    public List<String> getGenre() {
        return genre;
    }

    public String getOverview() {
        return overview;
    }

    public Integer getLastUpdated() {
        return lastUpdated;
    }

    public String getAirsDayOfWeek() {
        return airsDayOfWeek;
    }

    public String getAirsTime() {
        return airsTime;
    }

    public String getRating() {
        return rating;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getZap2itId() {
        return zap2itId;
    }

    public String getAdded() {
        return added;
    }

    public Integer getAddedBy() {
        return addedBy;
    }

    public Double getSiteRating() {
        return siteRating;
    }

    public Integer getSiteRatingCount() {
        return siteRatingCount;
    }
}
