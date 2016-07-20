package com.seriendar.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * Contém informações relacionadas a um episódios de uma
 * série.
 *
 *
 */
public class TVShowEpisode {
    /**
     * Identificador único do episódio
     */
    private Integer id;

    /**
     * Nome da série
     */
    private String seriesName;

    /**
     * Número absoluto do episódio na série
     */
    private int absoluteNumber;

    /**
     * Número do episódio na temporada
     */
    private int airedEpisodeNumber;

    /**
     * Número da temporada
     */
    private int airedSeason;

    /**
     * Identificador único da temporada
     */
    private Integer airedSeasonID;

    /**
     * Número do episódio no DVD
     */
    private int dvdEpisodeNumber;

    /**
     * Temporada do episódio no DVD
     */
    private int dvdSeason;

    /**
     * Nome do episódio
     */
    private String episodeName;

    /**
     * Data de lançamento do episódio
     */
    private String firstAired;

    /**
     * Sinopse do episódio
     */
    private String overview;

    /**
     * Número de identificador da série
     */
    private Integer tvShowId;

    /**
     * Línguas utilizadas pela série
     */

    private Map<String, String> language;

    /**
     * Recupera o identificador único da série
     * @return Identificador único da série
     */
    public Integer getId() {
        return id;
    }

    /**
     * Recupera o nome da série
     * @return Nome da série
     */
    public String getSeriesName() {
        return seriesName;
    }

    /**
     * Altera o nome da série
     *
     * @param seriesName Nome da série
     */
    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    /**
     * Recupera o número absoluto do episódio na série
     *
     * @return Número absoluto do episódio na série
     */
    public int getAbsoluteNumber() {
        return absoluteNumber;
    }

    /**
     * Recupera o número do episódio na temporada
     *
     * @return Número do episódio na temporada
     */
    public int getAiredEpisodeNumber() {
        return airedEpisodeNumber;
    }

    /**
     * Recupera o número da temporada
     *
     * @return Número da temporada
     */
    public int getAiredSeason() {
        return airedSeason;
    }

    /**
     * Recupera o número identificador da temporada
     *
     * @return Número identificador da temporada
     */
    public Integer getAiredSeasonID() {
        return airedSeasonID;
    }

    /**
     * Recupera o número do episódio no DVD
     *
     * @return Número do episódio no DVD
     */
    public int getDvdEpisodeNumber() {
        return dvdEpisodeNumber;
    }

    /**
     * Recupera o número da temporada no DVD
     *
     * @return Número da temporada no DVD
     */
    public int getDvdSeason() {
        return dvdSeason;
    }

    /**
     * Recupera o nome do episódio
     *
     * @return Nome do episódio
     */
    public String getEpisodeName() {
        return episodeName;
    }

    /**
     * Recupera a data de lançamento do episódio
     *
     * @return Data de lançamento do episódio
     */
    public String getFirstAired() {
        return firstAired;
    }

    /**
     * Recupera a data de lançamento do episódio em formato Português (Brasil)
     *
     * @return Data de lançamento do episódio em formato Português (Brasil)
     */
    public String getFirstAiredPtBr() {
        Locale brasil = new Locale("pt", "BR");
        String stringToReturn = null;
        SimpleDateFormat tradeDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = tradeDate.parse(firstAired);
            DateFormat f = DateFormat.getDateInstance(DateFormat.FULL, brasil);
            stringToReturn = f.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return stringToReturn;
    }

    /**
     * Recupera as linguagens do episódio
     *
     * @return Linguagens do episódio
     */
    public Map<String, String> getLanguage() {
        return language;
    }

    /**
     * Recupera a sinopse do episódio
     *
     * @return Sinopse do episódio
     */
    public String getOverview() {
        return overview;
    }

    /**
     * Recupera o número do episódio com duas casas (exemplo: Episódio 1 = Episódio 01
     *
     * @return Número do episódio com duas casas
     */
    public String getAiredEpisodeNumberString() {
        return String.format("%02d", airedEpisodeNumber);
    }

    /**
     * Recupera o número da temporada com duas casas (exemplo: Temporada 1 = Temporada 01
     *
     * @return Número da temporada com duas casas
     */
    public String getAiredEpisodeSeasonString() {
        return String.format("%02d", airedSeason);
    }

    /**
     * Recupera o número identificador da série
     *
     * @return Número identificador da série
     */
    public Integer getTvShowId() {
        return tvShowId;
    }
}
