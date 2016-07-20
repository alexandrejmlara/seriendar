package com.seriendar.util;

import com.seriendar.dao.TVShowEpisode;

import java.util.List;

/**
 * Contém uma série de atributos e métodos para manipulação
 * de cada dia da semana.
 *
 * Tem como finalidade popular o calendário de séries
 * da página inicial com informações como o dia e os episódios que
 * irão ser exibidos no dia.
 *
 */
public class DayOfWeek {
    /**
     * Dia de referência
     */
    private int day;

    /**
     * Mês de referência
     */
    private int month;

    /**
     * Ano de referência
     */
    private int year;

    /**
     * Construtor responsável por inicializar o objeto {@link DayOfWeek} com
     * uma data.
     *
     * @param day Dia de referência
     * @param month Mês de referência
     * @param year Ano de referência
     */
    public DayOfWeek(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Recupera o dia de referência
     *
     * @return Dia de referência
     */
    public int getDay() {
        return day;
    }

    /**
     * Recupera o mês de referência
     *
     * @return Mês de referência
     */
    public int getMonth() {
        return month;
    }

    /**
     * Recupera o ano de referência
     *
     * @return Ano de referência
     */
    public int getYear() {
        return year;
    }

    /**
     * Recupera o dia em formato de string contendo duas casas.
     * Ex: Dia 1 = Dia 01
     *
     * @return Dia contendo duas casas
     */
    public String getDayString(){
        return String.format("%02d", day);
    }

    /**
     * Recupera o mês em formato de string contendo duas casas.
     * Ex: Mês 1 = Mês 01
     *
     * @return Mês contendo duas casas
     */
    public String getMonthString(){
        return String.format("%02d", month);
    }

    /**
     * Retorna o ano de referência
     *
     * @return Ano de referência
     */
    public String getYearString(){
        return String.valueOf(year);
    }

    /**
     * Retorna o mês por extenso em Português(Brasileiro)
     *
     * @return Mês por extenso em Português(Brasileiro)
     */
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

    /**
     * Retorna a lista de episódios no dia
     *
     * @return Lista de episódios no dia
     */
    public List<TVShowEpisode> getEpisodesOfTheDay(){

        String aired = getYearString() + "-" + getMonthString() + "-" + getDayString();
        MongoDBUtil mongoDBUtil = new MongoDBUtil();
        List<TVShowEpisode> tvShowEpisodeList = mongoDBUtil.getEpisodesOfTheDay(aired);

        return tvShowEpisodeList;

    }

    /**
     * Retorna a quantidade máxima de episódios em um dia
     *
     * @return Lista de episódios no dia
     */
    public static int getEpisodesAmountFromTheDayWithMostEpisodes( List<DayOfWeek> days ){

        int episodesMaxAmount = 0;

        for( DayOfWeek dayOfWeek : days ){
            int numberOfEpisodesOfTheDay  = dayOfWeek.getEpisodesOfTheDay().size();
            if( numberOfEpisodesOfTheDay > episodesMaxAmount) episodesMaxAmount = numberOfEpisodesOfTheDay;
        }

        return  episodesMaxAmount;
    }
}
