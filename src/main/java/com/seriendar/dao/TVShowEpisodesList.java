package com.seriendar.dao;

import java.util.List;
import java.util.Map;

public class TVShowEpisodesList {
    Map<String, Integer> links;
    List<TVShowEpisode> data;

    public Map<String, Integer> getLinks() {
        return links;
    }

    public List<TVShowEpisode> getData() {
        return data;
    }
}
