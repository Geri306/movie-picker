package com.gergokovacs.moviepicker.data;

import com.gergokovacs.moviepicker.data.enums.AgeCertification;
import com.gergokovacs.moviepicker.data.enums.Type;

import java.util.List;
import java.util.Objects;

public class Title{
    private String id;
    private String title;
    private Type type;
    private String description;
    private Integer releaseYear;
    private AgeCertification ageCertification;
    private Integer runTime;
    private List<String> genres;
    private List<String> productionCountries;
    private Float seasons;
    private String imdbId;
    private Float imdbScore;
    private Integer imdbVotes;
    private Float tmdbPopularity;
    private Float tmdbScore;

    public Title(String id, String title, Type type, String description, Integer releaseYear, AgeCertification ageCertification, Integer runTime, List<String> genres, List<String> productionCountries, Float seasons, String imdbId, Float imdbScore, Integer imdbVotes, Float tmdbPopularity, Float tmdbScore) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.releaseYear = releaseYear;
        this.ageCertification = ageCertification;
        this.runTime = runTime;
        this.genres = genres;
        this.productionCountries = productionCountries;
        this.seasons = seasons;
        this.imdbId = imdbId;
        this.imdbScore = imdbScore;
        this.imdbVotes = imdbVotes;
        this.tmdbPopularity = tmdbPopularity;
        this.tmdbScore = tmdbScore;
    }

    public Title() {
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Type getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getReleaseYear() {
        return this.releaseYear;
    }

    public AgeCertification getAgeCertification() {
        return this.ageCertification;
    }

    public Integer getRunTime() {
        return this.runTime;
    }

    public List<String> getGenres() {
        return this.genres;
    }

    public List<String> getProductionCountries() {
        return this.productionCountries;
    }

    public Float getSeasons() {
        return this.seasons;
    }

    public String getImdbId() {
        return this.imdbId;
    }

    public Float getImdbScore() {
        return this.imdbScore;
    }

    public Integer getImdbVotes() {
        return this.imdbVotes;
    }

    public Float getTmdbPopularity() {
        return this.tmdbPopularity;
    }

    public Float getTmdbScore() {
        return this.tmdbScore;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setAgeCertification(AgeCertification ageCertification) {
        this.ageCertification = ageCertification;
    }

    public void setRunTime(Integer runTime) {
        this.runTime = runTime;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void setProductionCountries(List<String> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public void setSeasons(Float seasons) {
        this.seasons = seasons;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setImdbScore(Float imdbScore) {
        this.imdbScore = imdbScore;
    }

    public void setImdbVotes(Integer imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public void setTmdbPopularity(Float tmdbPopularity) {
        this.tmdbPopularity = tmdbPopularity;
    }

    public void setTmdbScore(Float tmdbScore) {
        this.tmdbScore = tmdbScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Title)) return false;
        Title title1 = (Title) o;
        return Objects.equals(getId(), title1.getId()) && Objects.equals(getTitle(), title1.getTitle()) &&
                getType() == title1.getType() && Objects.equals(getDescription(), title1.getDescription()) &&
               Objects.equals(getReleaseYear(), title1.getReleaseYear()) &&
                getAgeCertification() == title1.getAgeCertification() && Objects.equals(getRunTime(), title1.getRunTime()) &&
               Objects.equals(getGenres(), title1.getGenres()) && Objects.equals(getProductionCountries(), title1.getProductionCountries()) &&
               Objects.equals(getSeasons(), title1.getSeasons()) && Objects.equals(getImdbId(), title1.getImdbId()) &&
               Objects.equals(getImdbScore(), title1.getImdbScore()) && Objects.equals(getImdbVotes(), title1.getImdbVotes()) &&
               Objects.equals(getTmdbPopularity(), title1.getTmdbPopularity()) && Objects.equals(getTmdbScore(), title1.getTmdbScore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getType(), getDescription(), getReleaseYear(), getAgeCertification(), getRunTime(), getGenres(), getProductionCountries(), getSeasons(), getImdbId(), getImdbScore(), getImdbVotes(), getTmdbPopularity(), getTmdbScore());
    }

    @Override
    public String toString() {
        return "Title{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", ageCertification=" + ageCertification +
                ", runTime=" + runTime +
                ", genres=" + genres +
                ", productionCountries=" + productionCountries +
                ", seasons=" + seasons +
                ", imdbId='" + imdbId + '\'' +
                ", imdbScore=" + imdbScore +
                ", imdbVotes=" + imdbVotes +
                ", tmdbPopularity=" + tmdbPopularity +
                ", tmdbScore=" + tmdbScore +
                '}';
    }
}
