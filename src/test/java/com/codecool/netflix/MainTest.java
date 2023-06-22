package com.codecool.netflix;

import com.codecool.netflix.logic.CreditManager;
import com.codecool.netflix.logic.SimilarityScoreCalculator;
import com.codecool.netflix.logic.TitleManager;
import com.codecool.netflix.logic.reader.CreditReader;
import com.codecool.netflix.logic.reader.CreditReaderImpl;
import com.codecool.netflix.logic.reader.TitleReader;
import com.codecool.netflix.logic.reader.TitleReaderImpl;
import com.codecool.netflix.logic.util.TypeConverter;
import com.codecool.netflix.ui.InputScanner;
import com.codecool.netflix.ui.Printer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class MainTest {

    @Test
    void getTopNMovies_firstOneShouldBe_Khawatir() throws IOException {
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




        // application.run();
        // TODO: at this point there should be an input ('1') through the console followed by e.g. ('3');


        /**
         * OR:
         * here I "hijack" the main route and invoke directly only the ...
         * ... method that delivers the necessary information for the assertion.
         */


        // get top n movie titles and get the name of the best movie (first one in the list)
        int listLength = 3;
        int indexOfBestMovie = 0;
        String result = titles.getTopNImdbScoreFromTitles(listLength).get(indexOfBestMovie).getTitle();
        String expected = "Khawatir";

        Assertions.assertEquals(expected, result);
    }

    @BeforeEach
    void prepareTest() {
        // initialisation
    }

}

