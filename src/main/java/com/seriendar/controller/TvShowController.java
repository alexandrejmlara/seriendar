package com.seriendar.controller;

import com.seriendar.dao.TVShow;
import com.seriendar.dao.TVShowEpisode;
import com.seriendar.util.CalendarUtil;
import com.seriendar.util.DayOfWeek;
import com.seriendar.util.MongoDBUtil;
import com.seriendar.util.TvShowEpisodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *  Controla as requisições realizada em cada url pertencente a uma série
 *  em específico.
 *   *
 */
@Controller
public class TvShowController {

    /**
     *  Obtém a série do banco de dados e seus respectivos episódios. Ordena os
     *  episodios pela ordem de lançamento.
     *
     * @param tvShowId Id da série
     * @param model Permite a passagem de parâmetros entre a classe controller e a view.
     * @return O nome da view responsável por mostrar o resultado da requisição
     */
    @GetMapping("/tvshow/{tvShowId}")
    public String tvshow(@PathVariable String tvShowId, Model model){

        MongoDBUtil mongoDBUtil = new MongoDBUtil();
        TVShow tvShow = mongoDBUtil.getTVSHow(Integer.parseInt(tvShowId));
        List<TVShowEpisode> tvShowEpisodeList = mongoDBUtil.getTVShowEpisodesList(Integer.parseInt(tvShowId));

        Collections.sort(tvShowEpisodeList, new Comparator<TVShowEpisode>() {
            @Override public int compare(TVShowEpisode e1, TVShowEpisode e2) {
                return e1.getAiredEpisodeNumber() - e2.getAiredEpisodeNumber(); // Ascending
            }
        });

        model.addAttribute("tvshow", tvShow);
        model.addAttribute("episodes", tvShowEpisodeList);
        model.addAttribute("seasons", TvShowEpisodeUtil.getHighestSeason(tvShowEpisodeList));


        return "tvshow";
    }


}
