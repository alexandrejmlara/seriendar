package com.seriendar.util;

/**
 * Contém uma lista de constantes que são utilizados para
 * controle e execução da API e do banco de dados.
 *
 */
public class Constants {
    /**
     * Constante contendo a URL padrão da API
     */
    public final static String API_URL = "https://api.thetvdb.com";

    /**
     * Constante contendo a API KEY que é utilizada para realizar requisições na API
     */
    public final static String API_KEY = "4B305CD81E6EA32B";

    /**
     * Língua padrão de comunicação com a API
     */
    public final static String API_LANGUAGE = "en";

    /**
     * Nome da categoria de login na API
     */
    public final static String API_AUTHENTICATION_LOGIN = "login";

    /**
     * Nome da categoria de atualização de Token na API
     */
    public final static String API_AUTHENTICATION_REFRESH_TOKEN = "refresh_token";

    /**
     * Nome da categoria de episódios na API
     */
    public final static String API_EPISODES = "episodes";

    /**
     * Nome da categoria de séries na API
     */
    public final static String API_SERIES = "series";

    /**
     * Nome do banco de dados no MongoDB
     */
    public final static String DB_NAME = "seriendar";

    /**
     * Nome da coleção de séries no MongoDB
     */
    public final static String DB_COLLECTION_TVSHOWS = "tvshows";

    /**
     * Nome da coleção de episódios no MongoDB
     */
    public final static String DB_COLLECTION_EPISODES = "episodes";

}
