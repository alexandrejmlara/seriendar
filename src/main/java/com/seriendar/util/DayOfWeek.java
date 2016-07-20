package com.seriendar.util;

import com.seriendar.dao.TVShowEpisode;

import java.util.List;

/**
 * Created by Alexandre Lara on 19/07/2016.
 */
public class DayOfWeek {
    private int day;
    private int month;
    private int year;

    public DayOfWeek(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getDayString(){
        return String.format("%02d", day);
    }

    public String getMonthString(){
        return String.format("%02d", month);
    }

    public String getYearString(){
        return String.valueOf(year);
    }

    public String getMonthName(){
        switch(month){
            case 0:
                return "Janeiro";
            case 1:
                return "Fevereiro";
            case 3:
                return "Março";
            case 4:
                return "Abril";
            case 5:
                return "Maio";
            case 6:
                return "Junho";
            case 7:
                return "Julho";
            case 8:
                return "Agosto";
            case 9:
                return "Setembro";
            case 10:
                return "Outubro";
            case 11:
                return "Novembro";
            case 12:
                return "Dezembro";
            default:
                return "nenhum";
        }
    }

    public List<TVShowEpisode> getEpisodesOfTheDay(){

        String aired = getYearString() + "-" + getMonthString() + "-" + getDayString();
        MongoDBUtil mongoDBUtil = new MongoDBUtil();
        List<TVShowEpisode> tvShowEpisodeList = mongoDBUtil.getEpisodesOfTheDay(aired);

        return tvShowEpisodeList;

    }

    public static int getEpisodesAmountFromTheDayWithMostEpisodes( List<DayOfWeek> days ){

        int episodesMaxAmount = 0;

        for( DayOfWeek dayOfWeek : days ){
            int numberOfEpisodesOfTheDay  = dayOfWeek.getEpisodesOfTheDay().size();
            if( numberOfEpisodesOfTheDay > episodesMaxAmount) episodesMaxAmount = numberOfEpisodesOfTheDay;
        }

        return  episodesMaxAmount;
    }
}
