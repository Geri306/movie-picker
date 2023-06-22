package com.codecool.netflix.logic;

import com.codecool.netflix.data.Credit;
import com.codecool.netflix.data.Title;
import com.codecool.netflix.data.TitleWithSimilarityScore;
import com.codecool.netflix.logic.reader.TitleReader;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TitleManager implements CsvItemCollection {
    private final TitleReader reader;
    private final SimilarityScoreCalculator comparator;
    private List<Title> titles;

    public TitleManager(TitleReader reader, SimilarityScoreCalculator comparator) {
        this.reader = reader;
        this.comparator = comparator;
    }

    @Override
    public void init() throws IOException {
        titles = reader.readAll("/titles.csv");
    }

    public List<Title> getTopNImdbScoreFromTitles(int n) {
        List<Title> myList = titles
                .stream()
                .filter(t -> t.getImdbScore() != null)
                .sorted(Comparator.comparing(Title::getImdbScore).reversed())
                .toList();

        return myList.stream().limit(n).collect(Collectors.toList());
    }

    public List<Credit> getAllCreditsForTitle(String userTitle, List<Credit> credits) throws NoSuchElementException {
        Title title = titles.stream().filter(t -> t.getTitle().equalsIgnoreCase(userTitle)).findAny().orElse(null);
        return credits.stream().filter(c -> c.getId().equals(Objects.requireNonNull(title).getId())).collect(Collectors.toList());
    }

    public List<Title> getTopNImdbScoreFromGivenGenre(String genre, int length) {
        List<Title> titlesFromOneGenre = titles
                .stream()
                .filter(t -> t.getGenres().contains(genre) && t.getImdbScore() != null)
                .sorted(Comparator.comparing(Title::getImdbScore).reversed()).toList();

        return titlesFromOneGenre.stream().limit(length).collect(Collectors.toList());
    }

    public List<TitleWithSimilarityScore> getSimilarMoviesByTitle(String titleName, List<Credit> allCredits, Integer length) throws IOException {

        Title titleOfInterest = titles.stream().filter(t -> t.getTitle().equalsIgnoreCase(titleName)).findAny().orElse(null);

        List<TitleWithSimilarityScore> titlesWithSimilarityScores = new ArrayList<>();

        try {
            titles.stream()
                    .map(title -> new TitleWithSimilarityScore(title, comparator.calculateSimilarityScore(Objects.requireNonNull(titleOfInterest), title, allCredits)))
                    .forEach(titlesWithSimilarityScores::add);
        } catch (Exception e) {
            String errorMsg = String.format("Title with name '%s' not found!\n", titleName);
            throw new NoSuchElementException(errorMsg, e.getCause());
        }

        removeTitleOfInterestFromList(titleOfInterest, titlesWithSimilarityScores);

        titlesWithSimilarityScores.sort(Comparator.comparing(TitleWithSimilarityScore::getSimilarityScore).reversed());

        return titlesWithSimilarityScores.stream().limit(length).collect(Collectors.toList());
    }

    private static void removeTitleOfInterestFromList(Title titleOfInterest, List<TitleWithSimilarityScore> titlesWithSimilarityScores) {
        TitleWithSimilarityScore targetObject = titlesWithSimilarityScores
                .stream()
                .filter(t -> t.getTitle().getTitle().equalsIgnoreCase(titleOfInterest.getTitle()))
                .findAny()
                .orElse(null);
        titlesWithSimilarityScores.remove(targetObject);
    }

    public List<Title> getTitles() {
        return this.titles;
    }
}
