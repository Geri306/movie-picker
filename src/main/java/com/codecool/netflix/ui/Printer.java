package com.codecool.netflix.ui;

import com.codecool.netflix.data.Credit;
import com.codecool.netflix.data.Title;
import com.codecool.netflix.data.TitleWithSimilarityScore;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Printer {

    private final Map<String, String> menu;

    public Printer() {
        this.menu = new LinkedHashMap<>() {{
            put("1", "Top movies");
            put("2", "Cast of a movie");
            put("3", "Top movies in a given genre");
            put("4", "All movies of an actor / director");
            put("5", "Recommend me something based on a movie!");
            put("0", "Exit");
        }};
    }

    public void printMenu() {
        for (Map.Entry<String, String> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }

    public void printTitleOutcome(List<Title> titles) {
        for (int i = 0; i < titles.size(); i++) {
            Title title = titles.get(i);
            System.out.println(i + 1 + ": " + title.getTitle() + " (id: " + title.getId() + ", imdbScore: " + title.getImdbScore() + ")");
        }
        System.out.println("\n");
    }

    public void printCreditOutcome(List<Credit> credits) {
        for (int i = 0; i < credits.size(); i++) {
            Credit credit = credits.get(i);
            System.out.printf("%s: %s as %s%n", i + 1, credit.getName(), credit.getRole());
        }
        System.out.println("\n");
    }

    public void printSimilarityOutcome(List<TitleWithSimilarityScore> titles) {
        for (int i = 0; i < titles.size(); i++) {
            TitleWithSimilarityScore similarTitle = titles.get(i);
            System.out.printf("%s: %s (SimilarityScore™: %s)%n", i + 1, similarTitle.getTitle().getTitle(), similarTitle.getSimilarityScore());
        }
        System.out.println("\n");
    }
}
