package com.seriendar.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.seriendar.dao.TVShow;
import com.seriendar.dao.TVShowEpisode;
import com.seriendar.dao.TVShowEpisodesList;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * Gerencia as operações no banco de dados MongoDB.
 *
 * Instancia a conexão do cliente com o banco de dados, abre a conexão
 * com o banco de dados MongoDB.
 *
 * Também atua na serialização e desserialização de objetos utilizando Gson.
 *
 */
public class MongoDBUtil {
    /**
     * Cliente do MongoDB que mantém a conexão com o servidor
     */
    private MongoClient mongoClient = null;

    /**
     * Base de dados do MongoDB
     */
    private MongoDatabase db = null;

    /**
     * Objeto Gson para serialização e desserialização de objetos Java
     */
    private Gson gson = null;

    /**
     * Construtor que inicializa o banco de dados, a conexão do cliente
     * e o objeto Gson.
     *
     */
    public MongoDBUtil() {
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase(Constants.DB_NAME);
        gson = new GsonBuilder().create();

    }

    /**
     * Recupera uma série com o identificador único da mesma
     *
     * @param id Identificador único da série
     * @return A série que contém o identificador passado como parâmetro
     */
    public TVShow getTVSHow(Integer id) {
        MongoCollection tvShowsCollections = db.getCollection(Constants.DB_COLLECTION_TVSHOWS);
        MongoCursor<Document> mCursorTvShows = tvShowsCollections.find(eq("_id", id)).iterator();
        TVShow tvShow = null;

        if (mCursorTvShows.hasNext()) {
            Document docTvShow = mCursorTvShows.next();
            docTvShow.put("id", docTvShow.get("_id"));
            docTvShow.remove("_id");
            tvShow = gson.fromJson(docTvShow.toJson(), TVShow.class);
        }

        return tvShow;
    }

    /**
     * Recupera uma lista de episódios de uma série em específico.
     *
     * @param id Identificador da série
     * @return Lista de episódios de uma série
     */
    public List<TVShowEpisode> getTVShowEpisodesList(Integer id) {

        List<TVShowEpisode> tvShowEpisodeList = new ArrayList<TVShowEpisode>();
        MongoCollection episodesCollections = db.getCollection(Constants.DB_COLLECTION_EPISODES);
        MongoCursor<Document> mCursorEpisodes = episodesCollections.find(eq("tvShowId", id)).iterator();

        while (mCursorEpisodes.hasNext()) {

            Document docEpisode = mCursorEpisodes.next();
            docEpisode.put("id", docEpisode.get("_id"));
            docEpisode.remove("_id");
            tvShowEpisodeList.add(gson.fromJson(docEpisode.toJson(), TVShowEpisode.class));

        }

        return tvShowEpisodeList;

    }

    /**
     * Salva a série no banco de dados MongoDB.
     *
     * @param tvShow Série a ser salva no banco de dados MongoDB
     * @param tvShowEpisodesList Lista de episódios da série a ser salva no banco de dados MongoDB
     */
    public void saveTVShow(TVShow tvShow, TVShowEpisodesList tvShowEpisodesList) {
        MongoCollection tvShowsCollection = db.getCollection(Constants.DB_COLLECTION_TVSHOWS);
        Document docTVShow = Document.parse(gson.toJson(tvShow));
        docTVShow.remove("id");
        docTVShow.put("_id", tvShow.getId());
        tvShowsCollection.insertOne(docTVShow);

        saveTVShowEpisodes(tvShow.getId(), tvShowEpisodesList);
    }

    /**
     * Recupera a lista de episódios em um dia específico
     *
     * @param firstAired Data de referência
     * @return Lista de episódios de um dia específico
     */
    public List<TVShowEpisode> getEpisodesOfTheDay(String firstAired) {
        MongoCollection episodesCollection = db.getCollection(Constants.DB_COLLECTION_EPISODES);
        MongoCursor<Document> mCursorEpisodes = episodesCollection.find(eq("firstAired", firstAired)).iterator();
        List<TVShowEpisode> listEpisodes = new ArrayList<TVShowEpisode>();
        while (mCursorEpisodes.hasNext()) {
            Document episode = mCursorEpisodes.next();

            MongoCollection tvShowsCollection = db.getCollection(Constants.DB_COLLECTION_TVSHOWS);
            MongoCursor<Document> mCursorTvShows = tvShowsCollection.find(eq("_id", episode.get("tvShowId"))).iterator();

            if (mCursorTvShows.hasNext()) {
                Document docTvShow = mCursorTvShows.next();
                episode.put("seriesName", docTvShow.get("seriesName"));
            }
            TVShowEpisode tvShowEpisode = gson.fromJson(episode.toJson(), TVShowEpisode.class);
            listEpisodes.add(tvShowEpisode);
        }

        return listEpisodes;

    }

    /**
     * Salva os episódios da série no banco de dados MongoDB.
     *
     * @param tvShowId Identificador único da série
     * @param tvShowEpisodesList Lista de episódios a serem salvos no banco de dados MongoDB
     */
    private void saveTVShowEpisodes(Integer tvShowId, TVShowEpisodesList tvShowEpisodesList) {
        MongoCollection tvShowsCollection = db.getCollection(Constants.DB_COLLECTION_TVSHOWS);
        MongoCollection episodesCollection = db.getCollection(Constants.DB_COLLECTION_EPISODES);

        for (TVShowEpisode episode : tvShowEpisodesList.getData()) {

            Document docEpisode = Document.parse(gson.toJson(episode));
            docEpisode.append("tvShowId", tvShowId);
            docEpisode.put("_id", docEpisode.get("id"));
            docEpisode.remove("id");
            episodesCollection.insertOne(docEpisode);


            tvShowsCollection.updateOne(
                    new Document("_id", tvShowId),
                    new Document("$push", new Document("episodes", docEpisode.get("_id")))
            );

        }
    }

}
