package main.services;

import main.models.Movie;
import main.utils.C;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MovieService {

    public List<Movie> getAllMovies(boolean canPrintResult) throws IOException {

        File archive = new File("filmes.txt");
        List<Movie> movies;

        if (!archive.exists()) {
            throw new FileNotFoundException("Arquivo nao encontrado!");
        }

        try (BufferedReader buffer = new BufferedReader(new FileReader(archive))) {

            movies = buffer.lines()
                    .filter(line -> !line.contains("sinopse"))
                    .map(line -> line.split(";"))
                    .map(pos -> {
                        Movie movie = new Movie(pos[0], pos[1], pos[2], pos[4], pos[3], pos[5], pos[6], pos[7], pos[8]);

                        if (canPrintResult) {
                            C.printf(movie.toString());
                        }
                        return movie;
                    })
                    .collect(Collectors.toList());
        }

        return movies;
    }

    public void getAllMoviesByYear() throws IOException {

        List<Movie> movies = getAllMovies(false);

        Scanner reader = new Scanner(System.in);

        C.printf("Entre com um ano para a busca");
        String year = reader.next();

        movies.stream()
                .filter(movie -> movie.getRelease().contains(year))
                .forEach(movie -> C.printf(movie.toString()));
    }

    public void getBiggestMovieOfTicketOffice() throws IOException {

        List<Movie> movies = getAllMovies(false);

        movies.stream()
                .forEach(movie -> {
                    AtomicInteger counter = new AtomicInteger();

                    movies.stream()
                            .forEach(movieInto -> {
                                int valueOne = Integer.parseInt(movie.getTotalPublic());
                                int valueTwo = Integer.parseInt(movieInto.getTotalPublic());

                                if (valueOne > valueTwo) {
                                    counter.getAndIncrement();
                                }
                            });

                    if (counter.get() >= movies.size() - 1) {
                        C.printf("Filme com maior publico: " + movie.getTitle() + " com public de: " + movie.getTotalPublic());
                    }
                });


    }

    public void ordenateMoviesByDirectorName() throws IOException {

        List<Movie> movies = getAllMovies(false);

        movies.stream()
                    .sorted((m1, m2) -> m1.getDirection().compareTo(m2.getDirection()))
                    .forEach(movie -> C.printf(movie.toString()));
    }

    public void ordenateMoviesByCategory() throws IOException {

        List<Movie> movies = getAllMovies(false);

        movies.stream()
                .sorted((m1, m2) -> m1.getGenre().compareTo(m2.getGenre()))
                .forEach(movie -> C.printf(movie.toString()));
    }

    public void calculateClassificationMediaOfAllMovies() throws IOException {

        List<Movie> movies = getAllMovies(false);
        AtomicInteger counter = new AtomicInteger();

        movies.stream().forEach(movie -> {
            int classification = Integer.parseInt(movie.getClassification());
            counter.addAndGet(classification);
        });

        C.printf("Calculo media da classificacao com todos os filmes: " + counter.get());
    }

    public void calculatePublicMediaOfAllMovies() throws IOException {

        List<Movie> movies = getAllMovies(false);
        AtomicInteger counter = new AtomicInteger();

        movies.stream().forEach(movie -> {
            int classification = Integer.parseInt(movie.getTotalPublic());
            counter.addAndGet(classification);
        });

        C.printf("Calculo media publico de todos os filmes: " + counter.get());
    }
}
