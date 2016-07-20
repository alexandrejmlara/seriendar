package com.seriendar.dao;

import java.util.List;
import java.util.Map;

/**
 * Mantém uma lista de links e dados relacionados a um conjunto
 * de episódios de uma série específica.
 *
 */
public class TVShowEpisodesList {
    /**
     * Links relacionados à lista de episódios
     */
    Map<String, Integer> links;
    /**
     * Lista contendo episódios da série
     */
    List<TVShowEpisode> data;

    /**
     * Recupera os links relacionados a lista de episódios
     *
     * @return Links
     */
    public Map<String, Integer> getLinks() {
        return links;
    }

    /**
     * Recupera a lista de episódios da série
     *
     * @return Lista de episódios da série
     */
    public List<TVShowEpisode> getData() {
        return data;
    }
}
