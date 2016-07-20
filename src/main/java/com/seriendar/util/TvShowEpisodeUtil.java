package com.seriendar.util;

import com.seriendar.dao.TVShowEpisode;

import java.util.List;

/**
 * Manipula e gerencia um episódio
 */
public class TvShowEpisodeUtil {

    /**
     * Método estático que obtem o número da última temporada da série.
     *
     * @param tvShowEpisodeList Lista contendo os episódios da série.
     * @return Número da última temporada da série
     */
    public static int getHighestSeason( List<TVShowEpisode> tvShowEpisodeList ){
        int maxSeason = 0;

        for( TVShowEpisode tv : tvShowEpisodeList ){
            if(tv.getAiredSeason() > maxSeason) maxSeason = tv.getAiredSeason();
        }

        return maxSeason;
    }

}
