package com.gergokovacs.moviepicker;

import com.gergokovacs.moviepicker.ui.Printer;
import com.gergokovacs.moviepicker.logic.CreditManager;
import com.gergokovacs.moviepicker.logic.TitleManager;
import com.gergokovacs.moviepicker.ui.InputScanner;
import com.gergokovacs.moviepicker.logic.reader.CreditReader;
import com.gergokovacs.moviepicker.logic.reader.TitleReader;
import com.gergokovacs.moviepicker.logic.reader.CreditReaderImpl;
import com.gergokovacs.moviepicker.logic.reader.TitleReaderImpl;
import com.gergokovacs.moviepicker.logic.SimilarityScoreCalculator;
import com.gergokovacs.moviepicker.logic.util.TypeConverter;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        InputScanner scanner = new InputScanner();
        Printer printer = new Printer();
        TypeConverter converter = new TypeConverter();
        CreditReader creditReader = new CreditReaderImpl();
        TitleReader titleReader = new TitleReaderImpl(converter);
        SimilarityScoreCalculator similarityScoreCalculator = new SimilarityScoreCalculator();
        CreditManager credits = new CreditManager(creditReader);
        TitleManager titles = new TitleManager(titleReader, similarityScoreCalculator);
        MoviePicker application = new MoviePicker(credits, titles, scanner, printer);

        //read CSVs
        credits.init();
        titles.init();

        application.run();
    }
}
