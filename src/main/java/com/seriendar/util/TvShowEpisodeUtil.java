package com.seriendar.util;

import com.seriendar.dao.TVShowEpisode;

import java.util.List;

/**
 * Created by Alexandre Lara on 20/07/2016.
 */
public class TvShowEpisodeUtil {

    public static int getHighestSeason( List<TVShowEpisode> tvShowEpisodeList ){
        int maxSeason = 0;

        for( TVShowEpisode tv : tvShowEpisodeList ){
            if(tv.getAiredSeason() > maxSeason) maxSeason = tv.getAiredSeason();
        }

        return maxSeason;
    }

}
