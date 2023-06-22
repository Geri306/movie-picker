package com.codecool.netflix.data;

import java.util.Objects;

public class TitleWithSimilarityScore {
    private final Title title;
    private final Integer similarityScore;

    public TitleWithSimilarityScore(Title title, Integer similarityScore) {
        this.title = title;
        this.similarityScore = similarityScore;
    }

    public Title getTitle() {
        return this.title;
    }

    public Integer getSimilarityScore() {
        return this.similarityScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TitleWithSimilarityScore)) return false;
        TitleWithSimilarityScore that = (TitleWithSimilarityScore) o;
        return Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getSimilarityScore(), that.getSimilarityScore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getSimilarityScore());
    }

    @Override
    public String toString() {
        return "TitleWithSimilarityScore{" +
                "title=" + title +
                ", similarityScore=" + similarityScore +
                '}';
    }
}
