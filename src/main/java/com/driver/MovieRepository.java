package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Component
public class MovieRepository {
    HashMap<String, Movie>movies=new HashMap<>();
    HashMap<String, Director> directors=new HashMap<>();
    HashMap<String, List<String>>moviesDirector=new HashMap<>();

    public void addMovie(Movie movie){
        movies.put(movie.getName(), movie);
    }
    public Movie getMovie(String name){
        return movies.get(name);
    }

    public void addDirector(Director director){
        directors.put(director.getName(), director);
    }

    public Director getDirector(String name){
        return directors.get(name);
    }

    public List<String> getAllMovies(){
        List<String> listOfAllMovies=new ArrayList<>();
        for(Movie movie: movies.values()){
            listOfAllMovies.add(movie.getName());
        }
        return listOfAllMovies;
    }

    public void directorMoviePair(String movieName, String directorName){
        List<String> list = new ArrayList<>();
        if (moviesDirector.containsKey(directorName)) {
            list = moviesDirector.get(directorName);
            list.add(movieName);
            moviesDirector.put(directorName, list);
        } else {
            list.add(movieName);
            moviesDirector.put(directorName, list);
        }
    }

    public List<String> getMoviesByDirectorName(String directorName){
        return moviesDirector.get(directorName);
    }

    public void deleteDirectorByName(String directorName){
           List<String>movieList=new ArrayList<>();
           movieList=moviesDirector.get(directorName);
            moviesDirector.remove(directorName);
            directors.remove(directorName);

            for(String movieName:movieList){
                movies.remove(movieName);
            }
    }

    public void deleteAllDirectors(){
        for(String directorName:moviesDirector.keySet()){
            deleteDirectorByName(directorName);
        }
    }
}
