package com.codecool.netflix;

import com.codecool.netflix.ui.Printer;
import com.codecool.netflix.logic.CreditManager;
import com.codecool.netflix.logic.TitleManager;
import com.codecool.netflix.ui.InputScanner;
import com.codecool.netflix.logic.reader.CreditReader;
import com.codecool.netflix.logic.reader.TitleReader;
import com.codecool.netflix.logic.reader.CreditReaderImpl;
import com.codecool.netflix.logic.reader.TitleReaderImpl;
import com.codecool.netflix.logic.SimilarityScoreCalculator;
import com.codecool.netflix.logic.util.TypeConverter;

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
        NetflixApplication application = new NetflixApplication(credits, titles, scanner, printer);

        //read CSVs
        credits.init();
        titles.init();

        application.run();
    }
}
