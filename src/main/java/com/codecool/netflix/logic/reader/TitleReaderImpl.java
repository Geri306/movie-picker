package com.codecool.netflix.logic.reader;

import com.codecool.netflix.data.Title;
import com.codecool.netflix.data.enums.AgeCertification;
import com.codecool.netflix.data.enums.Type;
import com.codecool.netflix.logic.util.TypeConverter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TitleReaderImpl extends CsvReader implements TitleReader {
    private final TypeConverter converter;

    public TitleReaderImpl(TypeConverter converter) {
        this.converter = converter;
    }

    @Override
    public List<Title> readAll(String path) throws FileNotFoundException, IOException {
        List<Title> titles = new ArrayList<>();
        InputStream inputStream = getClass().getResourceAsStream(path);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
        //try (BufferedReader br = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
            String line = br.readLine(); // Reading header, Ignoring
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                List<String> fields = super.getFieldsFromLine(line);
                String id = fields.get(0);
                String title = fields.get(1);
                Type type = converter.getTypeValue(fields.get(2));
                String description = fields.get(3);
                Integer releaseYear = converter.getIntegerValue(fields.get(4));
                AgeCertification ageCertification = converter.getAgeCertificationValue(fields.get(5));
                Integer runTime = converter.getIntegerValue(fields.get(6));
                List<String> genres = converter.getListValue(fields.get(7));
                List<String> productionCountries = converter.getListValue(fields.get(8));
                Float seasons = converter.getFloatValue(fields.get(9));
                String imdbId = fields.get(10);
                Float imdbScore = converter.getFloatValue(fields.get(11));
                Integer imdbVotes = converter.getIntegerValue(fields.get(12));
                Float tmdbPopularity = converter.getFloatValue(fields.get(13));
                Float tmdbScore = converter.getFloatValue(fields.get(14));
                titles.add(new Title(id, title, type, description, releaseYear, ageCertification, runTime,
                        genres, productionCountries, seasons, imdbId, imdbScore, imdbVotes, tmdbPopularity, tmdbScore));
            }
            return titles;
        }
    }
}
