package com.seriendar.dao;


import java.util.Date;
import java.util.List;

/**
 * Contém atributos de cada série que podem ser retornados
 * e utilizados a fim de obter informações específicas de cada
 * série.
 *
 */
public class TVShow {
    /**
     * Identificador único da série
     */
    private Integer id;

    /**
     * Nome da série
     */
    private String seriesName;

    /**
     * Outros nomes pra série (apelidos)
     */
    private List<String> aliases;

    /**
     * Localização do banner da série (obtida via API), deve-se unir com http://thetvdb.com/banners/
     */
    private String banner;

    /**
     * Identificador do conjunto da série
     */
    private String seriesId;

    /**
     * Status atual da série
     */
    private String status;

    /**
     * Dia de lançamento da série
     */
    private String firstAired;

    /**
     * Canal/rede responsável pela série
     */
    private String network;

    /**
     *  Número de identificação do canal/rede
     */
    private String networkId;

    /**
     * Quantidade de minutos em média de cada episódio
     */
    private String runtime;

    /**
     *  Lista contendo as categorias da série
     */
    private List<String> genre;

    /**
     * Sinopse da série
     */
    private String overview;

    /**
     * Última atualização da série
     */
    private Integer lastUpdated;

    /**
     * Dia da semana em que a série é exibida
     */
    private String airsDayOfWeek;

    /**
     * Hora da semana em que a série é exibida
     */
    private String airsTime;

    /**
     * Pontuação da série
     */
    private String rating;

    /**
     * Id da série no site IMDB
     */
    private String imdbId;

    /**
     * Id da série no ZAP2IT
     */
    private String zap2itId;

    /**
     * Data em que a série foi adicionada à API
     */
    private String added;

    /**
     * Identificador de quem adicionou a série à API
     */
    private Integer addedBy;

    /**
     * Nota do site da API
     */
    private Double siteRating;

    /**
     * Quantidade de notas dadas pelos usuários no site da API
     */
    private Integer siteRatingCount;


    /**
     * Recupera o identificador único da série
     *
     * @return Identificador único da série
     */
    public Integer getId() {
        return id;
    }

    /**
     * Recupera o nome da série
     *
     * @return Nome da série
     */
    public String getSeriesName() {
        return seriesName;
    }

    /**
     * Recupera os outros nomes da série (apelidos)
     *
     * @return Apelidos da série
     */
    public List<String> getAliases() {
        return aliases;
    }

    /**
     * Recupera a localização do banner da série
     *
     * @return Localização do banner da série
     */
    public String getBanner() {
        return banner;
    }

    /**
     * Recupera o id do conjunto da série
     * @return id do conjunto da série
     *
     */
    public String getSeriesId() {
        return seriesId;
    }

    /**
     * Recupera o status da série
     *
     * @return Status da série
     */
    public String getStatus() {
        return status;
    }

    /**
     * Recupera a data de lançamento da série
     *
     * @return Data de lançamento da série
     */
    public String getFirstAired() {
        return firstAired;
    }

    /**
     * Recupera a rede/canal responsável pela série
     *
     * @return Rede/canal responsável pela série
     */
    public String getNetwork() {
        return network;
    }

    /**
     * Recupera o Id da rede/canal responsável pela série
     *
     * @return Id da rede/canal responsável pela série
     */
    public String getNetworkId() {
        return networkId;
    }

    /**
     * Recupera a quantidade de minutos médio de cada episódio da série
     * @return Quantidade de minutos médio de cada episódio da série
     */
    public String getRuntime() {
        return runtime;
    }

    /**
     * Recupera lista contendo as categorias da série
     *
     * @return Lista contendo as categorias da série
     */
    public List<String> getGenre() {
        return genre;
    }

    /**
     * Recupera a sinopse da série
     *
     * @return Sinopse da série
     */
    public String getOverview() {
        return overview;
    }

    /**
     * Recupera a data de última atualização da série
     *
     * @return Data de última atualização da série
     */
    public Integer getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Recupera o dia de exibição da série na semana
     *
     * @return Dia de exibição da série na semana
     */
    public String getAirsDayOfWeek() {
        return airsDayOfWeek;
    }

    /**
     * Recupera a hora de exibição da série
     *
     * @return Hora de exibição da série
     */
    public String getAirsTime() {
        return airsTime;
    }

    /**
     * Recupera a nota recebida pela série
     *
     * @return Nota recebida pela série
     */
    public String getRating() {
        return rating;
    }

    /**
     * Recupera o identificador no site IMDB
     *
     * @return Identificador no site IMDB
     */
    public String getImdbId() {
        return imdbId;
    }

    /**
     * Recupera o identificador no Zap2it
     *
     * @return Identificador no Zap2it
     */
    public String getZap2itId() {
        return zap2itId;
    }

    /**
     * Recupera a data de adição da série à API
     *
     * @return Data de adição da série à API
     */
    public String getAdded() {
        return added;
    }

    /**
     * Recupera o responsável por ter adicionado a série à API
     *
     * @return Responsável por ter adicionado a série à API
     */
    public Integer getAddedBy() {
        return addedBy;
    }

    /**
     * Recupera a nota recebida pela série no site da API
     *
     * @return Nota recebida pela série no site da API
     */
    public Double getSiteRating() {
        return siteRating;
    }

    /**
     * Recupera a quantidade de notas dadas pelos usuários no site da API
     *
     * @return Quantidade de notas dadas pelos usuários no site da API
     */
    public Integer getSiteRatingCount() {
        return siteRatingCount;
    }
}
