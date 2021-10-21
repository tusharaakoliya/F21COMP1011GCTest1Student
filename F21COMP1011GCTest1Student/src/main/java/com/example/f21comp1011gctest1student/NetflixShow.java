package com.example.f21comp1011gctest1student;

import java.util.Arrays;
import java.util.List;

public class NetflixShow {

    private String showId, type, title, director, cast, rating;

    public NetflixShow(String showId, String type, String title, String director, String cast, String rating) {
        setShowId(showId);
        setType(type);
        setTitle(title);
        setDirector(director);
        setCast(cast);
        setRating(rating);
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        if (showId.startsWith("s") && showId.matches("^s[0-9]"))
        {
            this.showId = showId;
        }
        else
        {
            throw new IllegalArgumentException(showId + " is not a valid Id");
        }

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {

        List<String> typeMatch = Arrays.asList("Movie", "TV Show");

        if (typeMatch.contains(type))
        {
            this.type = type;
        }
        else
        {
            throw new IllegalArgumentException(type + " is not a valid Type");
        }

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.length() >=2 ) {
            this.title = title;
        }
        else
        {
            throw new IllegalArgumentException("Title should be at least 2 characters long");
        }

    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        List<String> ratingMatch = Arrays.asList("PG-13", "R","TV-14","TV-G","TV-MA","TV-Y","TV-Y7");
        if (ratingMatch.contains(rating)) {
            this.rating = rating;
        }
        else
        {
            throw new IllegalArgumentException(rating + " is not a valid rating please enter from following "  + ratingMatch);
        }

    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        if (director.length() >= 2)
        {
            this.director = director;
        }
        else
        {
            throw new IllegalArgumentException("Director should be 2 character long");
        }

    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        if (cast.length() >= 5)
        {
            this.cast = cast;
        }
    }
    
}
