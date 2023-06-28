package com.gergokovacs.moviepicker.logic;

import com.gergokovacs.moviepicker.data.Credit;
import com.gergokovacs.moviepicker.data.Title;
import com.gergokovacs.moviepicker.data.enums.Role;
import com.gergokovacs.moviepicker.data.enums.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("FieldCanBeLocal")
public class SimilarityScoreCalculator {
    private final Integer POINT_FOR_SAME_TYPE = 10;
    private final Integer POINT_FOR_EACH_SIMILAR_GENRE = 20;
    private final Integer POINT_FOR_EACH_SIMILAR_ACTOR = 15;
    private final Integer POINT_FOR_EACH_SIMILAR_DIRECTOR = 30;

    public Integer calculateSimilarityScore(Title titleOfInterest, Title comparedTitle, List<Credit> allCredits) {
        Integer scoreBasedOnType = getSimilarityScoreBasedOnType(titleOfInterest.getType(), comparedTitle.getType());
        Integer scoreBasedOnGenre = getSimilarityScoreBasedOnGenre(titleOfInterest.getGenres(), comparedTitle.getGenres());

        List<String> creditsOfInterest = getCastForTitle(titleOfInterest, allCredits);
        List<String> comparedCredits = getCastForTitle(comparedTitle, allCredits);
        Integer scoreBasedOnActors = getSimilarityScoreBasedOnActors(creditsOfInterest, comparedCredits);

        List<String> directorsOfInterest = getDirectorsForTitle(titleOfInterest, allCredits);
        List<String> comparedDirectors = getDirectorsForTitle(comparedTitle, allCredits);
        Integer scoreBasedOnDirectors = getSimilarityScoreBasedOnDirectors(directorsOfInterest, comparedDirectors);

        Integer scoreBasedOnImdbScore = getPointsForImdbScore(titleOfInterest);

        Integer similarityScore = scoreBasedOnType + scoreBasedOnGenre + scoreBasedOnActors + scoreBasedOnDirectors + scoreBasedOnImdbScore;

        return similarityScore;
    }

    private List<String> getCastForTitle(Title title, List<Credit> credits) {
        return credits
                .stream()
                .filter(c -> c.getId().equals(title.getId()))
                .map(Credit::getName)
                .collect(Collectors.toList());
    }

    private List<String> getDirectorsForTitle(Title title, List<Credit> credits) {
        return credits
                .stream()
                .filter(c -> c.getId().equals(title.getId()))
                .filter(c -> c.getRole().equals(Role.DIRECTOR))
                .map(Credit::getName)
                .collect(Collectors.toList());
    }

    private Integer getSimilarityScoreBasedOnType(Type type1, Type type2) {
        return type1.equals(type2) ? POINT_FOR_SAME_TYPE : 0;
    }

    private Integer getSimilarityScoreBasedOnGenre(List<String> genre1, List<String> genre2) {
        List<String> commonItems = new ArrayList<>(genre1);
        commonItems.retainAll(genre2);
        return commonItems.size() * POINT_FOR_EACH_SIMILAR_GENRE;
    }

    private List<String> getCreditsByRole(List<Credit> credits, Role role) {
        return credits.stream().filter(c -> c.getRole().equals(role)).map(Credit::getName).collect(Collectors.toList());
    }

    private Integer getSimilarityScoreBasedOnActors(List<String> actors1, List<String> actors2) {
        List<String> commonItems = new ArrayList<>(actors1);
        commonItems.retainAll(actors2);
        return commonItems.size() * POINT_FOR_EACH_SIMILAR_ACTOR;
    }

    private Integer getSimilarityScoreBasedOnDirectors(List<String> directors1, List<String> directors2) {
        List<String> commonItems = new ArrayList<>(directors1);
        commonItems.retainAll(directors2);
        return commonItems.size() * POINT_FOR_EACH_SIMILAR_DIRECTOR;
    }

    private int getPointsForImdbScore(Title comparedTitle) {
        return Math.round(comparedTitle.getImdbScore());
    }

}
