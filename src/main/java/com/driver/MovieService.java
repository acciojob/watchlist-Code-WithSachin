package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component   // as we require object of service layer
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    public Movie getMovie(String name){
        return movieRepository.getMovie(name);
    }

    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public Director getdirector(String name){
        return movieRepository.getDirector(name);
    }

    public List<String> getAllMovies(){
        return movieRepository.getAllMovies();
    }

    public void directoMoviepair(String movieName, String directorname){
        movieRepository.directorMoviePair(movieName, directorname);
    }
    public List<String>getMoviesByDirectorName(String directorname){
        return movieRepository.getMoviesByDirectorName(directorname);
    }

    public void deleteDirectorByName(String directorName){
        movieRepository.deleteDirectorByName(directorName);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}
