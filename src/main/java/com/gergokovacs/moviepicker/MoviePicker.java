package com.gergokovacs.moviepicker;

import com.gergokovacs.moviepicker.data.Credit;
import com.gergokovacs.moviepicker.data.Title;
import com.gergokovacs.moviepicker.data.TitleWithSimilarityScore;
import com.gergokovacs.moviepicker.logic.CreditManager;
import com.gergokovacs.moviepicker.logic.TitleManager;
import com.gergokovacs.moviepicker.ui.InputScanner;
import com.gergokovacs.moviepicker.ui.Printer;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class MoviePicker {
    private final TitleManager titles;
    private final CreditManager credits;
    private final InputScanner scanner;
    private final Printer printer;


    public MoviePicker(CreditManager credits, TitleManager titles, InputScanner scanner, Printer printer) {
        this.credits = credits;
        this.titles = titles;
        this.scanner = scanner;
        this.printer = printer;
    }

    public void run() {
        boolean keepAppRunning = true;
        while (keepAppRunning) {
            this.printer.printMenu();
            Integer numericUserInput = this.scanner.getNumericUserInput("Please select a menu item!");
            keepAppRunning = invokeMenuItem(numericUserInput);
        }
    }

    private boolean invokeMenuItem(Integer selectedMenu) {
        switch (selectedMenu) {
            case 0 -> { return false; }
            case 1 -> getTopNImdbScoreFromTitles();
            case 2 -> getAllCreditsForTitle();
            case 3 -> getTopNImdbScoreFromGivenGenre();
            case 4 -> getAllTitlesByCreditName();
            case 5 -> recommendMeSomethingBasedOnAMovie();
            default -> System.out.println("Invalid menu item selection!\n");
        }
        return true;
    }


    private void getTopNImdbScoreFromTitles() {
        Integer n = scanner.getNumericUserInput("Length of the list?");
        List<Title> topNImdbScoreFromTitles = titles.getTopNImdbScoreFromTitles(n);
        printer.printTitleOutcome(topNImdbScoreFromTitles);
    }

    private void getAllCreditsForTitle() {
        List<Credit> allCreditsForTitle = null;
        while (allCreditsForTitle == null) {
            String movieTitle = scanner.getUserInput("Type in a name!");
            try {
                allCreditsForTitle = titles.getAllCreditsForTitle(movieTitle, credits.getCredits());
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
        printer.printCreditOutcome(allCreditsForTitle);
    }

    private void getTopNImdbScoreFromGivenGenre() {
        String genre = scanner.getUserInput("Type in a genre!");
        Integer n = scanner.getNumericUserInput("Length of the list?");
        List<Title> topNImdbScoreFromGivenGenre = titles.getTopNImdbScoreFromGivenGenre(genre, n);
        printer.printTitleOutcome(topNImdbScoreFromGivenGenre);
    }

    private void getAllTitlesByCreditName() {
        String name = scanner.getUserInput("Type in a name!");
        List<Title> allTitlesByCreditName = credits.getAllTitlesByCreditName(name, titles.getTitles());
        printer.printTitleOutcome(allTitlesByCreditName);
    }

    private void recommendMeSomethingBasedOnAMovie() {
        List<TitleWithSimilarityScore> similarMoviesByTitle = null;
        while (similarMoviesByTitle == null) {
            String title = scanner.getUserInput("Type in a name!");
            Integer length = scanner.getNumericUserInput("Length of the list?");
            try {
                System.out.println("Loading...");
                similarMoviesByTitle = titles.getSimilarMoviesByTitle(title, credits.getCredits(), length);
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        printer.printSimilarityOutcome(similarMoviesByTitle);
    }
}
