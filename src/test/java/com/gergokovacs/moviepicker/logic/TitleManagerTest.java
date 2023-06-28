package com.gergokovacs.moviepicker.logic;

import com.gergokovacs.moviepicker.data.Title;
import com.gergokovacs.moviepicker.logic.reader.TitleReader;
import com.gergokovacs.moviepicker.logic.reader.TitleReaderImpl;
import com.gergokovacs.moviepicker.logic.util.TypeConverter;
import com.google.common.collect.Ordering;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TitleManagerTest {
    TypeConverter typeConverter = new TypeConverter();
    TitleReader titleReader = new TitleReaderImpl(typeConverter);
    @Mock
    SimilarityScoreCalculator similarityScoreCalculatorMock;
    TitleManager titleManager = new TitleManager(titleReader, similarityScoreCalculatorMock);

    @BeforeEach
    void setUp() throws IOException {
        titleManager.init();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 40, 999})
    void getTopNImdbScoreFromTitles_returnsListOfTitles_inWantedSizeAndInDescendingOrder(int n) {
        List<Title> titles = titleManager.getTopNImdbScoreFromTitles(n);
        boolean isDescending = Ordering
                .natural()
                .reverse()
                .onResultOf(Title::getImdbScore)
                .isOrdered(titles);

        assertEquals(n, titles.size());
        assertTrue(isDescending);
    }
}