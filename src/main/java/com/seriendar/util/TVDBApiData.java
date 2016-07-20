package com.seriendar.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.seriendar.dao.TVShow;
import com.seriendar.dao.TVShowEpisode;
import com.seriendar.dao.TVShowEpisodesList;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.bson.Document;
import org.json.JSONObject;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexandre Lara on 18/07/2016.
 */
public class TVDBApiData {
    private String token = null;
    private Gson gson;

    public TVDBApiData(){
        gson = new GsonBuilder().create();
    }

    public String getToken() throws IOException {
        Document docApiKey = new Document();
        docApiKey.put("apikey", Constants.API_KEY);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        try{
            HttpPost request = new HttpPost(Constants.API_URL + "/" + Constants.API_AUTHENTICATION_LOGIN);
            StringEntity params = new StringEntity(docApiKey.toJson().toString());
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            if(response != null) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                StringBuffer result = new StringBuffer();
                String line = "";
                while((line = rd.readLine()) != null){
                    result.append(line);
                }
                JSONObject o = new JSONObject(result.toString());
                Document docToken = Document.parse(o.toString());
                token = docToken.getString("token");

            }
        } catch( Exception e ){

        } finally {
            httpClient.close();
        }

        return token;

    }

    public TVShow getTVShow( Long id ) {
        //Document docEpisodeRequest = new Document();
        TVShow tvShow = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpGet request = new HttpGet(Constants.API_URL + "/" + Constants.API_SERIES + "/" + id);
            //StringEntity params = new StringEntity(docEpisodeRequest.toJson().toString());
            request.addHeader("content-type", "application/json");
            request.addHeader("Accept-Language", Constants.API_LANGUAGE);
            request.addHeader("Authorization", "Bearer " + token);
            //request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            if(response != null) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                StringBuffer result = new StringBuffer();
                String line = "";
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }

                JSONObject o = new JSONObject(result.toString());
                Document docTVShow = Document.parse(o.get("data").toString());
                tvShow = gson.fromJson(docTVShow.toJson(), TVShow.class);
            }
        } catch( Exception e ){

        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return tvShow;

    }

    public TVShowEpisodesList getTVShowEpisodesList(Long id ) throws IOException {
        TVShowEpisodesList tvShowEpisodesList = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try{
            HttpGet request = new HttpGet(Constants.API_URL + "/" + Constants.API_SERIES + "/" + id + "/" + Constants.API_EPISODES);
            request.addHeader("content-type", "application/json");
            request.addHeader("Accept-Language", Constants.API_LANGUAGE);
            request.addHeader("Authorization", "Bearer " + token);
            HttpResponse response = httpClient.execute(request);
            if(response != null) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                StringBuffer result = new StringBuffer();
                String line = "";
                while((line = rd.readLine()) != null){
                    result.append(line);
                }
                JSONObject o = new JSONObject(result.toString());
                Document docEpisodesList = Document.parse(o.toString());
                tvShowEpisodesList = gson.fromJson(docEpisodesList.toJson(), TVShowEpisodesList.class);
            }
        } catch( Exception e ){

        } finally {
            httpClient.close();
        }

        return tvShowEpisodesList;
    }


}
