package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import org.parceler.Parcel;
@Parcel //to indicate a class is Parcelable
public class Movie {
    String posterPath;
    String title;
    String overview;
    String backdropPath;
    Double voteAverage;
    public Movie(){}



    public Movie(JSONObject jsonInfo) throws JSONException {
        posterPath=jsonInfo.getString("poster_path");
        title = jsonInfo.getString("title");
        overview=jsonInfo.getString("overview");
        backdropPath=jsonInfo.getString("backdrop_path");
        voteAverage=jsonInfo.getDouble("vote_average");
    }
    public static List<Movie> fromJsonArray(JSONArray movieJSONArray) throws JSONException {
        List<Movie> movies= new ArrayList<>();
        for(int i=0; i<movieJSONArray.length(); i++){
            movies.add(new Movie(movieJSONArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }
    public String getBackDropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }
}
