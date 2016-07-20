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

@Controller
public class HomeController {
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
