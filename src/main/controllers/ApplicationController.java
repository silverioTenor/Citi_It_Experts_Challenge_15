package main.controllers;

import main.services.MovieService;
import main.utils.C;

import java.util.Scanner;

public class ApplicationController {

    public static void start() {

        Integer option = 0;
        boolean loopIsActive = true;
        MovieService movieService = new MovieService();

        try (Scanner reader = new Scanner(System.in)) {

            C.printf("============================");
            C.printf("BEM VINDO A LOCADORA DIGITAL");
            C.printf("============================\n");

            do {
                C.printf("Escolha uma opcao: \n");

                C.printf("1) Listar todos os filmes");
                C.printf("2) Listar todos os filmes de um ano especifico");
                C.printf("3) Listar o filme de maior bilheteria");
                C.printf("4) Agrupar por nome do diretor");
                C.printf("5) Agrupar por categoria (genero)");
                C.printf("6) Calcular media da classificacao de todos os filmes");
                C.printf("7) Calcular media publico de todos os filmes");
                C.printf("8) Sair \n");

                try {
                    option = Integer.parseInt(reader.next());
                } catch (Exception e) {
                    C.printf("Apenas números inteiros sao permitidos \n" + option);
                }

                if (option instanceof Integer) {

                    try {
                        switch (option) {
                            case 1 -> movieService.getAllMovies(true);
                            case 2 -> movieService.getAllMoviesByYear();
                            case 3 -> movieService.getBiggestMovieOfTicketOffice();
                            case 4 -> movieService.ordenateMoviesByDirectorName();
                            case 5 -> movieService.ordenateMoviesByCategory();
                            case 6 -> movieService.calculateClassificationMediaOfAllMovies();
                            case 7 -> movieService.calculatePublicMediaOfAllMovies();
                            case 8 -> loopIsActive = false;
                            default -> C.printf("Opcao invalida! \n");
                        }
                    } catch (Exception e) {
                        C.printf(e.getMessage());
//                        e.printStackTrace();
                    }
                }

            } while (loopIsActive);
        }

        C.printf("Aplicacao finalizada!");
    }
}
