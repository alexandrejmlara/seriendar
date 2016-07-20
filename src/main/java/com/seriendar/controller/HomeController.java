package com.seriendar.controller;

import com.seriendar.dao.TVShowEpisode;
import com.seriendar.util.CalendarUtil;
import com.seriendar.util.DayOfWeek;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Controller para a página principal do website.
 *
 * Responsável por obter o dia atual e retornar todos os dias
 * da semana atual e popular tudo com os episódios das séries que
 * irão passar a cada dia.
 *
 * Essa classe também se responsabiliza por lidar com as semanas
 * a frente ou atrás da semana atual. Permitindo que ao clicar nos botões
 * de navegação, o usuário será redirecionado para a semana anterior ou posterior.
 */
@Controller
public class HomeController {

    /**
     * Responde as requisições da página principal, retornando os dias da semana
     * e populando a tabela de episódios, com os episódios referentes a cada dia.
     *
     * @param model Permite a passagem de parâmetros entre a classe controller e a view.
     * @return A página .jsp que responderá a requisição
     *
     */
    @RequestMapping(value = "/")
    public String home(Model model){

        List<DayOfWeek> days = CalendarUtil.getDaysOfWeekArray(new Date(), Calendar.getInstance().getFirstDayOfWeek());
        List<List<TVShowEpisode>> episodesByDay = new ArrayList<List<TVShowEpisode>>();

        for( int i = 0; i < days.size(); i++ ){
            episodesByDay.add(i, days.get(i).getEpisodesOfTheDay());
        }

        model.addAttribute("days", days);
        model.addAttribute("week", 0);
        model.addAttribute("episodesByDay", episodesByDay);
        model.addAttribute("maxEpisodesInADay", DayOfWeek.getEpisodesAmountFromTheDayWithMostEpisodes(days));

        return "home";
    }

    /**
     * Responde as requisições das semanas anteriores ou posteriores à semana atual,
     * retornando os dias da semana e populando a tabela de episódios, com os episódios
     * referentes a cada dia.
     *
     * @param weekDifference Diferença de semanas com relação a atual
     * @param model Permite a passagem de parâmetros entre a classe controller e a view.
     * @return A página .jsp que responderá a requisição
     *
     */
    @GetMapping("/week/{weekDifference}")
    public String homeDate(@PathVariable String weekDifference, Model model){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.WEEK_OF_MONTH, Integer.parseInt(weekDifference));
        date = c.getTime();

        List<DayOfWeek> days = CalendarUtil.getDaysOfWeekArray(date, Calendar.getInstance().getFirstDayOfWeek());
        List<List<TVShowEpisode>> episodesByDay = new ArrayList<List<TVShowEpisode>>();

        for( int i = 0; i < days.size(); i++ ){
            episodesByDay.add(i, days.get(i).getEpisodesOfTheDay());
        }

        model.addAttribute("days", days);
        model.addAttribute("week", Integer.parseInt(weekDifference));
        model.addAttribute("episodesByDay", episodesByDay);
        model.addAttribute("maxEpisodesInADay", DayOfWeek.getEpisodesAmountFromTheDayWithMostEpisodes(days));

        return "home";
    }
}
